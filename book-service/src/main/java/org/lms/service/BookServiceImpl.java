package org.lms.service;

import org.lms.bean.Book;
import org.lms.persistence.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Optional<Book> getBookByName(String bookName) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public Book deleteBook(int id) {
        Optional<Book> bookOptional = bookDAO.findById(id);
        if (bookOptional.isPresent()) {
            bookDAO.deleteById(id);
            return bookOptional.get();
        }
        return new Book();
    }
}
