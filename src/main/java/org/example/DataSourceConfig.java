package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
public class DataSourceConfig {

    private final DataClass dataClass;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
/*
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(connectionString);
        config.setUsername(username);
        config.setPassword(password);
*/


        return DataSourceBuilder.create()
                .url(dataClass.getUrl())
                .username(dataClass.getUsername())
                .password(dataClass.getPassword())
                .driverClassName(dataClass.getDriverClassName())
                .build();
    }
}


