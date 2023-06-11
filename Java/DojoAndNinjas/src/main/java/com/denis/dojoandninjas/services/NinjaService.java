package com.denis.dojoandninjas.services;

import com.denis.dojoandninjas.models.Ninja;
import com.denis.dojoandninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    NinjaRepository ninjaRepository;
    public List<Ninja> allNinjas(){
        return ninjaRepository.findAll();
    }

    public void createNinja(Ninja ninja){
        ninjaRepository.save(ninja);
    }

    public void updateNinja(Ninja ninja){
        ninjaRepository.save(ninja);
    }

    public Ninja finNinja(Long id) {
        Optional<Ninja> optionalninja = ninjaRepository.findById(id);
        if (optionalninja.isPresent()) {
            return optionalninja.get();
        } else {
            return null;
        }
    }
}
