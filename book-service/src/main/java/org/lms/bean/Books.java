package org.lms.bean;

import java.util.List;

public class Books {
    private List<Book> bookList;
    public Books(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
