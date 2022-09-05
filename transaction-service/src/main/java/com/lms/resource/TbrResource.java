package com.lms.resource;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.bean.Tbr;
import com.lms.bean.Tbrdata;
import com.lms.bean.Transactions;
import com.lms.service.TbrService;
import com.lms.service.TransactionsService;

@RestController
public class TbrResource {
	@Autowired
	private TbrService tbrService;

	@Autowired
	private TransactionsService transactionsService;

	@GetMapping(path = "/checkScheduledReturnDate/{eid}/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getScheduledReturn(@PathVariable("eid") int empId, @PathVariable("bid") int bookId) {
		List<Transactions> AllTransactions = transactionsService.findAlltransactions();
		if (AllTransactions != null) {
			List<Integer> TnID = new ArrayList<>();
			for (Transactions transaction : AllTransactions) {
				if (transaction.getEmployeeId() == empId) {
					TnID.add(transaction.getTransactionId());
				}
			}
			List<Tbr> TbrRec = tbrService.findAllTbr();
			if (TbrRec.size() != 0) {
				for (int tnid : TnID) {
					for (Tbr tbr : TbrRec) {
						if (tbr.getTransactionId() == tnid && tbr.getBookId() == bookId) {
							return new ResponseEntity<String>(tbr.getScheduledReturn(), HttpStatus.FOUND);
						}
					}
				}
			}
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}
	@PostMapping(path = "/issuebook", produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tbrdata> issueBook(@RequestBody Tbrdata tbrdata) {
		
		
		int transactId=transactionsService.addTransaction(tbrdata.getEmployeeId());
		Tbr tbr = new Tbr(tbrdata.getBookId(),transactId,tbrdata.getIssueDate(),tbrdata.getScheduledReturn(),tbrdata.getReturnDate(),-1);
		tbrService.addEntry(tbr, -1);
		
		return new ResponseEntity<Tbrdata>(tbrdata, HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/returnbook/{eid}/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> returnBook(@PathVariable("eid") int empId, @PathVariable("bid") int bookId) {
		int val = 0;
		double fine = 0;
		List<Transactions> AllTransactions = transactionsService.findAlltransactions();
		if (AllTransactions != null) {
			List<Integer> TnID = new ArrayList<>();
			for (Transactions transaction : AllTransactions) {
				if (transaction.getEmployeeId() == empId) {
					TnID.add(transaction.getTransactionId());
				}
			}
			List<Tbr> TbrRec = tbrService.findAllTbr();
			if (TbrRec.size() != 0) {
				for (int tnid : TnID) {
					for (Tbr tbr : TbrRec) {
						if (tbr.getTransactionId() == tnid && tbr.getBookId() == bookId) {
							if (tbr.getFine()==0) {
								tbrService.deleteByid(tbr.getTbrId());
								transactionsService.deleteByid(tbr.getTransactionId());
								return new ResponseEntity<String>("paid", HttpStatus.FOUND);
							}
							else
								return new ResponseEntity<String>("Pay fine First", HttpStatus.NOT_FOUND);
						}

					}
				}
			}

		}
		return new ResponseEntity<String>("Record does not exist", HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/calFine/{eid}/{bid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Double> getFine(@PathVariable("eid") int empId, @PathVariable("bid") int bookId) {
		int val = 0;
		double fine = 0;
		List<Transactions> AllTransactions = transactionsService.findAlltransactions();
		if (AllTransactions != null) {
			List<Integer> TnID = new ArrayList<>();
			for (Transactions transaction : AllTransactions) {
				if (transaction.getEmployeeId() == empId) {
					TnID.add(transaction.getTransactionId());
				}
			}
			List<Tbr> TbrRec = tbrService.findAllTbr();
			if (TbrRec.size() != 0) {
				for (int tnid : TnID) {
					for (Tbr tbr : TbrRec) {
						if (tbr.getTransactionId() == tnid && tbr.getBookId() == bookId) {
							String scheduled = tbr.getScheduledReturn();
							String returnDate = tbr.getReturnDate();
							if (scheduled.length() != 0 && returnDate.length() != 0) {
								val = Math.abs(fixString(returnDate) - fixString(scheduled));
								fine = val * 100;
								tbrService.addEntry(tbr, fine);
								return new ResponseEntity<Double>(fine, HttpStatus.FOUND);
							}
						}

					}
				}
			}

		}
		return new ResponseEntity<Double>(fine, HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/payFine/{eid}/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> payFine(@PathVariable("eid") int empId, @PathVariable("bid") int bookId) {
		int val = 0;
		double fine = 0;
		List<Transactions> AllTransactions = transactionsService.findAlltransactions();
		if (AllTransactions != null) {
			List<Integer> TnID = new ArrayList<>();
			for (Transactions transaction : AllTransactions) {
				if (transaction.getEmployeeId() == empId) {
					TnID.add(transaction.getTransactionId());
				}
			}
			List<Tbr> TbrRec = tbrService.findAllTbr();
			if (TbrRec.size() != 0) {
				for (int tnid : TnID) {
					for (Tbr tbr : TbrRec) {
						if (tbr.getTransactionId() == tnid && tbr.getBookId() == bookId) {
							tbrService.addEntry(tbr, 0);
							return new ResponseEntity<Boolean>(true, HttpStatus.FOUND);
						}

					}
				}
			}
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

	private int fixString(String date) {
		date = date.substring(date.length() - 2, date.length());
		return Integer.parseInt(date);
	}
}
