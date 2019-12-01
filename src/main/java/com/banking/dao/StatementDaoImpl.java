package com.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.model.Statement;

@Repository
public class StatementDaoImpl implements StatementDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveStatement(Statement statement) {

		sessionFactory.getCurrentSession().save(statement);

	}

	@Override
	public List<Statement> getStatementByAccountNo(String accountNo) {

		List<Statement> statement = sessionFactory.getCurrentSession()
				.createQuery("From Statement where AccountNo=:accountNo").setParameter("accountNo", accountNo).list();
		for(Statement v:statement) {
			
			System.out.println("Statement prinnt "+v+"\n\n");
		}
		return statement;
	}

}
