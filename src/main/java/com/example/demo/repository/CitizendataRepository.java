package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CitizenData;

@Repository
public interface CitizendataRepository extends JpaRepository<CitizenData, Integer> {

}
