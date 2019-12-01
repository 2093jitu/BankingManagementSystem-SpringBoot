package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.banking.dao.TransactionDao;
import com.banking.model.Balance;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;

	@Override
	public List<Balance> allBalance() {

		return transactionDao.allBalance();
	}

}
