package com.herminio.frequencymanagement.datasource;

import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
    public DataSource getDatasourceConnection() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/frequencydb");
        dataSourceBuilder.username(new String(Base64.getDecoder().decode(env.getProperty("frequencyapi.datasource.username")))); // Base64 encoded string for : "root"
        dataSourceBuilder.password(new String(Base64.getDecoder().decode(env.getProperty("frequencyapi.datasource.password")))); // Base64 encoded string for : "frequencydb"
        
        return dataSourceBuilder.build();
    }
}
