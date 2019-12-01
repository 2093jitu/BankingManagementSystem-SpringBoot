package com.banking.model;

public class CreateAccountForApp {

	String gender;
	String accountNo;
	int mircNo;
	int pinNo;
	int amount;
	String name;
	String phonNo;
	String accountType;
	
	
	
	
	
	public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
    public int getPinNo() {
        return pinNo;
    }
    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhonNo() {
        return phonNo;
    }
    public void setPhonNo(String phonNo) {
        this.phonNo = phonNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "CreateAccountForApp{" +
                "gender='" + gender + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", mircNo=" + mircNo +
                ", pinNo=" + pinNo +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", phonNo='" + phonNo + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
	
	
	
	
	
	
	
	
	
	

}
