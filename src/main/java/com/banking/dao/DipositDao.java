package com.banking.dao;

import java.util.List;

import com.banking.model.Balance;
import com.banking.model.Statement;

public interface DipositDao {

	public List<Balance> balance(String name);

	public boolean updatebalance(int tbalance,int id);
	
	public Balance getBalanceById(int id);
	
	public Balance getBalanceByAccNo(String acNo);
	
	public List<String> getAllName();
	
	
}
