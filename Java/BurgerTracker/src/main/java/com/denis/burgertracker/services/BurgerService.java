package com.denis.burgertracker.services;

import com.denis.burgertracker.models.Burger;
import com.denis.burgertracker.repositories.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository){
        this.burgerRepository = burgerRepository;
    }

    public List<Burger> allBurgers(){
        return burgerRepository.findAll();
    }

    public Burger createBurger(Burger b){
        return burgerRepository.save(b);
    }

    public Burger findBurger(Long id){
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if (optionalBurger.isPresent()){
            return optionalBurger.get();
        }
        else{
            return null;
        }
    }
    public Burger updateBurger(Burger b){
        return burgerRepository.save(b);
    }
}
