package com.denis.dojooverflow.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String text;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable=false)
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;


    @PrePersist
    public void createOn(){
        this.createdAt = new Date();
    }
    @PreUpdate
    public void updateOn(){
        this.updatedAt = new Date();
    }

    public Answer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
