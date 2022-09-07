package org.lms.bean;

public class Book {
    
    private int bookId;
    private String bookName;
    private int isbnNumber;
    private String bookAuthor;
    private String bookPublisher;
    private String bookType;
    private int noOfBooks;

    public Book() {
    }

    public Book(int bookId, String bookName, int isbnNumber, String bookAuthor, String bookPublisher, String bookType, int noOfBooks) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbnNumber = isbnNumber;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookType = bookType;
        this.noOfBooks = noOfBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(int isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getNumberOfBooks() {
        return noOfBooks;
    }

    public void setNumberOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
}