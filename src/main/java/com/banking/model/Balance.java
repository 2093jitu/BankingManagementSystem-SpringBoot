package com.banking.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "balance")
public class Balance{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int id;

	String name;

	String accountNo;

	int mircNo;

	int ammount;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "id")
	 */

	

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Balance [name=" + name + ", accountNo=" + accountNo + ", mircNo=" + mircNo + ", ammount=" + ammount
				+ "]";
	}

}
