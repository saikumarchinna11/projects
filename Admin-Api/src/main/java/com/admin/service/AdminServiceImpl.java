package com.admin.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.admin.binding.DashboardCard;
import com.admin.binding.IesUserBinding;
import com.admin.binding.Login;
import com.admin.binding.UnlockAccount;
import com.admin.constants.AppConstants;
import com.admin.entity.EligEntity;
import com.admin.entity.IesUsers;
import com.admin.service.repo.ElgRepo;
import com.admin.service.repo.PlanMasterRepository;
import com.admin.service.repo.UsersRepo;

import com.admin.utils.EmailUtils;




@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private EmailUtils util;
	
	@Autowired
	private PlanMasterRepository masterRepository;
	
	@Autowired
	private ElgRepo elgRepo;


	@Override
	public boolean createAccountCw(IesUserBinding bindng) throws IOException {
		
		IesUsers users=new IesUsers();
		BeanUtils.copyProperties(bindng, users);
		
		users.setPwd(generateRandomPass());
		users.setActiveSw("Y");
		users.setAccStatus("UNLOCKED");
		
	
		IesUsers save = usersRepo.save(users);
		
		
//		String subject = "Your Registration is successfull";
//
//		String filename = "EmailBody.txt";
//
//		String body = readEmailBody(users.getFullName(), users.getPwd(), filename);
//
//		util.sendEmail(users.getEmaiId(), subject, body);
//
//		return save.getUserId() != null;
		
		// send email
				String subject = "UserRegistration";
				String body = readEmailBody("EmailBody.txt", users);
				return util.sendEmail(subject, body, bindng.getEmaiId());
	  
		
			}
	
	
	@Override
	public String unlockAccount(UnlockAccount unlockAccount) {
		
		IesUsers users = usersRepo.findByemaiId(unlockAccount.getEmailId());
		
		users.setAccStatus("UNLOCKED");
		users.setPwd(unlockAccount.getNewpassword());
		
		usersRepo.save(users);
		
		return "Account unlocked";
	}

	@Override
	public List<IesUserBinding> getAllAccounts() {
		
		List<IesUsers> findAll = usersRepo.findAll();  
		
		List<IesUserBinding>list=new ArrayList<>();
		
		for (IesUsers iesUsers : findAll) {
			IesUserBinding userBinding=new IesUserBinding();
			BeanUtils.copyProperties(iesUsers, userBinding);
			list.add(userBinding);
			
		}
		
				return list;
	}

	@Override
	public IesUserBinding editAccount(Integer userId) {
		
		Optional<IesUsers> findById = usersRepo.findById(userId);
		
		if(findById.isPresent()) {
			IesUserBinding iesUserBinding=new IesUserBinding();
			IesUsers iesUsers = findById.get();
			BeanUtils.copyProperties(iesUsers, iesUserBinding);
			usersRepo.save(iesUsers);
		    return iesUserBinding;
		}
	
		return null;
	}

	@Override
	public boolean changeAccStatus(Integer userId, String accstatus) {
		
		Optional<IesUsers> findById = usersRepo.findById(userId);
		
		if(findById.isPresent()) {
			//IesUsers users=new IesUsers();
			IesUsers iesUsers = findById.get();
			iesUsers.setAccStatus(accstatus);
			usersRepo.save(iesUsers);
			return true;
		}
		return false;
	}

	@Override
	public String LoginCwAccount(Login login) {
		
		IesUsers iesUsers=new IesUsers();
		iesUsers.setEmaiId(login.getEmaiId());
		iesUsers.setPwd(login.getPwd());
		
		Example<IesUsers>example=Example.of(iesUsers);
	
		List<IesUsers> findAll = usersRepo.findAll(example);
		
			
		if(findAll ==null) {
			return "Invalid Credentials";
		}else {
			IesUsers iesUsers2 = findAll.get(0);
			if("Y".equals(iesUsers2.getActiveSw())&& "UNLOCKED".equals(iesUsers2.getAccStatus())) {
				return "Login Sucess";
			}else {
				return "Account Locked/Inactive";
			}
			
		}
		
		}

	@Override
	public boolean forgotPwd(String emailId) {
		
		IesUsers iesUsers=new IesUsers();
		iesUsers.setEmaiId(emailId);;
		
		Example<IesUsers>example=Example.of(iesUsers);
		List<IesUsers> findAll = usersRepo.findAll(example);
		if (findAll == null) {
			return false;
				
	 }else{
     	String subject = AppConstants.RECOVER_SUB;
 		String body = readEmailBody(AppConstants.PWD_BODY_FILE, iesUsers);
       return util.sendEmail(subject, body, emailId);
     }
		
		
	}
	
	
	public String generateRandomPass() {

//		  // choose a Character random from this String 
//		  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//		         + "0123456789"
//		         + "abcdefghijklmnopqrstuvxyz"; 
//		 
//		  // create StringBuffer size of AlphaNumericString 
//		  StringBuilder sb = new StringBuilder(n); 
//	       int i=6;
//		  
//		  for ( i = 0; i < n; i++) { 
//		 
//		   // generate a random number between 
//		   // 0 to AlphaNumericString variable length 
//		   int index 
//		    = (int)(AlphaNumericString.length() 
//		      * Math.random()); 
//		 
//		   // add Character one by one in end of sb 
//		   sb.append(AlphaNumericString 
//		      .charAt(index)); 
//		  } 
//		 
//		  return sb.toString(); 

			// create a string of uppercase and lowercase characters and number
			String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";

			// combine all strings
			String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

			// create random string builder
			StringBuilder sb = new StringBuilder();

			// create an object of Random class
			Random random = new Random();

			// specify length of random string
			int length = 6;

			for (int i = 0; i < length; i++) {

				// generate random index number
				int index = random.nextInt(alphaNumeric.length());

				// get character specified by index
				// from the string
				char randomChar = alphaNumeric.charAt(index);

				// append the character to string builder
				sb.append(randomChar);
			}

			return sb.toString();

		}
	
