package com.example.DbtoFile.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Autowired
    BatchConfig config;

    @Bean("dataSource")
    public DataSource dataSource()
    {

        return DataSourceBuilder
                .create()
                .url(config.getUrl())
                .driverClassName(config.getDriverClassName())
                .username(config.getUsername())
                .password(config.getPassword())
                .build();
    }
}
