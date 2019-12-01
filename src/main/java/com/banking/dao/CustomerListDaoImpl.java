package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Account;

@Repository
public class CustomerListDaoImpl implements CustomerListDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Account> getAllAccount() {
		List<Account> accList = sessionFactory.getCurrentSession().createQuery("FROM Account").list();
		return accList;
	}
	
	
	

	
	

}
