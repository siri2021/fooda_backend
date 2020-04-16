package it.vkod.woo.auth.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("webuser");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost:3306/woo_auth_db?createDatabaseIfNotExist=true");

        return dataSource;
    }

}

