package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Account;
import com.banking.service.AccountService;

@Controller
public class login {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/")
	public ModelAndView loginPage() {

		System.out.println("rich Controller");

		return new ModelAndView("/login");
	}

	@PostMapping(value = "/sinin")
	public ModelAndView sinin(@RequestParam("accountNo") String accountNo, @RequestParam("password") int password) {

		System.out.println("AccountnNo= " + accountNo + " : " + "Password = " + password);
		List<Account> account = accountService.loginCheck(password);

		
		System.out.println("Database Account No" + account.get(0).getBalance().getAccountNo());
		System.out.println("Database Account No" + account.get(0).getPinNo());
		if (account.get(0).getBalance().getAccountNo().equals(accountNo) && account.get(0).getPinNo() == password) {

			return new ModelAndView("/success");

		}
		return new ModelAndView("/login");
	}

}
