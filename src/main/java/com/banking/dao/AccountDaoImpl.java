package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Account account) {

		sessionFactory.getCurrentSession().save(account);
	}

	@Override
	public List<Account> loginCheck(int pin) {

		System.out.println(" : pin is " + pin);
		List<Account> account = sessionFactory.getCurrentSession()
				.createQuery("FROM Account ac Where  ac.pinNo='" + pin + "'").list();
		System.out.println("Dao Total Account = " + account);
		System.out.println("Dao Total Account + Balance = " + account.get(0).getBalance());
		return account;
	}

	@Override
	public List<Account> getByName(String name) {

		System.out.println("Dao Name : ======" + name);
		List<Account> account = sessionFactory.getCurrentSession()
				.createQuery("FROM Account ac Where ac.balance.name=:name").setParameter("name", name).list();

		System.out.println(account);
		return account;
	}

	@Override
	public boolean update(Account antity) {

		sessionFactory.getCurrentSession().update(antity);

		return true;
	}

	@Override
	public List<Account> loginCheck(String accountNo) {

		List<Account> account = sessionFactory.getCurrentSession()
				.createQuery("FROM Account ac Where  ac.balance.accountNo='" +accountNo+ "'").list();

		if (accountNo != null) {

			return account;

		} else {

			return null;

		}

	}

}
