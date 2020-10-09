package com.example.DbtoFile.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BatchConfig {

    @Value("${filetodb.datasource.url}")
    private String url;

    @Value("${filetodb.datasource.username}")
    private String username;

    @Value("${filetodb.datasource.password}")
    private String password;

    @Value("${filetodb.datasource.driverClassName}")
    private String driverClassName;

    @Value("${filetodb.datasource.sqlquery}")
    private String sqlquery;

    @Value("${filetodb.destinationpath}")
    private String destinationpath;

    @Value("${filetodb.chunksize}")
    private Integer chunksize;





}
