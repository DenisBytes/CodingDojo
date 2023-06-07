package com.denis.safetravels.services;

import com.denis.safetravels.models.Travel;
import com.denis.safetravels.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    @Autowired
    TravelRepository travelRepository;

    public List<Travel> allTravels(){
        return travelRepository.findAll();
    }

    public Travel createTravel(Travel travel){
        return travelRepository.save(travel);
    }

    public Travel updateTravel(Travel travel){
        return travelRepository.save(travel);
    }

    public Travel findTravel(Long id){
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if (optionalTravel.isPresent()){
            return optionalTravel.get();
        }
        else{
            return null;
        }
    }
    public void deleteTravel(Long id){
        travelRepository.deleteById(id);
    }
}
