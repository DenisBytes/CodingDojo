package com.denis.auth.repositories;

import com.denis.auth.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// imports removed for brevity
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

    List<Role> findByName(String name);
}

