package com.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.PlanCategoryEntity;
import com.admin.entity.PlanEntity;
import com.admin.service.repo.CategoryRepository;
import com.admin.service.repo.PlanMasterRepository;


@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
    private PlanMasterRepository  planMasterRepository;
	
	@Autowired
	private  CategoryRepository  categoryRepository;

	@Override
	public Map<Integer, String> getAllCategories() {
		
		List<PlanCategoryEntity> findAll = categoryRepository.findAll();
		
		 Map<Integer, String> map = findAll.stream().collect(
	                Collectors.toMap(PlanCategoryEntity::getCategoryid, PlanCategoryEntity::getCategoryname));

		
		return  map;
	}

	@Override
	public boolean savePlan(PlanEntity entity) {
		
		PlanEntity save = planMasterRepository.save(entity);
			
		return  save.getPlanid()!=null;
	}

	@Override
	public List<PlanEntity> getAllPlans() {
		List<PlanEntity> findAll = planMasterRepository.findAll();
		return findAll;
	}

	@Override
	public PlanEntity getPlanById(Integer planid) {
	 Optional<PlanEntity> findById = planMasterRepository.findById(planid);
	 
	  
	 if(findById.isPresent()) {
		 return findById.get();
	 }
		
		return null;
	}

	@Override
	public boolean updatePlan(PlanEntity entity) {
		  PlanEntity save = planMasterRepository.save(entity);  
		
		return save.getPlanid()!=null;
	}
	

	@Override
	public boolean deleteById(Integer planid) {
		 
		//planMasterRepository.deleteById(planid);
		boolean status=false;
		
		try {
			
			planMasterRepository.deleteById(planid);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planid, String activeSW) {
		    Optional<PlanEntity> findById = planMasterRepository.findById(planid);
		    
		    if(findById.isPresent()) {
		             PlanEntity planEntity = findById.get();
		             planEntity.setActivesw(activeSW);
		             planMasterRepository.save(planEntity);
		             return true;
		    }
		
		return false;
	}


}
