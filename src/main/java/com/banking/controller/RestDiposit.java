package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Balance;
import com.banking.model.Balance2;
import com.banking.service.DipositService;

@RestController
public class RestDiposit {

	@Autowired
	DipositService dipositService;
	
	@Autowired
	Balance2 balance2;

	@GetMapping(value = "/getBalanceByName")
	public Balance2 getBalanceByUserName() {
		
		//System.out.println(" balance ============ "+name.toString());
		
		Balance balance = dipositService.balance("alim").get(0);
		
		System.out.println(" balance ============ "+balance);
		
		
		balance2.setAccountNo(balance.getAccountNo());
		balance2.setAmmount(balance.getAmmount());
		balance2.setMircNo(balance.getMircNo());
		balance2.setName(balance.getName());
		balance2.setId(balance.getId());		

		return balance2;
		

	}

}
