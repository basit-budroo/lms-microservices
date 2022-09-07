package org.lms.service;

import java.util.List;

import org.lms.bean.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	@Override
	public boolean issueBook(int i, int j, Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String returnBook(int tranID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkDueReturnDate(int empID, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeBook(String bookName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book searchBook(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
