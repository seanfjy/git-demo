package com.fanstudy.pd.exp;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
