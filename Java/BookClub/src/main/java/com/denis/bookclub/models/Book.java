package com.denis.bookclub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book is required")
    @Size(min = 3, max = 30,message = "min 3, max 30")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 3, max = 30,message = "min 3, max 30")
    private String author;

    @NotBlank(message = "Thoughts is required")
    @Size(min = 3, max = 30,message = "min 3, max 30")
    private String thoughts;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lentUser_id")
    private User lentUser;

    @PrePersist
    public void createOn(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void updateOn(){
        this.updatedAt = new Date();
    }

    public Book(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getLentUser() {
        return lentUser;
    }

    public void setLentUser(User lentUser) {
        this.lentUser = lentUser;
    }
}
