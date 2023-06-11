package com.denis.studentroster.repositories;

import com.denis.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
