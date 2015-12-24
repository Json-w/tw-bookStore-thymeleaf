package com.thoughtworks.unit.test.serviceImplTest;

import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.repository.BookRepository;
import com.thoughtworks.jimmy.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class BookServiceImplTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_books_by_give_fuzzy_title() throws Exception {
        Iterable<Book> expected = Arrays.asList(new Book("12343", "clean code", "test", 35.5));
        String fuzzyTitle = "clean";
        when(bookRepository.findByTitleContaining(fuzzyTitle)).thenReturn(expected);

        Iterable<Book> result = bookService.findBooksByTitleContaining(fuzzyTitle);

        assertThat(expected, is(result));
    }
}
