package com.example.learn.aop.jdk;

public class JdkAopTest {

    public static void main(String[] args) {

//        final BookInvocationHandler bookInvocationHandler = new BookInvocationHandler(new BookService());
//        final IBookService bookService2 = (IBookService)(bookInvocationHandler.getProxy());
//        final IBookService bookService1 = (IBookService)(bookInvocationHandler.getProxy());
//        bookService2.readBook();
        final BookService bookService = new BookService();
        final IBookService bookInvocation1 = createBookInvocation(bookService);
        final IBookService bookInvocation2 = createBookInvocation(bookService);

        System.out.println(bookInvocation1==bookInvocation2);

    }


    public static IBookService  createBookInvocation(Object object) {
        final BookInvocationHandler bookInvocationHandler = new BookInvocationHandler(object);
        return (IBookService)(bookInvocationHandler.getProxy());
    }
}
