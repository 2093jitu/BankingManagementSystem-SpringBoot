package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.AccountDao;
import com.banking.model.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public void save(Account account) {

		accountDao.save(account);

	}

	@Override
	public List<Account> loginCheck(int pin) {

		return accountDao.loginCheck(pin);
	}

	@Override
	public List<Account> getByName(String name) {

		return accountDao.getByName(name);
	}

	@Override
	public boolean update(Account antity) {

		return accountDao.update(antity);
	}

	@Override
	public List<Account> loginCheck(String accountNo) {
		
		return accountDao.loginCheck(accountNo);
	}

}
