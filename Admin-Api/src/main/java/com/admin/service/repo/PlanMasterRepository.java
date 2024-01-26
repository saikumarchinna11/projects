package com.admin.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.PlanEntity;



public interface PlanMasterRepository extends  JpaRepository<PlanEntity, Integer> {

}
