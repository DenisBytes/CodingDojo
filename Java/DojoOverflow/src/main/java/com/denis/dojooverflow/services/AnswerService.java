package com.denis.dojooverflow.services;

import com.denis.dojooverflow.models.Answer;
import com.denis.dojooverflow.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService{

    @Autowired
    AnswerRepository answerRepository;
    public List<Answer> allAnswers(){
        return answerRepository.findAll();
    }

    public void createAnswer(Answer answer){
        answerRepository.save(answer);
    }
}
