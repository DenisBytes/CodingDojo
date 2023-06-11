package com.denis.studentroster.controllers;

import com.denis.studentroster.models.Dorm;
import com.denis.studentroster.models.Student;
import com.denis.studentroster.services.DormService;
import com.denis.studentroster.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    DormService dormService;

    @Autowired
    StudentService studentService;

    //Get Routes
    @GetMapping("/dorms")
    public String index(Model model){
        model.addAttribute("dorms", dormService.allDroms());

        return "index";
    }

    @GetMapping("/dorms/new")
    public String dormIndex(@ModelAttribute("dorm")Dorm dorm){
        return "dormindex";
    }

    @GetMapping("/students/new")
    public String studentIndex(@ModelAttribute("student")Student student, Model model){
        model.addAttribute("dorms",dormService.allDroms());
        return "studentindex";
    }

    @GetMapping("/dorms/{dormsId}")
    public String dormsNewIndex(@PathVariable("dormsId") Long id, Model model){
        Dorm optionalDorm = dormService.findDorm(id);
        model.addAttribute("dorm",optionalDorm);
        model.addAttribute("students", studentService.allStudents());

        return "dormstudents";
    }
    @GetMapping("/dorms/remove/{studentId}")
    public String remove(@PathVariable("studentId") Long studentId){
        dormService.deleteStudent(studentId);
        return "redirect:/dorms";
    }







    //Post routes

    @PostMapping("/dorms/new")
    public String postDorm(@Valid @ModelAttribute("dorm") Dorm dorm,
                           BindingResult result){
        if(result.hasErrors()){
            return "dormindex";
        }
        else{
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }

    @PostMapping("/students/new")
    public String postStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result){
        if(result.hasErrors()){
            return "studentindex";
        }
        else{
            studentService.createStudent(student);
            return "redirect:/dorms";
        }
    }

    @PutMapping("/dorms/{dormsId}")
    public String dormUpdate(@Valid @ModelAttribute("dorm") Dorm dorm,
                             @PathVariable("dormsId") Long id,
                             @RequestParam("students") Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dormstudents";
        } else {
            dormService.studentSelectDorm(student.getId(), id);

            return "redirect:/dorms/{id}";
        }
    }
}
