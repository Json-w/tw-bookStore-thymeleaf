package com.thoughtworks.jimmy.service;

import com.thoughtworks.jimmy.model.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    boolean addBook(Book book);

    boolean delete(String isbn);

    boolean editBook(Book book);
}
