package com.lms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbrdata {
	private int tbrId;
	private int bookId;
	private int transactionId;
	private int employeeId;
    private String issueDate;
    private String scheduledReturn;
    private String returnDate;
}
