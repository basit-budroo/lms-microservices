package com.lms.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.bean.Tbr;
import com.lms.bean.Transactions;
import com.lms.persistence.TransactionsDao;
@Service
public class TransactionsService  implements ITransactions{
	@Autowired
	private TransactionsDao transaction;
	@Override
	public List<Transactions> findAlltransactions() {
		return transaction.findAll();
	}
	@Override
	public Transactions findBytransactionId(int id) {
		Optional<Transactions> transactions = transaction.findById(id);
		if(transactions.isPresent()) {
			return transactions.get();
		}
		return null;
	}
	public void deleteByid(int tid) {
		// TODO Auto-generated method stub
		transaction.deleteById(tid);;
	}
	
	public int addTransaction(int empId) {
		System.out.println(findAlltransactions());
		Transactions transac = new Transactions(empId);
		Transactions transac1=transaction.save(transac);System.out.println(findAlltransactions());
		return transac1.getTransactionId();
		
	}

	

}
