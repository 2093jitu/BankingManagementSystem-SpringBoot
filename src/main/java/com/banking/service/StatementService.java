package com.banking.service;

import java.util.List;

import com.banking.model.Statement;

public interface StatementService {

	public void saveStatement(Statement statement);
	
	public List<Statement> getStatementByAccountNo(String accountNo);

}
