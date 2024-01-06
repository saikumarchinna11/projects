package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.CitizenData;

@SpringBootApplication
public class ThirdpartyApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(ThirdpartyApi2Application.class, args);
		
		CitizenData data=new CitizenData();
		data.setSsn(2);
		data.setStatename("new jersey");
	}

}
