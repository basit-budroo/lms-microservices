package org.lms.bean;

public class Transactions {
	
	private int transactionId;
	private int employeeId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", employeeId=" + employeeId + "]";
	}
	public Transactions(int transactionId, int employeeId) {
		super();
		this.transactionId = transactionId;
		this.employeeId = employeeId;
	}
	public Transactions() {
		// TODO Auto-generated constructor stub
	}
	
}