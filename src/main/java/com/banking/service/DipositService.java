package com.banking.service;

import java.util.List;

import com.banking.model.Balance;

public interface DipositService {

	List<Balance> balance(String name);

	public int calculateTotalBalance(int abalance, int bbalance);

	public boolean updatebalance(int tbalance,int id);
	
	public Balance getBalanceById(int id);
	
	public Balance getBalanceByAccNo(String acNo);
	
	public List<String> getAllName();
	
	
}
