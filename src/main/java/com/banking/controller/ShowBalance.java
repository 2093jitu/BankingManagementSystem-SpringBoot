package com.banking.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Account;
import com.banking.model.Balance;
import com.banking.model.CreateAccountForApp;
import com.banking.model.Statement;
import com.banking.model.TransferForApp;
import com.banking.service.AccountService;
import com.banking.service.CustomerListService;
import com.banking.service.DipositService;
import com.banking.service.StatementService;
import com.banking.service.TranasferService;
import com.banking.service.TransactionService;
import com.banking.service.WithdrowServiceInterface;

@RestController
public class ShowBalance {

	@Autowired
	TransactionService transactionService;

	@Autowired
	DipositService dipositService;

	@Autowired
	StatementService statementService;

	@Autowired
	@Qualifier("CustomerListService")
	CustomerListService customerListService;

	@Autowired
	AccountService accountService;

	@Autowired
	TranasferService tranasferService;

	@Autowired
	Statement statement;

	@Autowired
	Statement statement2;

	@Autowired
	WithdrowServiceInterface withdrowServiceInterface;

	@GetMapping(value = "/balance/{name}")
	public List<Balance> getBalanceByName(@PathVariable("name") String name) {

		List<Balance> balance = dipositService.balance(name);

		if (balance != null) {

			return balance;

		} else {

			return null;
		}

	}

	@PostMapping(value = "/postvalue")
	public void testPost(@RequestBody String name) {

		System.out.println(name + "Post:::::::::::::::::::::::::::::::::::::::::");

	}

	@GetMapping(value = "/getAllAccount")
	public List<Account> getAllAccount1() {
		List<Account> accList = customerListService.getAllAccount();
		System.out.println(accList.get(0).getBalance());
		return accList;
	}

	// login controller

	@GetMapping(value = "/appLogin/{accountno}")
	public List<Account> login(@PathVariable String accountno) {

		System.out.println(accountno);
		List<Account> account = accountService.loginCheck(accountno);

		if (account != null) {

			return account;

		} else {

			return null;
		}

	}

	@GetMapping(value = "/depositBalance/{amount}/{id}")
	public String deposit(@PathVariable("amount") int amount, @PathVariable("id") int id) {
		System.out.println("amount : =  " + amount + " id " + id);

		// start statement
		Balance balance = dipositService.getBalanceById(id);
		System.out.println("Amount=====      " + amount + "balance =========     " + balance.getAmmount());
		statement.setName(balance.getName());
		statement.setAccountNo(balance.getAccountNo());
		statement.setTransectionDate(new Date());
		statement.setTotalbalance(amount);
		statement.setWithdrowBalance(0);
		statement.setTransferAmount(0);
		statement.setCrAccount(0);
		statement.setDrAccount("-");
		statement.setCrAccount(0);
		statement.setCrAccountNo("-");
		statement.setDipoBalance(amount - balance.getAmmount());
		statementService.saveStatement(statement);
		boolean result = dipositService.updatebalance(amount, id);
		System.out.println("Statement Balance = " + statement);
		// end statement

		if (result) {

			return "success";

		} else {

			return null;
		}

	}

	@GetMapping(value = "/withdrawBalance/{amount}/{id}")
	public String withdrow(@PathVariable("amount") int amount, @PathVariable("id") int id) {

		System.out.println("amount : =  " + amount + " id " + id);

		// start statement
		Balance balance = dipositService.getBalanceById(id);
		statement.setName(balance.getName());
		statement.setAccountNo(balance.getAccountNo());
		statement.setTransectionDate(new Date());
		statement.setDipoBalance(0);
		statement.setWithdrowBalance(balance.getAmmount() - amount);
		statement.setTotalbalance(amount);
		statement.setTransferAmount(0);
		statement.setCrAccount(0);
		statement.setDrAccount("-");
		statement.setCrAccount(0);
		statement.setCrAccountNo("-");
		System.out.println("Statement Balance = " + statement);
		statementService.saveStatement(statement);
		// end statement

		boolean result = withdrowServiceInterface.updatebalance(id, amount);

		if (result) {

			return "success";

		} else {

			return null;
		}

	}

	@GetMapping(value = "/allbalance")
	public List<Balance> getAllBalance() {

		List<Balance> balance = transactionService.allBalance();

		if (balance != null) {

			return balance;

		} else {

			return null;

		}

	}

