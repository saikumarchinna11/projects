package com.admin.RestController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.binding.IesUserBinding;
import com.admin.binding.Login;
import com.admin.binding.UnlockAccount;
import com.admin.constants.AppConstants;
import com.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/user")
	public   ResponseEntity<String> createAccCw(@RequestBody  IesUserBinding iesUserBinding) throws IOException{
		
		logger.debug("Account creation process started");
		
		boolean createAccountCw = adminService.createAccountCw(iesUserBinding);
		
		logger.debug("Account creation process completed");
		
		if(createAccountCw) {
			
			logger.info("Account created sucessfully");
			return new ResponseEntity<>(AppConstants.ACC_CREATED_SUCC,HttpStatus.CREATED);
		}else {
			logger.info("Account created failed");
			return new ResponseEntity<>(AppConstants.ACC_NOT_CREATED,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/ActivateUser")
	public ResponseEntity<String> activateAcc(@RequestBody UnlockAccount account) {
           
		logger.debug("Account unlock process stared ");
		
		  String unlockAccount = adminService.unlockAccount(account);
		  
		  logger.debug("Account unlock process completed");

		if (unlockAccount!=null) {
			
			logger.info("Account unlock sucessfully completed");
			return new ResponseEntity<String>(AppConstants.ACC_ACTIVATED_SUCC, HttpStatus.OK);
		} else {
			
			logger.info("Account unlock is faild due to incprrect password");
			return new ResponseEntity<String>(AppConstants.INVALID_TEMP_PWD, HttpStatus.BAD_REQUEST);
		}

	}

	
	@GetMapping("/ALLACC")
	public ResponseEntity<List<IesUserBinding>>getAllAcc(){
		
		logger.debug("all accounts are fecthning process is started");
		
		List<IesUserBinding> allAccounts = adminService.getAllAccounts();
		
		logger.info("All accounts are fetched sucessfully");
		
		return new ResponseEntity<>(allAccounts,HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<IesUserBinding>accDetailsUpdated(@PathVariable Integer userId){
		
		logger.debug("Account updatation process is started");
		
		IesUserBinding editAccount = adminService.editAccount(userId);
		
		logger.info("Account updation is sucessfully");
		
		return new ResponseEntity<IesUserBinding>(editAccount,HttpStatus.OK);
		
	}
	
	@PutMapping("/{userId}/{accstatus}")
	public ResponseEntity<String>changeAccSW(@PathVariable Integer userId,@PathVariable String accstatus ){
	      
		logger.debug("Account status change process is started");
		
		boolean changeAccStatus = adminService.changeAccStatus(userId, accstatus);
		
		logger.debug("Account status change process is ended");
		
		if(changeAccStatus) {
			
			logger.info("Account status is changed sucessfully");
			return new ResponseEntity<String>(AppConstants.ACC_STATUS_CHANGED,HttpStatus.OK);
		}else {
			
			logger.info("Account status is not changed");
			
			return new ResponseEntity<String>(AppConstants.ACC_STATUS_NOTCHANGED,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/loginapi")
	public ResponseEntity<String>loginAcc(@RequestBody Login login){
		
		logger.debug("Login is process is staated");
		
		String loginCwAccount = adminService.LoginCwAccount(login);
		
		logger.info("Login in to the application is completed");
		
		return new ResponseEntity<String>(loginCwAccount, HttpStatus.OK);
		
	}
	
	@GetMapping("/emailId/{emaiId}")
	public ResponseEntity<String>forgotpwd(@PathVariable String emaiId){
		
		logger.debug("");
		
		boolean forgotPwd = adminService.forgotPwd(emaiId);
		
		return  new ResponseEntity(forgotPwd,HttpStatus.OK);
	}
	
	
	
	
	

}
