package com.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.bean.Tbr;
import com.lms.persistence.TbrDao;
import com.lms.persistence.TransactionsDao;

@Service
public class TbrService implements ITbrService{
	@Autowired
	private TbrDao tbr;
	@Autowired
	private TransactionsDao transaction;
//	@Override
//	public boolean issueBook(int transactionId, int bookId, String issueDate, String ScheduledDate) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public List<Tbr> checkReturnDate(int empID, int bookID) {
////		StringBuilder res = new StringBuilder();
////		int id = tbr.findTransactionId(empID);
////		String  date= tbr.findScheduledReturn(bookID,10002);
////		res.append("EmpID: ").append(empID).append("| ");
////		res.append("Book ID: ").append(bookID).append("| ");
////		res.append("Return Date: ").append(date).append("\n");
////		return res.toString();
//		
//	}
//	
//	@Override
//	public String returnBook(int transctionID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public List<Tbr> findAllTbr() {
		// TODO Auto-generated method stub
//		List<Tbr> tb = tbr.findByBookId(111);
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+tb);
		return tbr.findAll();
	}
	
	@Override
	public void deleteByid(int tbrid) {
		// TODO Auto-generated method stub
		tbr.deleteById(tbrid);;
	}
	@Override
	public Tbr addEntry(Tbr tbr1,double fine) {
		Optional<Tbr> tb = tbr.findById(tbr1.getTbrId());
		if(tb.isPresent()) {
			try {
		tbr.deleteById(tbr1.getTbrId());
		tb.get().setFine(fine);
		System.out.println(tb.get().getFine()+"$$$$$$$$$$$");
		return tbr.save(tb.get());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("ye chla");
		return tbr.save(tbr1);
	}
	
	
	
}
