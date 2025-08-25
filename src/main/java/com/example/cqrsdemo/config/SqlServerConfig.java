package com.example.cqrsdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "spring.datasource.url")
@EnableJpaRepositories(basePackages = "com.example.cqrsdemo.repository")
public class SqlServerConfig {
    
}
