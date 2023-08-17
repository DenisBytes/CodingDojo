package com.denis.studentroster.services;

import com.denis.studentroster.models.Dorm;
import com.denis.studentroster.models.Student;
import com.denis.studentroster.repositories.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DormService {
    @Autowired
    DormRepository dormRepository;
    @Autowired
    StudentService studentService;

    public List<Dorm> allDroms(){
        return dormRepository.findAll();
    }

    public void createDorm(Dorm dorm){
        dormRepository.save(dorm);
    }

    public void updateDorm(Dorm dorm){
        dormRepository.save(dorm);
    }

    public Dorm findDorm(Long id){
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()){
            return optionalDorm.get();
        }
        else{
            return null;
        }
    }

}
