package org.lms.service;

import org.lms.bean.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookByName(String bookName);
    Optional<Book> getBookById(int bookId);
    Book addBook(Book book);
    Book deleteBook(int bookId);
}
