package com.banking.dao;

import java.util.List;

import com.banking.model.Account;

public interface AccountDao {
	
	public void save (Account account);
	public List<Account> loginCheck( int pin);
	public List<Account> getByName( String name);
	public boolean  update(Account antity);
	public List<Account> loginCheck(String accountNo);

}
