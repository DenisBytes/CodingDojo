package com.denis.burgertracker.services;

import com.denis.burgertracker.models.Burger;
import com.denis.burgertracker.repositories.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
}
