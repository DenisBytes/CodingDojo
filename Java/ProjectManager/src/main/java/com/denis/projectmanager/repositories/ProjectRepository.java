package com.denis.projectmanager.repositories;

import com.denis.projectmanager.models.Project;
import com.denis.projectmanager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByParticipatedUsersNotContains(User user);

    List<Project> findByParticipatedUsersContains(User user);
}
