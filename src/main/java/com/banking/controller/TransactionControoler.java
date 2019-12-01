package com.banking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.banking.service.DipositService;
import com.banking.service.TransactionService;

@Controller
public class TransactionControoler {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/tranjection")
	public ModelAndView showTrangaction(Map<String, Object> map) {
		
		map.put("allBalance", transactionService.allBalance());
		
		System.out.println(transactionService.allBalance());

		return new ModelAndView("transaction");
	}

}
