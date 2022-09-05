package com.lms.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Entity
@Table(name="tbr")
public class Tbr {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int tbrId;
	
	private int bookId;
	
	private int transactionId;
	
	//@Temporal(TemporalType.DATE)
    private String issueDate;
	
	//@Temporal(TemporalType.)
    private String scheduledReturn;
	
	//@Temporal(TemporalType.DATE)
    private String returnDate;
	
	private double fine;

	public Tbr(int bookId, int transactionId, String issueDate, String scheduledReturn, String returnDate,
			double fine) {
		super();
		this.bookId = bookId;
		this.transactionId = transactionId;
		this.issueDate = issueDate;
		this.scheduledReturn = scheduledReturn;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	public Tbr(int tbrId, int bookId, int transactionId, String issueDate, String scheduledReturn, String returnDate,
			double fine) {
		super();
		this.tbrId = tbrId;
		this.bookId = bookId;
		this.transactionId = transactionId;
		this.issueDate = issueDate;
		this.scheduledReturn = scheduledReturn;
		this.returnDate = returnDate;
		this.fine = fine;
	}
	
	

	
	
}
