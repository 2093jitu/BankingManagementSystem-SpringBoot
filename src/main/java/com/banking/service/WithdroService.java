package com.banking.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.WithdrowDao;

@Service
@Transactional
public class WithdroService implements WithdrowServiceInterface {

	@Autowired
	WithdrowDao withdrowDao;
	
	@Override
	public int totalbalance(int abalance, int wbalance) {
		int totalAmmount;
		if (abalance > wbalance) {

			return totalAmmount = (abalance - wbalance);

		} else {

			return 0;

		}

	}

	@Override
	public boolean updatebalance(int id, int tamount) {
		if(tamount>1) {
			
			return withdrowDao.updatebalance(id, tamount);
			
		}else{
			
			return false;
		}
	}

}
