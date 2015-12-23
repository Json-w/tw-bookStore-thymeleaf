package com.thoughtworks.jimmy.repository;

import com.thoughtworks.jimmy.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
