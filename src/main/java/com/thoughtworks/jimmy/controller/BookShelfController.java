package com.thoughtworks.jimmy.controller;

import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "book/new", method = RequestMethod.GET)
    public String toNewBook() {
        return "newBook";
    }

    @RequestMapping(value = "book/new", method = RequestMethod.POST)
    public String newBook(Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "book/edit/{isbn}", method = RequestMethod.GET)
    public ModelAndView toEditBook(@PathVariable String isbn, Map<String, Object> map) {
//        map.put("book", bookService.findByIsbn(isbn));
        ModelMap modelMap = new ModelMap();
        modelMap.put("book", bookService.findByIsbn(isbn));
        return new ModelAndView("editBook", modelMap);
        //return "editBook";
    }

    @RequestMapping(value = "book/edit", method = RequestMethod.POST)
    public String editBook(Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }
}
