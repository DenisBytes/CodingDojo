package com.denis.studentroster.services;

import com.denis.studentroster.models.Dorm;
import com.denis.studentroster.models.Student;
import com.denis.studentroster.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public Student findStudent(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        else{
            return null;
        }
    }

    public void removeStudent(Student student){
        studentRepository.delete(student);
    }
}
