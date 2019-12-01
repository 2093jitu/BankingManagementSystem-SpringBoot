package com.banking.model;

public class Balance2 {

	
	
	int id;

	String name;

	String accountNo;

	int mircNo;

	int ammount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getMircNo() {
		return mircNo;
	}

	public void setMircNo(int mircNo) {
		this.mircNo = mircNo;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Balance2 [id=" + id + ", name=" + name + ", accountNo=" + accountNo + ", mircNo=" + mircNo
				+ ", ammount=" + ammount + "]";
	}
	
	
	
	
	
}
