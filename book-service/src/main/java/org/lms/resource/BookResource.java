package org.lms.resource;

import org.lms.bean.Book;
import org.lms.bean.Books;
import org.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookResource {
    @Autowired
    private BookService bookService;


    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books getAllBooks() {
        return new Books(bookService.getAllBooks());
    }

    @GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookByIdResource(@PathVariable("id") int id) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        return bookOptional
                .map(book -> new ResponseEntity<>(book, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book saveBookResource(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book deleteBookByIdResource(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

    @PutMapping(path = "/books/{id}/{qt}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book increaseBookQuantity(@PathVariable("id") int id, @PathVariable("qt") int quantity) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        if (bookOptional.isPresent()) {
            bookService.deleteBook(id);
            int currentQuantity = bookOptional.get().getNumberOfBooks();
            bookOptional.get().setNumberOfBooks(currentQuantity + quantity);
            bookService.addBook(bookOptional.get());
            return bookOptional.get();
        }
        return new Book();
    }
}