//	private String readEmailBody(String fullName, String pwd, String filename) throws IOException {
//		// String filename="/User-Management-03/src/main/resources/EmailBody.txt";
//		String url = "";
//		String mailbody = null;
//
//		try {
//			FileReader fileReader = new FileReader(filename);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			StringBuilder builder = new StringBuilder();
//			String line = bufferedReader.readLine();
//			while (line != null) {
//				builder.append(line);
//				line = bufferedReader.readLine();
//
//			}
//			bufferedReader.close();
//			mailbody = builder.toString();
//			mailbody.replace("{FULLNAME}", fullName);
//			mailbody.replace("{TEMP_PWD}", pwd);
//			mailbody.replace("{URL}", url);
//			mailbody.replace("{PWD}", pwd);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mailbody;
//	}
	
	
//
	
	private String readEmailBody(String filename, IesUsers user) {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			lines.forEach(line -> {
				line = line.replace("${FNAME}", String.valueOf(user.getFullName()));
				line = line.replace("${TEMP_PWD}",String.valueOf( user.getPwd()));
				line = line.replace("${EMAIL}", String.valueOf(user.getEmaiId()));
				sb.append(line);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	@Override
	public DashboardCard fetchDashboardInfo() {
		// TODO Auto-generated method stub
		
		long planscount = masterRepository.count();
		
		List<EligEntity> eliglist = elgRepo.findAll();
		
		long approvedcount = eliglist.stream().filter(e-> e.getPlanStatus().equals(AppConstants.AP)).count();
		
		long deniedcount = eliglist.stream().filter(e->e.getPlanStatus().equals(AppConstants.DN)).count();
		
		double total = eliglist.stream().mapToDouble(e->e.getBenefitAmt()).sum();
		
		DashboardCard card=new DashboardCard();
		
		card.setPlansCnt(planscount);
		card.setApprovedCnt(approvedcount);
		card.setDeniedCnt(deniedcount);
		card.getBeniftAmtGiven(total);
		
		
		return card;
	}

	



	
}

