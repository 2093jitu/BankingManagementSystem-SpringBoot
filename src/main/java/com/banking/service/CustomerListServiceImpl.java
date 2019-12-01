package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.CustomerListDao;
import com.banking.model.Account;

@Service("CustomerListService")
@Transactional
public class CustomerListServiceImpl implements CustomerListService{
	
	
	@Autowired
	CustomerListDao customerListDao;

	@Override
	public List<Account> getAllAccount() {
		
		return customerListDao.getAllAccount();
	}
	
	
	

}
