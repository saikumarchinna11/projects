package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dc_childrens")
public class DcChildrensEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer CHILDREN_ID;
	
	 private Integer CASE_NUM;	
	 
	 private Integer CHILDREN_DOB;	
	 
    private Integer	CHILDREN_SSN;

	public Integer getCHILDREN_ID() {
		return CHILDREN_ID;
	}

	public void setCHILDREN_ID(Integer cHILDREN_ID) {
		CHILDREN_ID = cHILDREN_ID;
	}

	public Integer getCASE_NUM() {
		return CASE_NUM;
	}

	public void setCASE_NUM(Integer cASE_NUM) {
		CASE_NUM = cASE_NUM;
	}

	public Integer getCHILDREN_DOB() {
		return CHILDREN_DOB;
	}

	public void setCHILDREN_DOB(Integer cHILDREN_DOB) {
		CHILDREN_DOB = cHILDREN_DOB;
	}

	public Integer getCHILDREN_SSN() {
		return CHILDREN_SSN;
	}

	public void setCHILDREN_SSN(Integer cHILDREN_SSN) {
		CHILDREN_SSN = cHILDREN_SSN;
	}	        


	
	

}
