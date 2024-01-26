package com.admin.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.PlanCategoryEntity;



public interface CategoryRepository  extends JpaRepository<PlanCategoryEntity, Integer>{

}
