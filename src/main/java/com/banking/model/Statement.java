package com.banking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Statement {
	
	//diposit statement
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	String	accountNo;	
	
	@Temporal(TemporalType.DATE)
	Date transectionDate;
	
	int dipoBalance;
	
	int totalbalance;	
	
	//end diposit
	//start withdrow
	
	int withdrowBalance;
	
	//start trnasfer dr
	
	int transferAmount;	
	String crAccountNo;
	
	//start trnasfer cr
	
	String drAccount;
	int crAccount;
	
	
	
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

	public Date getTransectionDate() {
		return transectionDate;
	}

	public void setTransectionDate(Date transectionDate) {
		this.transectionDate = transectionDate;
	}

	public int getDipoBalance() {
		return dipoBalance;
	}

	public void setDipoBalance(int dipoBalance) {
		this.dipoBalance = dipoBalance;
	}

	public int getTotalbalance() {
		return totalbalance;
	}

	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}
	
	

	public int getWithdrowBalance() {
		return withdrowBalance;
	}

	public void setWithdrowBalance(int withdrowBalance) {
		this.withdrowBalance = withdrowBalance;
	}
		
	
	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getCrAccountNo() {
		return crAccountNo;
	}

	public void setCrAccountNo(String crAccountNo) {
		this.crAccountNo = crAccountNo;
	}

	public String getDrAccount() {
		return drAccount;
	}

	public void setDrAccount(String drAccount) {
		this.drAccount = drAccount;
	}

	public int getCrAccount() {
		return crAccount;
	}

	public void setCrAccount(int crAccount) {
		this.crAccount = crAccount;
	}

	
	@Override
	public String toString() {
		return "Statement [id=" + id + ", name=" + name + ", accountNo=" + accountNo + ", transectionDate="
				+ transectionDate + ", dipoBalance=" + dipoBalance + ", totalbalance=" + totalbalance
				+ ", withdrowBalance=" + withdrowBalance + ", transferAmount=" + transferAmount + ", crAccountNo="
				+ crAccountNo + ", drAccount=" + drAccount + ", crAccount=" + crAccount + "]";
	}
	
			
}
