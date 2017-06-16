package com.verge.infrastructure.db;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceMigration {

    @Autowired
    private DataSourceConfig config;

    @Bean(initMethod = "migrate")
    Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(config.getUrl(), config.getUsername(), config.getPassword());
        flyway.setLocations(config.getFlywayLocations());
        return flyway;
    }
}
