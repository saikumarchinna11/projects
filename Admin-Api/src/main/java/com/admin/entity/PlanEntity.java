package com.admin.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PLAN_TABLE")
public class PlanEntity {

	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planid;
	
	@Column(name = "PLAN_NAME")
	private String planname;

	@Column(name = "PLAN_STARTDATE")
	private LocalDate planstartdate;

	@Column(name = "PLAN_ENDDATE")
	private LocalDate planenddate;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer plancategory_id;

	@Column(name = "ACTIVE_SW")
	private String activesw;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createddate;

	@Column(name = "UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateddate;

	@Column(name = "CREATED_BY")
	private String createdby;

	@Column(name = "UPDATED_BY")
	private String updatedby;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private IesUsers users;
	

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public LocalDate getPlanstartdate() {
		return planstartdate;
	}

	public void setPlanstartdate(LocalDate planstartdate) {
		this.planstartdate = planstartdate;
	}

	public LocalDate getPlanenddate() {
		return planenddate;
	}

	public void setPlanenddate(LocalDate planenddate) {
		this.planenddate = planenddate;
	}

	public Integer getPlancategory_id() {
		return plancategory_id;
	}

	public void setPlancategory_id(Integer plancategory_id) {
		this.plancategory_id = plancategory_id;
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
