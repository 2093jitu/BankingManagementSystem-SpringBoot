package com.banking.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Balance;
import com.banking.model.Statement;
import com.banking.service.DipositService;
import com.banking.service.StatementService;
import com.banking.service.WithdrowServiceInterface;

@Controller
public class Withdro {

	@Autowired
	DipositService dipositService;

	@Autowired
	WithdrowServiceInterface withdrowServiceInterface;

	@Autowired
	Statement statement;
	
	@Autowired
	StatementService statementService;

	@RequestMapping(value = "/withdroPage")
	public ModelAndView withdroPage() {

		return new ModelAndView("withdro");
	}

	@RequestMapping(value = "showbalance")
	public ModelAndView showbalance(@RequestParam("name") String name, Map<String, Object> map) {
		System.out.println("name= " + name);
		map.put("balance", dipositService.balance(name).get(0));
		System.out.println("diposit = " + dipositService.balance(name));
		return new ModelAndView("withdro", map);
	}

	@RequestMapping(value = "/totalamount")
	public ModelAndView totalCalculation(@RequestParam("id") int id, @RequestParam("ammount") int ammount,
			@RequestParam("wbalance") int wbalance, Map<String, Integer> mp) {
		mp.put("tammount", withdrowServiceInterface.totalbalance(ammount, wbalance));
		mp.put("id", id);
		System.out.println(id + " : " + ammount + " : " + wbalance);
		return new ModelAndView("withdro");
	}

	@RequestMapping(value = "withdrow/{tammount}/{id}")
	public ModelAndView withdrow(@PathVariable("tammount") int tammount, @PathVariable("id") int id,
			Map<String, Boolean> msg) {

		System.out.println(tammount + " : " + id);

		// start statement
		Balance balance = dipositService.getBalanceById(id);
		statement.setName(balance.getName());
		statement.setAccountNo(balance.getAccountNo());
		statement.setTransectionDate(new Date());
		statement.setDipoBalance(0);
		statement.setWithdrowBalance(balance.getAmmount() - tammount);
		statement.setTotalbalance(tammount);
		statement.setTransferAmount(0);
		statement.setCrAccount(0);
		statement.setDrAccount("-");
		statement.setCrAccount(0);
		statement.setCrAccountNo("-");
		System.out.println("Statement Balance = " + statement);
		statementService.saveStatement(statement); 
		// end statement

		boolean res = withdrowServiceInterface.updatebalance(id, tammount);
		if (res) {

			msg.put("msg", true);
			System.out.println(msg);
			return new ModelAndView("withdro", msg);

		} else {

			return new ModelAndView("redirect:/withdroPage");

		}

	}

}
