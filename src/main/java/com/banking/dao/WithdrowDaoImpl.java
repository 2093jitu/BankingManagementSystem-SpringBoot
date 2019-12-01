package com.banking.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Balance;

@Repository
public class WithdrowDaoImpl implements WithdrowDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean updatebalance(int id, int tamount) {
		if (tamount > 1) {
			sessionFactory.getCurrentSession().createQuery("Update Balance bl set bl.ammount=:tamount Where bl.id=:id")
					.setParameter("tamount", tamount).setParameter("id", id).executeUpdate();
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @Override public Balance getBalanceById(int id) {
	 * 
	 * return sessionFactory.getCurrentSession().get(Balance.class, id); }
	 */

}