	@GetMapping(value = "/appSelectedAcNo/{selectedAc}")
	public List<Balance> selectedAccountBalance(@PathVariable("selectedAc") String selectedAc) {

		System.out.println("App" + selectedAc);

		List<Balance> selectedAcBalance = tranasferService.selectedAccountbalance(selectedAc);

		System.out.println("App==" + selectedAcBalance);

		if (selectedAcBalance != null) {

			return selectedAcBalance;

		} else {

			return null;

		}

	}

	// tranasfer
	@PostMapping("/trnasferForApp")
	public TransferForApp transfer(@RequestBody TransferForApp transferForApp) {

		System.out.println(transferForApp);

		// start

		int tammount = transferForApp.getTransferAmount();
		int dTotalAmmount = transferForApp.getdRtotalAmount();
		String selectedAccountNo = transferForApp.getSelecterAccountNo();
		int creadiAcBalance = transferForApp.getcRcurrentAcBalance();
		int creadiAcTotal = transferForApp.getcRAcTotalBalance();
		int id = transferForApp.getId();
		String DebitaccountNo = transferForApp.getDrAccountNo();

		if (!DebitaccountNo.equals(selectedAccountNo)) {
			// start statement1

			Balance balances = dipositService.getBalanceById(id);
			statement.setName(balances.getName());
			statement.setAccountNo(balances.getAccountNo());
			statement.setTransectionDate(new Date());
			statement.setDipoBalance(0);
			statement.setWithdrowBalance(0);
			statement.setTransferAmount(tammount);
			statement.setTotalbalance(dTotalAmmount);
			statement.setWithdrowBalance(0);
			statement.setDrAccount("-");
			statement.setCrAccountNo(selectedAccountNo);
			statement.setCrAccount(0);
			System.out.println("Statement Balance = " + statement);
			statementService.saveStatement(statement);
			// end statement

			// start statement
			// Statement statement2 = new Statement();
			Balance balances2 = dipositService.getBalanceByAccNo(selectedAccountNo);
			statement2.setName(balances2.getName());
			statement2.setAccountNo(balances2.getAccountNo());
			statement2.setTransectionDate(new Date());
			statement2.setDipoBalance(0);
			statement2.setWithdrowBalance(0);
			statement2.setTransferAmount(0);
			statement2.setTotalbalance(creadiAcTotal);
			statement2.setWithdrowBalance(0);
			statement2.setCrAccountNo("-");
			statement2.setCrAccount(tammount);
			statement.setDrAccount(balances.getAccountNo());
			System.out.println("Statement Balance 2 print = " + statement2);
			statementService.saveStatement(statement2);
			// end statement
			tranasferService.updateTrnasfer(id, dTotalAmmount);
			tranasferService.criditAccountBalanceUpdate(selectedAccountNo, creadiAcTotal);

			// end

		}

		return transferForApp;

	}

	// create Account
	@PostMapping(value = "/createAcForApp")
	public CreateAccountForApp caeateAccount(@RequestBody CreateAccountForApp createAccountForApp) {

		// start
		Account userAndbalance = new Account();
		Balance balance = new Balance();

		balance.setAccountNo(createAccountForApp.getAccountNo());
		balance.setAmmount(createAccountForApp.getAmount());
		balance.setMircNo(createAccountForApp.getMircNo());
		balance.setName(createAccountForApp.getName());

		userAndbalance.setPinNo(createAccountForApp.getPinNo());
		userAndbalance.setGender(createAccountForApp.getGender());
		userAndbalance.setAccountType(createAccountForApp.getAccountType());
		userAndbalance.setAddress("faridpur");
		userAndbalance.setDob("03-10-1993");
		userAndbalance.setNationality("Bangladesh");
		userAndbalance.setCast("Muslim");
		userAndbalance.setPhon(createAccountForApp.getPhonNo());
		userAndbalance.setsQus("What Is Your Name");
		userAndbalance.setAns("jitu");
		userAndbalance.setBalance(balance);

		accountService.save(userAndbalance);

		// end

		return createAccountForApp;
	}
	
	//statement
	@GetMapping(value = "/statementSearchForApp/{accountNo}")
	public List<Statement> statementSearch(@PathVariable ("accountNo") String accountNo) {
		
		System.out.println(accountNo);
		
		List<Statement> statement =statementService.getStatementByAccountNo(accountNo);
		
		if(statement !=null) {
			
			return statement;
			
		}else {
			
			return null;
		}
		
	}
	
	//auto complite
	
	@GetMapping(value = "/allUserName")
	public List<String> allUserName(){
		
		List<String> allName = dipositService.getAllName();
		System.out.println(allName);
		
		return allName;
	}

}
