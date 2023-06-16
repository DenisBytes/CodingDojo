package com.denis.dojooverflow.services;

import com.denis.dojooverflow.models.Question;
import com.denis.dojooverflow.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> allQuestions(){
        return questionRepository.findAll();
    }

    public void createQuestion(Question question){
        questionRepository.save(question);
    }

    public Question findQuestion(Long id){
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()){
            return optionalQuestion.get();
        }
        else{
            return null;
        }
    }
}
