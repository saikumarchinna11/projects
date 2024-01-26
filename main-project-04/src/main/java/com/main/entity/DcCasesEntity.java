package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dc_cases")
public class DcCasesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CASE_ID;
	
	
	private Integer CASE_NUM;
	
	private  Integer APP_ID;
	
	private Integer PLAN_ID;

	public Integer getCASE_ID() {
		return CASE_ID;
	}

	public void setCASE_ID(Integer cASE_ID) {
		CASE_ID = cASE_ID;
	}

	public Integer getCASE_NUM() {
		return CASE_NUM;
	}

	public void setCASE_NUM(Integer cASE_NUM) {
		CASE_NUM = cASE_NUM;
	}

	public Integer getAPP_ID() {
		return APP_ID;
	}

	public void setAPP_ID(Integer aPP_ID) {
		APP_ID = aPP_ID;
	}

	public Integer getPLAN_ID() {
		return PLAN_ID;
	}

	public void setPLAN_ID(Integer pLAN_ID) {
		PLAN_ID = pLAN_ID;
	}
	

}
