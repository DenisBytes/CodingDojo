package com.denis.bookclub.controllers;

import com.denis.bookclub.models.Book;
import com.denis.bookclub.models.LoginUser;
import com.denis.bookclub.models.User;
import com.denis.bookclub.services.BookService;
import com.denis.bookclub.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Mod10Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        session.setAttribute("loggedInUserID", null);
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @GetMapping("/books")
    public String books(Model model, HttpSession session){
        model.addAttribute("user",userService.findUser((Long)session.getAttribute("loggedInUserID")));
        model.addAttribute("books",bookService.allBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String addBook(@ModelAttribute("book")Book book, HttpSession session,
                          Model model){

        model.addAttribute("userId",(Long) session.getAttribute("loggedInUserID"));

        return"addbook";
    }

    @GetMapping("/books/{id}")
    public String bookDesc(@PathVariable("id") Long id, Model model,HttpSession session){
        Book book = bookService.findBook(id);

        model.addAttribute("loggedInUserId",(Long) session.getAttribute("loggedInUserID"));
        model.addAttribute("book",book);
        return "bookdesc";
    }
    @GetMapping("/books/edit/{bookId}")
    public String edit(@ModelAttribute("book")Book book,
                       @PathVariable("bookId") Long bookId,
                       HttpSession session, Model model){
        model.addAttribute("bookId",bookId);
        model.addAttribute("userID",(Long) session.getAttribute("loggedInUserID"));
        return "bookedit";
    }

    @GetMapping("/bookmarket")
    public String market(Model model, HttpSession session){
        model.addAttribute("user",userService.findUser((Long)session.getAttribute("loggedInUserID")));
        model.addAttribute("books",bookService.allBooks());

        return "bookmarket";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam("bookId") Long id, HttpSession session) {

        Book book = bookService.findBook(id);
        book.setLentUser((User)session.getAttribute("user"));
        User loggedUser = userService.findUser((Long)session.getAttribute("loggedInUserID"));
        loggedUser.getBorrowedBooks().add(book);

        return "redirect:/bookmarket";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("bookId") Long bookId, HttpSession session){

        Book returnBook = bookService.findBook(bookId);
        User loggedUser = userService.findUser((Long)session.getAttribute("loggedInUserID"));
        returnBook.setLentUser(null);
        loggedUser.getBorrowedBooks().remove(returnBook);


        return "redirect:/bookmarket";
    }

    @PutMapping("/books/{userID}/edit")
    public String editBook(@Valid @ModelAttribute("book") Book book,
                           @PathVariable("userID") Long userId,
                           @RequestParam("bookId") Long bookId,
                           BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("book", book);
            return "bookedit";
        }

        User user = userService.findUser(userId);
        book.setId(bookId);
        book.setUser(user);
        bookService.updateBook(book);

        return "redirect:/books";
    }

    @DeleteMapping("/books/delete/{bookId}")
    public String delete(@PathVariable("bookId") Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/bookcreate")
    public String bookCreate(@Valid @ModelAttribute("book") Book book,
                             @RequestParam("user") Long userId,
                             BindingResult result){
        if(result.hasErrors()){
            return "addbook";
        }

        User user = userService.findUser(userId);
        book.setUser(user);
        bookService.createBook(book);

        return "redirect:/books";
    }


    @PostMapping("/register")
    public String elaborate(@Valid @ModelAttribute("newUser")User user,
                            BindingResult result, HttpSession session,
                            Model model){
        userService.register(user, result);

        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }

        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/books";
    }

    @PostMapping("/login")
    public String elaborateLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                                 BindingResult result, Model model, HttpSession session){
        User user = userService.login(newLogin,result);

        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "index";
        }

        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/books";
    }
}
