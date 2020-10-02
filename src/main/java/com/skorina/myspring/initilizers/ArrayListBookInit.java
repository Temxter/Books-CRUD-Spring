package com.skorina.myspring.initilizers;

import com.skorina.myspring.model.Book;

import java.util.ArrayList;

public class ArrayListBookInit {

    private ArrayListBookInit() {
    }

    static public ArrayList<Book> getList() {
        ArrayList<Book> bookList = new ArrayList<>();
        int counter = 0;
        bookList.add(new Book(++counter, "Harry Potter", "Joanne Rowling"));
        bookList.add(new Book(++counter, "An American Tragedy", "Theodore Dreiser"));
        bookList.add(new Book(++counter, "Sherlock Holmes", "Arthur Conan Doyle"));
        bookList.add(new Book(++counter, "Hamlet", "William Shakespeare"));
        return bookList;
    }
}
