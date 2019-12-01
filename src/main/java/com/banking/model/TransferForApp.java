package com.banking.model;

public class TransferForApp {
	
	int transferAmount ;
    int dRtotalAmount ;
    String selecterAccountNo;
    int cRcurrentAcBalance;
    int cRAcTotalBalance ;
    String drAccountNo ;
    int id;
    
        

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getdRtotalAmount() {
        return dRtotalAmount;
    }

    public void setdRtotalAmount(int dRtotalAmount) {
        this.dRtotalAmount = dRtotalAmount;
    }

    public String getSelecterAccountNo() {
        return selecterAccountNo;
    }

    public void setSelecterAccountNo(String selecterAccountNo) {
        this.selecterAccountNo = selecterAccountNo;
    }

    public int getcRcurrentAcBalance() {
        return cRcurrentAcBalance;
    }

    public void setcRcurrentAcBalance(int cRcurrentAcBalance) {
        this.cRcurrentAcBalance = cRcurrentAcBalance;
    }

    public int getcRAcTotalBalance() {
        return cRAcTotalBalance;
    }

    public void setcRAcTotalBalance(int cRAcTotalBalance) {
        this.cRAcTotalBalance = cRAcTotalBalance;
    }

    public String getDrAccountNo() {
        return drAccountNo;
    }

    public void setDrAccountNo(String drAccountNo) {
        this.drAccountNo = drAccountNo;
    }

    @Override
    public String toString() {
        return "PostTransfer{" +
                "transferAmount=" + transferAmount +
                ", dRtotalAmount=" + dRtotalAmount +
                ", selecterAccountNo='" + selecterAccountNo + '\'' +
                ", cRcurrentAcBalance=" + cRcurrentAcBalance +
                ", cRAcTotalBalance=" + cRAcTotalBalance +
                ", drAccountNo='" + drAccountNo + '\'' +
                '}';
    }
	
	
	
	
	
	


}
