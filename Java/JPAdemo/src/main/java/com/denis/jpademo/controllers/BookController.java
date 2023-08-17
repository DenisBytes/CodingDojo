package com.denis.jpademo.controllers;

import com.denis.jpademo.models.Book;
import com.denis.jpademo.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String index(Model model){
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index";
    }
    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "new";
    }

    @PostMapping("")
    public String elaborate(@Valid @ModelAttribute("book") Book book,
                            BindingResult result){
        if (result.hasErrors()){
            return "/new";
        }
        bookService.createBook(book);
        return "redirect:/books";
    }

    @RequestMapping("/{bookId}")
    public String show(Model model, @PathVariable("bookId") Long id){
        Book book = bookService.findBook(id);
        model.addAttribute("book",book);
        return "show";
    }
}

