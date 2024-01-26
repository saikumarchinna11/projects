package com.admin.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Data
@EnableConfigurationProperties
@ConfigurationProperties("planapi")
@Configuration
public class AppProperties {
	
	
	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}

	Map<String,String> messages=new HashMap();
	
	

}
