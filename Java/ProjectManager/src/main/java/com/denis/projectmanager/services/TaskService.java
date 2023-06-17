package com.denis.projectmanager.services;

import com.denis.projectmanager.models.Project;
import com.denis.projectmanager.models.Task;
import com.denis.projectmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void createTask(Task task){
        taskRepository.save(task);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> allTAsksByProject(Project project){
        return taskRepository.findByProject(project);
    }
}
