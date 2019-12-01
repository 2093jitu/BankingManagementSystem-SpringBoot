package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Balance;

@Repository
public class DepositDaoimpl implements DipositDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<Balance> balance(String name) {
		
		System.out.println(" Dao ====================================== name"+name);
		List<Balance> balance;
		if(name !=null) {
			 balance = sessionfactory.getCurrentSession()
					.createQuery("select ac.balance from Account ac where ac.balance.name='"+name+"'")
					.list();
			
		}else {
			System.out.println(" no name" +name);
			return null;
		}
		
		return balance;
	}

	@Override
	public boolean updatebalance(int tbalance, int id) {

		int resulr =sessionfactory.getCurrentSession().createQuery("update Balance bc set bc.ammount=:tbalance Where id=:id")
				.setParameter("tbalance", tbalance).setParameter("id", id).executeUpdate();
		if(resulr>0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

	@Override
	public Balance getBalanceById(int id) {

		return sessionfactory.getCurrentSession().get(Balance.class, id);

	}

	@Override
	public Balance getBalanceByAccNo(String acNo) {
		
		Balance balance =(Balance) sessionfactory.getCurrentSession().createQuery("Select ac.balance From Account ac Where ac.balance.accountNo=:acNo").setParameter("acNo", acNo).list().get(0);
				
		if(balance !=null) {
			
			return balance;
			
		}else {
			
			return null;
		}		
		
	}

	@Override
	public List<String> getAllName() {
		
		List<String> result = sessionfactory.getCurrentSession().createQuery("select ac.balance.name from Account ac").list();
		
		if(result !=null) {
		
			return result;
			
		}else {
			
			return null;
			
		}
		
	}

}
