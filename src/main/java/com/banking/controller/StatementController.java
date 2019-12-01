package com.banking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.service.StatementService;

@Controller
public class StatementController {

	@Autowired
	StatementService statementService;

	@RequestMapping(value = "statement")
	public ModelAndView statementPage() {

		/*
		 * statementService.getStatementByAccountNo("4515985"); map.put("statement",
		 * statementService.getStatementByAccountNo("4515985"));
		 */
		return new ModelAndView("/statement");
	}
	
	@RequestMapping(value = "/statementSearch")
	public ModelAndView statementSearch(@RequestParam ("accountNo") String accountNo ,Map<String, Object> map) {
		//statementService.getStatementByAccountNo(accountNo);
		System.out.println(accountNo);
		map.put("statement", statementService.getStatementByAccountNo(accountNo));
		return new ModelAndView("/statement", map);
	}
}
