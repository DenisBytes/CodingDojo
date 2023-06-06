package com.denis.jpademo.controllers;

import com.denis.jpademo.models.Book;
import com.denis.jpademo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/{bookId}")
    public String show(Model model, @PathVariable("bookId") Long id){
        Book book = bookService.findBook(id);
        model.addAttribute("book",book);
        return "show";
    }
}

