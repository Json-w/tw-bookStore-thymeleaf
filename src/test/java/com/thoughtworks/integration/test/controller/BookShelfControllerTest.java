package com.thoughtworks.integration.test.controller;

import com.thoughtworks.jimmy.SpringBootWebApplication;
import com.thoughtworks.jimmy.controller.BookShelfController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
@WebAppConfiguration
@Transactional
public class BookShelfControllerTest {
    MockMvc mockMvc;
    @Autowired
    private BookShelfController

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(BookShelfControllerTest.class).build();

    }

    @Test
    public void should_return_books_by_given_fuzzy_title() throws Exception {
        mockMvc.perform(get(format("/book/%s",)))
    }
}
