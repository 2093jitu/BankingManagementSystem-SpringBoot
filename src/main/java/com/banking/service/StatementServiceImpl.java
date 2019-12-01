package com.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.StatementDao;
import com.banking.model.Statement;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {

	@Autowired
	StatementDao statementDao;

	@Override
	public void saveStatement(Statement statement) {

		statementDao.saveStatement(statement);

	}

	@Override
	public List<Statement> getStatementByAccountNo(String accountNo) {

		return statementDao.getStatementByAccountNo(accountNo);
	}

}
