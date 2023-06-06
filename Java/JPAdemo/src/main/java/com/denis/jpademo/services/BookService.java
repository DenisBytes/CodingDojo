package com.denis.jpademo.services;

import com.denis.jpademo.models.Book;
import com.denis.jpademo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    // adding the book repository as a dependency
    @Autowired
    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // creates a book
    public Book updateBook(Long id,
                           String title,
                           String desc,
                           String lang,
                           int numOfPages) {
        Book b = new Book();
        b.setDescription(desc);
        b.setId(id);
        b.setLanguage(lang);
        b.setNumberOfPages(numOfPages);
        b.setTitle(title);

        return bookRepository.save(b);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
