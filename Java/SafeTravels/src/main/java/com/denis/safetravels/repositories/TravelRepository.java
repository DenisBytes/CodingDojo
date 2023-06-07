package com.denis.safetravels.repositories;

import com.denis.safetravels.models.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
    List<Travel> findAll();
    Optional<Travel> findById(Long id);

    void deleteById(Long id);
}
