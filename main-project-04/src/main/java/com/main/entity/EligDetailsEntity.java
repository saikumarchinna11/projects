package com.main.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Eligi_details")
public class EligDetailsEntity {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer ELIG_ID;				
 private Integer	CASE_NUM;			
 private String	PLAN_NAME	;			
 private String	PLAN_STATUS	;			
 private LocalDate	PLAN_START_DATE	;	        
 private LocalDate	PLAN_END_DATE	;		
 private Integer	BENEFIT_AMT		;		
 private String	DENIAL_REASON	;
public Integer getELIG_ID() {
	return ELIG_ID;
}
public void setELIG_ID(Integer eLIG_ID) {
	ELIG_ID = eLIG_ID;
}
public Integer getCASE_NUM() {
	return CASE_NUM;
}
public void setCASE_NUM(Integer cASE_NUM) {
	CASE_NUM = cASE_NUM;
}
public String getPLAN_NAME() {
	return PLAN_NAME;
}
public void setPLAN_NAME(String pLAN_NAME) {
	PLAN_NAME = pLAN_NAME;
}
public String getPLAN_STATUS() {
	return PLAN_STATUS;
}
public void setPLAN_STATUS(String pLAN_STATUS) {
	PLAN_STATUS = pLAN_STATUS;
}
public LocalDate getPLAN_START_DATE() {
	return PLAN_START_DATE;
}
public void setPLAN_START_DATE(LocalDate pLAN_START_DATE) {
	PLAN_START_DATE = pLAN_START_DATE;
}
public LocalDate getPLAN_END_DATE() {
	return PLAN_END_DATE;
}
public void setPLAN_END_DATE(LocalDate pLAN_END_DATE) {
	PLAN_END_DATE = pLAN_END_DATE;
}
public Integer getBENEFIT_AMT() {
	return BENEFIT_AMT;
}
public void setBENEFIT_AMT(Integer bENEFIT_AMT) {
	BENEFIT_AMT = bENEFIT_AMT;
}
public String getDENIAL_REASON() {
	return DENIAL_REASON;
}
public void setDENIAL_REASON(String dENIAL_REASON) {
	DENIAL_REASON = dENIAL_REASON;
}		


}
