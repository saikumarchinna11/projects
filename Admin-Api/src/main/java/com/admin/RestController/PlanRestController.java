package com.admin.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.constants.AppConstants;
import com.admin.entity.PlanEntity;
import com.admin.properties.AppProperties;
import com.admin.service.PlanService;


@RestController
public class PlanRestController {
	
	
	private PlanService planService;
	
	
	private AppProperties appProperties;
	
	//public Map<String, String> messages = appProperties.getMessages();
	
	public Map<String, String> messages;
	
	public PlanRestController(PlanService planService, AppProperties appProperties) {
		super();
		this.planService = planService;
		messages = appProperties.getMessages();
	}


	
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getCategories(){
		  
		Map<Integer, String> allCategories = planService.getAllCategories();
		
		return  new ResponseEntity<>(allCategories,HttpStatus.OK);
		
	}
	
	@PostMapping("/plans")
	public ResponseEntity<String> savePlan(@RequestBody PlanEntity entity){
		
	boolean issaved = planService.savePlan(entity);
		
	//	Map<String, String> messages = appProperties.getMessages();

		
		String msg=AppConstants.EMP_STR;
		
		if(issaved) {
			msg=messages.get(AppConstants.PLAN_SAVE_SUCC);
		}else {
			msg=messages.get(AppConstants.PLAN_FAIL_SAVE);
		}
		
             return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/allplans")
	public ResponseEntity<List<PlanEntity>>getAllPlans(){
		    
		 List<PlanEntity> allPlans = planService.getAllPlans();
		 
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyid/{planid}")
	public ResponseEntity<PlanEntity>editPlanById(@PathVariable  Integer planid){
		
		 PlanEntity planById = planService.getPlanById(planid);
		  
		return new ResponseEntity<>(planById,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/getbyid/{planid}")
	public ResponseEntity<String>deletePlanById(@PathVariable  Integer planid){
		
		 boolean deleteById = planService.deleteById(planid);
		 
		// Map<String, String> messages = appProperties.getMessages();
		 
		 String msg=AppConstants.EMP_STR;
	 	 
		 if(deleteById) {
			 
			 msg=messages.get(AppConstants.PLAN_DELE_SUCC);
			 
		 }else {
			 msg=messages.get(AppConstants.PLAN_DELE_SUCC);
		 }
		return new ResponseEntity<>(msg,HttpStatus.OK);
		  
	}
	
	
	@PutMapping("/plans")
	public ResponseEntity<String>UpdatePlans(@RequestBody  PlanEntity entity){
		
		
		boolean updatePlan = planService.updatePlan(entity);
		
	//	 Map<String, String> messages = appProperties.getMessages();
		 
		String msg=AppConstants.EMP_STR;
		
		if(updatePlan) {
			
			msg=messages.get(AppConstants.PLAN_UPDATE_SUCC);
			
		}else {
			msg=messages.get(AppConstants.PLAN_UPDATE_FAIL);
		}
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planid}/{activesw}")
	public ResponseEntity<String>activeSw(@PathVariable Integer planid,@PathVariable String activesw){
		
		boolean planStatusChange = planService.planStatusChange(planid, activesw);
		
	//	Map<String, String> messages = appProperties.getMessages();
		
		String msg=AppConstants.EMP_STR;
		
		if (planStatusChange) {
			msg=messages.get(AppConstants.PLAN_STATUS_SUCC);
		}else {
			msg=messages.get(AppConstants.PLAN_STATUS_FAIL);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	

}
