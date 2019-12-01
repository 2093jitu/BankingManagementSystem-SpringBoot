package com.banking.dao;

import java.util.List;

import com.banking.model.Statement;

public interface StatementDao {

	public void saveStatement(Statement statement);

	public List<Statement> getStatementByAccountNo(String accountNo);

}
