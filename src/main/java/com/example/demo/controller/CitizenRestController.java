package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CitizenData;
import com.example.demo.repository.CitizendataRepository;
import com.example.demo.service.Citizenservice;

@RestController
public class CitizenRestController {
	
	@Autowired
	private CitizendataRepository repository;
	
	
	 @GetMapping("/key-value/{ssn}")
	    public String getValueForKey(@PathVariable Integer ssn) {
	        Optional<CitizenData> keyValueOptional = repository.findById(ssn);

	        if (keyValueOptional.isPresent()) {
	            return keyValueOptional.get().getStatename();
	        } else {
	            return "Key not found";
	        }
	    }
	

}
