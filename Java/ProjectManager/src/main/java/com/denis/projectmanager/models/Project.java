package com.denis.projectmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required!")
    @Size(min = 3, max=30,message = "Title has to be at least 3 characters")
    private String title;

    @NotBlank(message = "Description is required!")
    @Size(min = 3, message = "Description has to be at least 3 characters")
    private String description;

    @NotNull(message = "Date is required!")
    @FutureOrPresent(message = "Due date must not be in the past")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamLeader_id")
    private User teamLeader;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participatedUsers;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    public void createOn(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void updateOn(){
        this.updatedAt = new Date();
    }

    public Project(){
        this.participatedUsers = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public Project(Long id, String title, String description, LocalDate dueDate, User teamLeader, List<User> participatedUsers, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.teamLeader = teamLeader;
        this.participatedUsers = participatedUsers;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(User teamLeader) {
        this.teamLeader = teamLeader;
        this.participatedUsers.add(teamLeader);
    }

    public List<User> getParticipatedUsers() {
        return participatedUsers;
    }

    public void setParticipatedUsers(List<User> participatedUsers) {
        this.participatedUsers = participatedUsers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
