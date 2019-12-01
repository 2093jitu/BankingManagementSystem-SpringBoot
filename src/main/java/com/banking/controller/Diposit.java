package com.banking.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Balance;
import com.banking.model.Statement;
import com.banking.service.DipositService;
import com.banking.service.StatementService;

@RestController
public class Diposit {

	@Autowired
	DipositService dipositService;
	
	@Autowired
	Statement statement;
	
	@Autowired
	StatementService statementService;
	
	
	
	/*
	 * Date date = new Date(); DateFormat dateFormat = new
	 * SimpleDateFormat("dd/MM/YYYY"); String currentDate = dateFormat.format(date);
	 */
	
	
	
	@RequestMapping(value = "/diposit")
	public ModelAndView showDipositPage() {
	
		return new ModelAndView("/diposit");
	}

	@RequestMapping(value = "/dipositSerch")
	public ModelAndView dipositSerch(@RequestParam("name") String name, Map<String, Object> map) {
		System.out.println("controller ===========" + dipositService.balance(name));
		map.put("balance", dipositService.balance(name).get(0));
		return new ModelAndView("/diposit", map);
	}

	@RequestMapping(value = "/dipositb")
	public ModelAndView dipositammount(@RequestParam("ammount") int ammount, @RequestParam("damount") int damount,@RequestParam("id") int id,
			Map<String, Integer> map) {

		System.out.println("work it" + damount + " : " + ammount);
		System.out.println("Total Ammount = :" + dipositService.calculateTotalBalance(ammount, damount));
		int t = dipositService.calculateTotalBalance(ammount, damount);
		map.put("tammount", t);
		map.put("id", id);
		return new ModelAndView("/diposit", map);
	}

	@RequestMapping(value = "/totalammount/{tammount}/{id}")
	public ModelAndView updatebalance(@PathVariable("tammount") int tammount,@PathVariable("id") int id) {
		
		
		System.out.println("Update Totael Ammount" + tammount +"" +id);
		
		
		//start statement
		Balance balance = dipositService.getBalanceById(id);
		statement.setName(balance.getName());
		statement.setAccountNo(balance.getAccountNo());
		statement.setTransectionDate(new Date());
		statement.setDipoBalance(tammount-balance.getAmmount());
		statement.setTotalbalance(tammount);
		statement.setWithdrowBalance(0);
		statement.setTransferAmount(0);
		statement.setCrAccount(0);
		statement.setDrAccount("-");
		statement.setCrAccount(0);
		statement.setCrAccountNo("-");
		System.out.println("Statement Balance = "+statement);
		statementService.saveStatement(statement);
		//end statement 
		dipositService.updatebalance(tammount,id);
		return new ModelAndView("/diposit");
	}

}
