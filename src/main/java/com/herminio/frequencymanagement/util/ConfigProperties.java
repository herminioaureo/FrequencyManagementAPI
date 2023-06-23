package com.herminio.frequencymanagement.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@PropertySource("classpath:frequencyconfig.properties")
public class ConfigProperties {
	
	@Value("${frequencyapi.datasource.username}")
	private String databaseUsername;
	@Value("${frequencyapi.datasource.password}")
	private String databasePassword;

}
