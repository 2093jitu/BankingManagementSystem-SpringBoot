package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.TranasferDao;
import com.banking.model.Balance;

@Service
@Transactional
public class TrnasferServiceImpl implements TranasferService {

	@Autowired
	TranasferDao tranasferDao;

	public int totalAmount(int aAmount, int tAmount) {
		int presentAmount = aAmount - tAmount;
		if (aAmount > tAmount) {

			return presentAmount;

		} else {

			return 0;
		}

	}

	@Override
	public List<Balance> allAccountNo() {

		return tranasferDao.allAccountNo();

	}

	@Override
	public List<Balance> selectedAccountbalance(String SelectedAccount) {

		return tranasferDao.selectedAccountbalance(SelectedAccount);
	}

	@Override
	public boolean updateTrnasfer(int id, int balance) {

		return tranasferDao.updateTrnasfer(id, balance);
	}

	@Override
	public boolean criditAccountBalanceUpdate(String acNo, int balance) {

		return tranasferDao.criditAccountBalanceUpdate(acNo, balance);
	};

}
