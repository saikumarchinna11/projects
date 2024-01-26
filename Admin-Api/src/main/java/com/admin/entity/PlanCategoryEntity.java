package com.admin.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategoryEntity {
		
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryid;
	
	@Column(name="categoryname")
	private String categoryname;
	
	
	@Column(name="ACTIVE_SW")
	private String activesw;
	
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createddate;
	
	@Column(name="UPDATE_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updateddate;
	
	@Column(name="CREATED_BY")
	private String createdby;
	
		
	@Column(name="UPDATED_BY")
	private String updatedby;
	
	
	
	public Integer getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}


	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public String getActivesw() {
		return activesw;
	}


	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}


	public LocalDate getCreateddate() {
		return createddate;
	}


	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}


	public LocalDate getUpdateddate() {
		return updateddate;
	}


	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public String getUpdatedby() {
		return updatedby;
	}


	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}


	

	
	
}
