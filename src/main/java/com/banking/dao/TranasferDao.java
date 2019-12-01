package com.banking.dao;

import java.util.List;

import com.banking.model.Balance;

public interface TranasferDao {

	
	public List<Balance> allAccountNo();
	
	public List<Balance> selectedAccountbalance(String SelectedAccount);
	
	public boolean updateTrnasfer(int id , int balance);
	
	public boolean criditAccountBalanceUpdate(String acNo , int balance);
	
}
