package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenData;
import com.example.demo.repository.CitizendataRepository;

@Service
public class Citizenservice {
	
	@Autowired
	private CitizendataRepository repository;

	
	
public Map<Integer, String> getstatenamesss() {
		
		List<CitizenData> findAll = repository.findAll();
		
		 Map<Integer, String> map = findAll.stream().collect(
				 Collectors.toMap(CitizenData::getSsn, CitizenData::getStatename));
//		 
//		if(map.containsKey(4)) {
//			
//			return map.put(null, null) 
//			
//		}

		 
		 return map;
}


}
