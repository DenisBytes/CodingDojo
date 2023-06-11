package com.denis.dojoandninjas.services;

import com.denis.dojoandninjas.models.Dojo;
import com.denis.dojoandninjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    @Autowired
    DojoRepository dojoRepository;
    public List<Dojo> allDojos(){
        return dojoRepository.findAll();
    }

    public void createDojo(Dojo dojo){
        dojoRepository.save(dojo);
    }

    public void updateDojo(Dojo dojo){
        dojoRepository.save(dojo);
    }

    public Dojo findDojo(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        }
        else{
            return null;
        }
    }
}
