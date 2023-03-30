package com.fanstudy.pd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanstudy.pd.config.BookContainer;
import com.fanstudy.pd.exp.IsbnNotFoundException;
import com.fanstudy.pd.model.Book;

@RestController
public class BookController {

    //注入BookContainer
    @Autowired
    private BookContainer bookContainer;

    //根据isn查询图书,如果没有查询到,抛出异常
    @GetMapping("/book")
    public Book getBook(String isbn){
        Optional<Book> first = bookContainer.getBooks().stream().filter(e -> e.isbn().equals(isbn)).findFirst();
        if (first.isEmpty()){
//            throw new BookNotFoundException("isbn:"+isbn+"->没有此图书");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND,"isbn:"+isbn+"->没有此图书");
        }
        return first.get();
    }
}
