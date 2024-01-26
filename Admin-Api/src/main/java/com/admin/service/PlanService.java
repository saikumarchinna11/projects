package com.admin.service;

import java.util.*;

import com.admin.entity.PlanEntity;

public interface PlanService {
	
	
	public  Map<Integer, String> getAllCategories();
	
	public boolean savePlan(PlanEntity entity);
	
	public List<PlanEntity> getAllPlans();
	
	public PlanEntity getPlanById(Integer planid);
	
	public boolean updatePlan (PlanEntity entity);
	
	public boolean deleteById(Integer planid);
	
	public boolean  planStatusChange(Integer planid,String activeSW);
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
