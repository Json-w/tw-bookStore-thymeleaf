package com.thoughtworks.integration.test.controller;

import com.thoughtworks.jimmy.SpringBootWebApplication;
import com.thoughtworks.jimmy.controller.BookShelfController;
import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
@WebAppConfiguration
@Transactional
public class BookShelfControllerTest {
    MockMvc mockMvc;
    @Autowired
    private BookShelfController bookShelfController;
    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookShelfController).build();

    }

    @Test
    public void should_return_books_by_given_fuzzy_title() throws Exception {
        bookRepository.save(Arrays.asList(
                new Book("12343", "clean code", "test", 35.5),
                new Book("179510", "java code", "test", 35.2),
                new Book("12333", "java clean code", "test", 35.35)
                ));

        mockMvc.perform(get(String.format("/book/title/%s", "clean")))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("java clean code")))
                .andExpect(jsonPath("$[1].title", is("clean code")));
    }
}
