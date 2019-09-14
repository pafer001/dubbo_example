package com.example.learn.aop.jdk;

public class BookService implements IBookService {

    @Override
    public void readBook() {

        System.out.println("----- read book!");
    }
}
