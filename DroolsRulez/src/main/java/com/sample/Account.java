package com.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "record")
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (propOrder={"accountID","averageBalance","maxIncome","lendingBalance","investmentBalance","activeConditions"})
public class Account {
	
	private int accountID;

	private double averageBalance;
	
	private double maxIncome;
	
	private double lendingBalance;
	
	private double investmentBalance;

	private boolean activeConditions;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getAverageBalance() {
		return averageBalance;
	}

	public void setAverageBalance(double averageBalance) {
		this.averageBalance = averageBalance;
	}

	public double getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(double maxIncome) {
		this.maxIncome = maxIncome;
	}

	public double getLendingBalance() {
		return lendingBalance;
	}

	public void setLendingBalance(double lendingBalance) {
		this.lendingBalance = lendingBalance;
	}

	public double getInvestmentBalance() {
		return investmentBalance;
	}

	public void setInvestmentBalance(double investmentBalance) {
		this.investmentBalance = investmentBalance;
	}

	public boolean isActiveConditions() {
		return activeConditions;
	}

	public void setActiveConditions(boolean activeConditions) {
		this.activeConditions = activeConditions;
	}

	

	
}
