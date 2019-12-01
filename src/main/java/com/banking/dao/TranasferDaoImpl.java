package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Balance;

@Repository
public class TranasferDaoImpl implements TranasferDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Balance> allAccountNo() {

		System.out.println(
				sessionFactory.getCurrentSession().createQuery("SELECT ac.balance.accountNo FROM Account ac").list());
		return sessionFactory.getCurrentSession().createQuery("SELECT ac.balance.accountNo FROM Account ac").list();

	}

	@Override
	public List<Balance> selectedAccountbalance(String SelectedAccount) {

		return sessionFactory.getCurrentSession().createQuery(
				"SELECT ac.balance.ammount FROM Account ac Where ac.balance.accountNo='" + SelectedAccount + "'")
				.list();

	}

	@Override
	public boolean updateTrnasfer(int id, int balance) {

		sessionFactory.getCurrentSession().createQuery("Update Balance bl set bl.ammount=:balance Where bl.id=:id")
				.setParameter("balance", balance).setParameter("id", id).executeUpdate();

		return true;
	}

	@Override
	public boolean criditAccountBalanceUpdate(String acNo, int balance) {

		sessionFactory.getCurrentSession()
				.createQuery("Update Balance bl set bl.ammount=:balance Where bl.accountNo=:acNo")
				.setParameter("balance", balance).setParameter("acNo", acNo).executeUpdate();

		return true;
	}

}
