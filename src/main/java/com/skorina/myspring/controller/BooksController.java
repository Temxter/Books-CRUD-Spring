package com.skorina.myspring.controller;

import com.skorina.myspring.dao.BookDao;
import com.skorina.myspring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDao bookDao;

    @Autowired
    public BooksController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "books/book_list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDao.get(id));
        return "books/edit";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book) {
        bookDao.create(book);
        return "redirect:/books";
    }

    @PutMapping
    public String update(@ModelAttribute("book") Book book) {
        bookDao.update(book);
        return "/books/book_list"; // or redirect?
    }

    @DeleteMapping
    public String delete(@RequestParam("id") int id) {
        bookDao.delete(id);
        return "/books/book_list";
    }
}
