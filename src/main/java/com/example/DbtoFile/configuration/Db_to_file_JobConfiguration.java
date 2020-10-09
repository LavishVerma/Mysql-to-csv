package com.example.DbtoFile.configuration;

import com.example.DbtoFile.listener.ProcessorListener;
import com.example.DbtoFile.listener.ReaderListener;
import com.example.DbtoFile.listener.StepListener;
import com.example.DbtoFile.listener.WriterListener;
import com.example.DbtoFile.model.Covid;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class Db_to_file_JobConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    ItemProcessor<Covid,Covid> db_to_fileProcessor;

    @Autowired
    ReaderListener readerListener;

    @Autowired
    WriterListener writerListener;

    @Autowired
    ProcessorListener processorListener;

    @Autowired
    StepListener stepListener;

    @Autowired
    DataSource dataSource;

    @Autowired
    BatchConfig config;

    @Bean
    public Job Db_to_file_Job() {
        return jobBuilderFactory.get("Dbtofilejob")
                .incrementer(new RunIdIncrementer())
                .flow(dbtofileStep())
                .end()
                .build();
    }

    @Bean
    public Step dbtofileStep() {
        return stepBuilderFactory.get("dbtofileStep")
                .<Covid,Covid>chunk(config.getChunksize())
                .reader(jdbcCursorItemReader())
                .processor(db_to_fileProcessor)
                .writer(db_to_fileWriter())
                .listener(readerListener)
                .listener(processorListener)
                .listener(writerListener)
                .listener(stepListener)
                .build();


    }


    @Bean
    public JdbcCursorItemReader<Covid> jdbcCursorItemReader()
    {
        return new JdbcCursorItemReaderBuilder<Covid>()
                .name("dbtofileReader")
                .dataSource(dataSource)
                .fetchSize(100)
                .sql(config.getSqlquery())
                .rowMapper(new BeanPropertyRowMapper<>(Covid.class))
                .build();
    }

    @Bean
    public FlatFileItemWriter<Covid> db_to_fileWriter() {
        return new FlatFileItemWriterBuilder<Covid>()
                .name("movieGenreWriter")
                .resource(new FileSystemResource(config.getDestinationpath()))
                .headerCallback(writer -> writer.write("id,agebracket, contractedfromwhichpatientsuspected,currentstatus,dateannounced,detectedcity,detecteddistrict,detectedstate,entryid,gender,nationality,notes ,numcases,patientnumber,source1,source2 ,source3,statecode,statepatientnumber,statuschangedate,typeoftransmission"))
                .delimited()
                .delimiter(",")
                .names(new String[]{ "id" ,"agebracket", "contractedfromwhichpatientsuspected","currentstatus", "dateannounced", "detectedcity" , "detecteddistrict"  ,"detectedstate", "entryid","gender", "nationality" ,"notes" ,"numcases","patientnumber","source1","source2"  , "source3","statecode","statepatientnumber","statuschangedate","typeoftransmission"})
                .build();
    }
}
