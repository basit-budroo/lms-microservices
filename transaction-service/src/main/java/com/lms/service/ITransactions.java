package com.lms.service;

import java.util.List;

import com.lms.bean.Tbr;
import com.lms.bean.Transactions;

public interface ITransactions {
	List<Transactions> findAlltransactions();
	public Transactions findBytransactionId(int id);
	public int addTransaction(int empId);
}
