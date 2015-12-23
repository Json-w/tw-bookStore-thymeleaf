package com.thoughtworks.jimmy.controller;

import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.model.Status;
import com.thoughtworks.jimmy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.Map;

@RestController
public class BookShelfController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Book> queryBooks() {
        return bookService.findAll();
    }

    @RequestMapping(value = "book/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String isbn) {

        return bookService.findByIsbn(isbn);
    }

    @RequestMapping(value = "book/new", method = RequestMethod.POST)
    public Status newBook(Book book, Status status) {
        if (bookService.addBook(book)) {
            status = new Status(1, "success");
        } else {
            status = new Status(0, "failure");
        }
        status = new Status(1, "success");
        return status;
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public Status editBook(@RequestBody Book book, Status status) {
        if (bookService.editBook(book)) {
            status = new Status(1, "success");
        } else {
            status = new Status(0, "failure");
        }
        return status;
    }

    @RequestMapping(value = "book/{isbn}", method = RequestMethod.DELETE)
    public Status deleteBook(@PathVariable String isbn, Status status) {
        if (bookService.delete(isbn)) {
            status = new Status(1, "success");
        } else {
            status = new Status(0, "failure");
        }
        return status;
    }

}
