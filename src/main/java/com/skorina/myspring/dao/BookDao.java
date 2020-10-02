package com.skorina.myspring.dao;

import com.skorina.myspring.initilizers.ArrayListBookInit;
import com.skorina.myspring.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao implements Dao<Book> {

    private static int bookCounter;
    private List<Book> bookList;

    {
        bookList = ArrayListBookInit.getList();
        bookCounter = bookList.size();
    }

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    @Override
    public Book get(int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void create(Book item) {
        item.setId(++bookCounter);
        bookList.add(item);
    }

    @Override
    public void update(Book item) {
        for (Book book : bookList) {
            if (book.getId() == item.getId()) {
                book.setName(item.getName());
                book.setAuthor(item.getAuthor());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        bookList.removeIf(book -> book.getId() == id);
    }
}
