package com.main.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Co_triggers")
public class CoTriggersEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer TRG_ID	;	
	 private Integer CASE_NUM;	
	 private Character 	CHAR;
	 private Blob       NOTICE;
	 
	public Integer getTRG_ID() {
		return TRG_ID;
	}
	public void setTRG_ID(Integer tRG_ID) {
		TRG_ID = tRG_ID;
	}
	public Integer getCASE_NUM() {
		return CASE_NUM;
	}
	public void setCASE_NUM(Integer cASE_NUM) {
		CASE_NUM = cASE_NUM;
	}
	public Character getCHAR() {
		return CHAR;
	}
	public void setCHAR(Character cHAR) {
		CHAR = cHAR;
	}
	public Blob getNOTICE() {
		return NOTICE;
	}
	public void setNOTICE(Blob nOTICE) {
		NOTICE = nOTICE;
	}


	
	

}
