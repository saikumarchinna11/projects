package com.admin.binding;

public class UnlockAccount {

	
	 private String emailId;
	 
	 private String newpassword;
	 
	 private String temppassword;
	 
	 private String confirmpass;

	

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getTemppassword() {
		return temppassword;
	}

	public void setTemppassword(String temppassword) {
		this.temppassword = temppassword;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	 
}
