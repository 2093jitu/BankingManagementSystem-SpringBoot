package com.banking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Account;
import com.banking.model.Balance;
import com.banking.service.AccountService;

@Controller
public class Profile {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/profile")
	ModelAndView showProfile() {

		return new ModelAndView("/success");
	}

	@RequestMapping(value = "/userSearch")
	ModelAndView search(@RequestParam("name") String name, Map<String, Object> map) {

		System.out.println(name);
		/*
		 * System.out.println(accountService.getByName(name).get(0).getBalance().
		 * getAccountNo());
		 */
		map.put("user", accountService.getByName(name));
		return new ModelAndView("/success", map);

	}

	@RequestMapping(value = "/updareprofile")
	ModelAndView update(HttpServletRequest req) {

		String id = req.getParameter("id");
		String bid=req.getParameter("bid");
		String accountNo1 = req.getParameter("accountNo");
		System.out.println(accountNo1);

		String mircNo = req.getParameter("mircNo");

		String pinNo = req.getParameter("pinNo");
		String gender = req.getParameter("gender");

		String accountType = req.getParameter("accountType");
		String address = req.getParameter("address");

		String ammount = req.getParameter("ammount");
		String name = req.getParameter("name");

		String dob = req.getParameter("dob");
		String nationality = req.getParameter("nationality");

		String cast = req.getParameter("cast");
		String phon = req.getParameter("phon");

		String sQus = req.getParameter("sQus");
		String ans = req.getParameter("ans");

		Account userAndbalance = new Account();
		Balance balance = new Balance();

		balance.setAccountNo(accountNo1);
		balance.setAmmount(Integer.parseInt(ammount));
		balance.setMircNo(Integer.parseInt(mircNo));
		balance.setName(name);
		balance.setId(Integer.parseInt(bid));
		
		
		userAndbalance.setId(Integer.parseInt(id));
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

		System.out.println("update Value==============:" + userAndbalance.getBalance());
		accountService.update(userAndbalance);
		return new ModelAndView("/success");

	}

}
