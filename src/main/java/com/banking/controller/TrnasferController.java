package com.banking.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Balance;
import com.banking.model.Statement;
import com.banking.service.DipositService;
import com.banking.service.StatementService;
import com.banking.service.TranasferService;
import com.banking.service.TrnasferServiceImpl;

@RestController
public class TrnasferController {

	@Autowired
	DipositService dipositService;

	@Autowired
	TranasferService tranasferService;
	
	@Autowired
	Statement statement;
	
	@Autowired
	Statement statement2;
	
	@Autowired
	StatementService statementService;
	
	int avableamount;

	@GetMapping("/trnasfer")
	public ModelAndView n() {

		return new ModelAndView("/trnasfer");
	}

	@RequestMapping(value = "/trnasferforshowbalance")
	public ModelAndView showBalance(@RequestParam("name") String name, Map<String, Object> map) {

		System.out.println("controller ===========" + dipositService.balance(name));
		map.put("balance", dipositService.balance(name).get(0));
		map.put("accountNo", tranasferService.allAccountNo());
		avableamount = dipositService.balance(name).get(0).getAmmount();
		System.out.println("Avale Ammount = " + avableamount);
		return new ModelAndView("trnasfer");
	}

	@RequestMapping(value = "/tammount/{tammount}")
	public int totalAmount(@PathVariable("tammount") int tammount) {

		System.out.println("trnasfer Ammount ==" + tammount + " : " + "Available Balance" + avableamount);
		int presentAmmount = tranasferService.totalAmount(avableamount, tammount);

		return presentAmmount;

	}

	@RequestMapping(value = "/accountNo/{selectedAc}")
	public List<Balance> selectedAccountBalance(@PathVariable("selectedAc") String selectedAc) {

		// System.out.println("Selected Account No==" + Integer.parseInt(selectedAc));
		List<Balance> l = tranasferService.selectedAccountbalance(selectedAc);
		System.out.println("Selected Account No " +l);
		return l;

	}

	@PostMapping(value = "/trnasfarSubmit")
	public ModelAndView trnasferSubmit(HttpServletRequest req, Map<String, Boolean> map) {

		String tammount = req.getParameter("tammount");
		String dTotalAmmount = req.getParameter("dTotalAmmount");
		String selectedAccountNo = req.getParameter("selectedAccountNo");
		String creadiAcBalance = req.getParameter("creadiAcBalance");
		String creadiAcTotal = req.getParameter("creadiAcTotal");
		String id = req.getParameter("id");
		String DebitaccountNo = req.getParameter("accountNo");
		
		int balance = Integer.parseInt(dTotalAmmount);
		int idi = Integer.parseInt(id);
		int criditAcBalance = Integer.parseInt(creadiAcTotal);

		if (!DebitaccountNo.equals(selectedAccountNo)) {
			//start statement1
			Balance balances = dipositService.getBalanceById(idi);
			statement.setName(balances.getName());
			statement.setAccountNo(balances.getAccountNo());
			statement.setTransectionDate(new Date());
			statement.setDipoBalance(0);
			statement.setWithdrowBalance(0);
			statement.setTransferAmount(Integer.parseInt(tammount));
			statement.setTotalbalance(Integer.parseInt(dTotalAmmount));
			statement.setWithdrowBalance(0);
			statement.setDrAccount("-");
			statement.setCrAccountNo(selectedAccountNo);
			System.out.println("Statement Balance = "+statement);
			statementService.saveStatement(statement);
			//end statement
			//start statement
			
			Balance balances2 = dipositService.getBalanceByAccNo(selectedAccountNo);
			statement2.setName(balances2.getName());
			statement2.setAccountNo(balances2.getAccountNo());
			statement2.setTransectionDate(new Date());
			statement2.setDipoBalance(0);
			statement2.setWithdrowBalance(0);
			statement2.setTransferAmount(0);
			statement2.setTotalbalance(criditAcBalance);
			statement2.setWithdrowBalance(0);
			statement2.setCrAccountNo("-");
			statement2.setCrAccount(Integer.parseInt(tammount));
			statement.setDrAccount(balances.getAccountNo());
			System.out.println("Statement Balance 2 print = "+statement2);
			statementService.saveStatement(statement2);			
			//end statement
			tranasferService.updateTrnasfer(idi, balance);
			tranasferService.criditAccountBalanceUpdate(selectedAccountNo, criditAcBalance);
			map.put("success", true);

		} else {
			map.put("error", true);
			System.out.println("You selected Same Account no");
			return new ModelAndView("/trnasfer", map);
		}		

		System.out.println("ok ");
		return new ModelAndView("/trnasfer");
	}

}
