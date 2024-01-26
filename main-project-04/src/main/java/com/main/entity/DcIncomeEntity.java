package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DC_income")
public class DcIncomeEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer INCOME_ID;
	
	private Integer CASE_NUM;
	
	private Integer  EMP_INCOME;
	
	private Integer PROPERTY_INCOME;

	public Integer getINCOME_ID() {
		return INCOME_ID;
	}

	public void setINCOME_ID(Integer iNCOME_ID) {
		INCOME_ID = iNCOME_ID;
	}

	public Integer getCASE_NUM() {
		return CASE_NUM;
	}

	public void setCASE_NUM(Integer cASE_NUM) {
		CASE_NUM = cASE_NUM;
	}

	public Integer getEMP_INCOME() {
		return EMP_INCOME;
	}

	public void setEMP_INCOME(Integer eMP_INCOME) {
		EMP_INCOME = eMP_INCOME;
	}

	public Integer getPROPERTY_INCOME() {
		return PROPERTY_INCOME;
	}

	public void setPROPERTY_INCOME(Integer pROPERTY_INCOME) {
		PROPERTY_INCOME = pROPERTY_INCOME;
	}
	
	
	

}
