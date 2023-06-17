package com.denis.projectmanager.services;

import com.denis.projectmanager.models.Project;
import com.denis.projectmanager.models.User;
import com.denis.projectmanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjectNotContains(User user){
        return projectRepository.findByParticipatedUsersNotContains(user);
    }

    public List<Project> getProjectContains(User user){
        return projectRepository.findByParticipatedUsersContains(user);
    }

    public void createProject(Project project){
        projectRepository.save(project);
    }
    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public Project findProject(Long id){
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(optionalProject.isPresent()){
            return optionalProject.get();
        }
        else {
            return null;
        }
    }

    public void deleteProject(Project project){
        projectRepository.delete(project);
    }
}
