package com.banking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Account;
import com.banking.model.Balance;
import com.banking.service.AccountService;

@Controller
public class CreateAccount {

	@Autowired
	AccountService accountService;

	@InitBinder
	public void dataInitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, true));

	}

	@RequestMapping(value = "/createAccount")
	public ModelAndView account(Map<String, Object> map) {

		System.out.println("rich Controller");
		Random ran1 = new Random();
		int accountNo = ran1.nextInt(11111111);
		map.put("accountNo", accountNo);

		int mircNo = ran1.nextInt(2222);
		map.put("mircNo", mircNo);

		int pinNo = ran1.nextInt(7777);
		map.put("pinNo", pinNo);

		return new ModelAndView("/account", map);
	}

	@RequestMapping(value = "/create")
	public ModelAndView createaccount(HttpServletRequest req) {
		
		
		String accountNo=req.getParameter("accountNo");
		String mircNo=req.getParameter("mircNo");
		
		String pinNo=req.getParameter("pinNo");
		String gender=req.getParameter("gender");
		
		String accountType=req.getParameter("accountType");
		String address=req.getParameter("address");
		
		String ammount=req.getParameter("ammount");
		String name=req.getParameter("name");
		
		String dob=req.getParameter("dob");
		String nationality=req.getParameter("nationality");
		
		String cast=req.getParameter("cast");
		String phon=req.getParameter("phon");
		
		String sQus=req.getParameter("sQus");
		String ans=req.getParameter("ans");

		
		 Account userAndbalance = new Account(); 
		 Balance balance = new Balance();
		 
		 balance.setAccountNo(accountNo);
		 balance.setAmmount(Integer.parseInt(ammount));
		 balance.setMircNo(Integer.parseInt(mircNo));
		 balance.setName(name);		 
		 
		 
		  userAndbalance.setPinNo(Integer.parseInt(pinNo));
		  userAndbalance.setGender(gender);
		  userAndbalance.setAccountType(accountType);
		  userAndbalance.setAddress(address);
		  userAndbalance.setDob(dob);
		  userAndbalance.setNationality(nationality);
		  userAndbalance.setCast(cast);
		  userAndbalance.setPhon(phon);
		  userAndbalance.setsQus(sQus);
		  userAndbalance.setAns(ans);
		  userAndbalance.setBalance(balance);
		  
		accountService.save(userAndbalance);
		
		
		return new ModelAndView("/account");
	}

}
