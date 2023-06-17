package com.denis.projectmanager.repositories;

import com.denis.projectmanager.models.Project;
import com.denis.projectmanager.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();

    List<Task> findByProject(Project project);
}
