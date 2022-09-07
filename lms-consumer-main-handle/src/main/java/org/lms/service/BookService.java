package org.lms.service;

import java.util.List;

import org.lms.bean.Book;

public interface BookService {

	boolean issueBook(int i, int j, Object object);

	String returnBook(int tranID);

	String checkDueReturnDate(int empID, int bookId);

	List<Book> getAllBooks();

	boolean removeBook(String bookName);

	Book searchBook(String name);

	boolean addBook(Book book);


	
}
