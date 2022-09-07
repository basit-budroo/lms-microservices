package org.lms.bean;

public class Employee {
    
    private int employeeId;
    private String employeeFn;
    private String employeeLn;
    private String desg;
    private int booksIssued;

    public Employee(int employeeId, String employeeFn, String employeeLn, String desg, int booksIssued) {
        this.employeeId = employeeId;
        this.employeeFn = employeeFn;
        this.employeeLn = employeeLn;
        this.desg = desg;
        this.booksIssued = booksIssued;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFn() {
        return employeeFn;
    }

    public void setEmployeeFn(String employeeFn) {
        this.employeeFn = employeeFn;
    }

    public String getEmployeeLn() {
        return employeeLn;
    }

    public void setEmployeeLn(String employeeLn) {
        this.employeeLn = employeeLn;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }
}