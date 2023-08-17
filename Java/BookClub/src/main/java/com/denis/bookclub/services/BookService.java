package com.denis.bookclub.services;

import com.denis.bookclub.models.Book;
import com.denis.bookclub.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()){
            return optionalBook.get();
        }

        else{
            return null;
        }
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
