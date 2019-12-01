package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Balance;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Balance> allBalance() {
		
		List<Balance> allBalance=sessionFactory.getCurrentSession().createQuery("Select ac.balance From Account ac").list();
		
		return allBalance;
		
	}

}
