package com.admin.binding;

public class DashboardCard {
	
	
	private Long plansCnt;
	private Long approvedCnt;
	private Long deniedCnt;
	private Double beniftAmtGiven;
	
	private IesUserBinding user;

	public Long getPlansCnt() {
		return plansCnt;
	}

	public void setPlansCnt(Long plansCnt) {
		this.plansCnt = plansCnt;
	}

	public Long getApprovedCnt() {
		return approvedCnt;
	}

	public void setApprovedCnt(Long approvedCnt) {
		this.approvedCnt = approvedCnt;
	}

	public Long getDeniedCnt() {
		return deniedCnt;
	}

	public void setDeniedCnt(Long deniedCnt) {
		this.deniedCnt = deniedCnt;
	}

	public IesUserBinding getUser() {
		return user;
	}

	public void setUser(IesUserBinding user) {
		this.user = user;
	}

	public Double getBeniftAmtGiven(double total) {
		return beniftAmtGiven;
	}

	public void setBeniftAmtGiven(Double beniftAmtGiven) {
		this.beniftAmtGiven = beniftAmtGiven;
	}

	

}
