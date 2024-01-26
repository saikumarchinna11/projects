package com.admin.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.IesUsers;

@Repository
public interface UsersRepo extends JpaRepository<IesUsers, Integer> {
	
	public IesUsers findByemaiId(String emailId);
	
	

}
