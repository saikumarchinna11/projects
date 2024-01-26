package com.main.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_worker_info")
public class CaseWorkerEntity {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ACC_ID;

	private String FULLNAME;

	private String EMAIL;

	private String PWD;

	private Integer PHNO;

	private Character GENDER;

	private Integer SSN;

	private LocalDate DOB;

	private String ACTIVE_SW;

	private LocalDate CREATE_DATE;

	private LocalDate UPDATED_DATE;

	private String CREATED_BY;

	private String UPDATED_BY;

	public Integer getACC_ID() {
		return ACC_ID;
	}

	public void setACC_ID(Integer aCC_ID) {
		ACC_ID = aCC_ID;
	}

	public String getFULLNAME() {
		return FULLNAME;
	}

	public void setFULLNAME(String fULLNAME) {
		FULLNAME = fULLNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public Integer getPHNO() {
		return PHNO;
	}

	public void setPHNO(Integer pHNO) {
		PHNO = pHNO;
	}

	public Character getGENDER() {
		return GENDER;
	}

	public void setGENDER(Character gENDER) {
		GENDER = gENDER;
	}

	public Integer getSSN() {
		return SSN;
	}

	public void setSSN(Integer sSN) {
		SSN = sSN;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getACTIVE_SW() {
		return ACTIVE_SW;
	}

	public void setACTIVE_SW(String aCTIVE_SW) {
		ACTIVE_SW = aCTIVE_SW;
	}

	public LocalDate getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(LocalDate cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	public LocalDate getDATE() {
		return UPDATED_DATE;
	}

	public void setDATE(LocalDate dATE) {
		UPDATED_DATE = dATE;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public String getUPDATED_BY() {
		return UPDATED_BY;
	}

	public void setUPDATED_BY(String uPDATED_BY) {
		UPDATED_BY = uPDATED_BY;
	}

}
