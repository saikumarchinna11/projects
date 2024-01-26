package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dc_education")
public class DcEducationEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer	EDU_ID	;				
 private Integer	CASE_NUM;				
 private String	HIGHEST_QUALIFICATION	;               
 private Integer	GRADUTATION_YEAR;
 
public Integer getEDU_ID() {
	return EDU_ID;
}
public void setEDU_ID(Integer eDU_ID) {
	EDU_ID = eDU_ID;
}
public Integer getCASE_NUM() {
	return CASE_NUM;
}
public void setCASE_NUM(Integer cASE_NUM) {
	CASE_NUM = cASE_NUM;
}
public String getHIGHEST_QUALIFICATION() {
	return HIGHEST_QUALIFICATION;
}
public void setHIGHEST_QUALIFICATION(String hIGHEST_QUALIFICATION) {
	HIGHEST_QUALIFICATION = hIGHEST_QUALIFICATION;
}
public Integer getGRADUTATION_YEAR() {
	return GRADUTATION_YEAR;
}
public void setGRADUTATION_YEAR(Integer gRADUTATION_YEAR) {
	GRADUTATION_YEAR = gRADUTATION_YEAR;
}
	
	
	
}
