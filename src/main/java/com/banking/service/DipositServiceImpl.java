package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.DipositDao;
import com.banking.model.Balance;

@Service
@Transactional
public class DipositServiceImpl implements DipositService {

	@Autowired
	DipositDao dipositDao;

	@Override
	public List<Balance> balance(String name) {

		return dipositDao.balance(name);

	}

	@Override
	public int calculateTotalBalance(int abalance, int bbalance) {

		int totalbalance = abalance + bbalance;

		return totalbalance;
	}

	@Override
	public boolean updatebalance(int tbalance, int id) {

		return dipositDao.updatebalance(tbalance, id);

	}

	@Override
	public Balance getBalanceById(int id) {

		return dipositDao.getBalanceById(id);
	}

	@Override
	public Balance getBalanceByAccNo(String acNo) {

		return dipositDao.getBalanceByAccNo(acNo);
	}

	@Override
	public List<String> getAllName() {
		
		return dipositDao.getAllName();
		
	}

}
