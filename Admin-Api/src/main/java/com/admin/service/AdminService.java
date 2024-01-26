package com.admin.service;

import java.io.IOException;
import java.util.List;

import com.admin.binding.DashboardCard;
import com.admin.binding.IesUserBinding;
import com.admin.binding.Login;
import com.admin.binding.UnlockAccount;
import com.admin.entity.IesUsers;


public interface AdminService {
	
	public boolean createAccountCw(IesUserBinding bindng) throws IOException;
	
	//public void sendEmail(IesUserBinding iesUserBinding);
	
	public List<IesUserBinding> getAllAccounts();
	
	public IesUserBinding editAccount(Integer userId);
	
	public boolean changeAccStatus(Integer userId, String accstatus);
	
	public String LoginCwAccount(Login  login);
	
	public boolean forgotPwd(String emaiId) ;
	
	public String unlockAccount(UnlockAccount unlockAccount);
	
	 public DashboardCard fetchDashboardInfo();
	
	
	
	
	
	
	
	
	
	
	
	
	
	 

}
