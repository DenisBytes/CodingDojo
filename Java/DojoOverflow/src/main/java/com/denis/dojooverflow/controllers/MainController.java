package com.denis.dojooverflow.controllers;

import com.denis.dojooverflow.models.Answer;
import com.denis.dojooverflow.models.Question;
import com.denis.dojooverflow.models.Tag;
import com.denis.dojooverflow.services.AnswerService;
import com.denis.dojooverflow.services.QuestionService;
import com.denis.dojooverflow.services.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    QuestionService questionService;

    @Autowired
    TagService tagService;

    @Autowired
    AnswerService answerService;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("questions", questionService.allQuestions());
        return "index";
    }

    @GetMapping("/questions/new")
    public String newQuestion(@ModelAttribute("question")Question question){
        return "newquestion";
    }

    @PostMapping("/questions/new")
    public String adding(@Valid @ModelAttribute("question") Question question,
                         BindingResult result, RedirectAttributes redirectAttributes,
                         @RequestParam (value = "listOfTags") String StringTags){
        if(result.hasErrors()){
            return "newquestion";
        }

        List<Tag> tagsToAdd = checkTags(StringTags);

        if(tagsToAdd == null || tagsToAdd.isEmpty()){
            redirectAttributes.addAttribute("error", "Must contain 1 and max 3");
            return "redirect:/questions/new";
        }

        question.setTags(tagsToAdd);
        questionService.createQuestion(question);

        return "redirect:/";
    }

    private List<Tag> checkTags(String tags){
        if(tags.length()>0) {
            ArrayList<Tag> questionTags = new ArrayList<Tag>();
            String[] tagList = tags.split(",");
            for(String tagString:tagList) {
                Tag tag = tagService.findBySubject(tagString.toLowerCase().strip());
                if(tag==null) {
                    tag = new Tag(tagString.toLowerCase().strip());
                    tagService.createTag(tag);
                }
                questionTags.add(tag);
            }
            return questionTags;
        }
        return null;
    }

    @GetMapping("/questions/{questionId}")
    public String view(@ModelAttribute("answer")Answer answer, Model model,
                       @PathVariable("questionId") Long questionId){

        Question question = questionService.findQuestion(questionId);

        model.addAttribute("question", question);
        return "showquestion";
    }

    @PostMapping("/questions/{questionId}")
    public String addAnswer(@Valid @ModelAttribute("answer") Answer answer,
                            BindingResult result,
                            @PathVariable("questionId") Long questionId){
        if(result.hasErrors()){
            return "showquestion";
        }

        answer.setQuestion(questionService.findQuestion(questionId));
        answerService.createAnswer(answer);

        return "redirect:/";
    }
}
