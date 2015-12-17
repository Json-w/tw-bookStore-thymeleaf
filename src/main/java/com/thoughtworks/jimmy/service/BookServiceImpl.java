package com.thoughtworks.jimmy.service;

import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findOne(isbn);
    }

    @Override
    public boolean addBook(Book book) {
        bookRepository.addOne(book);
        if (null != bookRepository.findOne(book.getIsbn())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String isbn) {
        bookRepository.delete(isbn);
        if (null == bookRepository.findOne(isbn)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editBook(Book book) {
        if (null == bookRepository.findOne(book.getIsbn())) {
            return false;
        }
        bookRepository.addOne(book);
        return true;
    }

}
