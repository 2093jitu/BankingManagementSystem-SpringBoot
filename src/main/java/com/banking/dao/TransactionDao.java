package com.banking.dao;

import java.util.List;

import com.banking.model.Balance;

public interface TransactionDao {
	
	List<Balance> allBalance();

}
