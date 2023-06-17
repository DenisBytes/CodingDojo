package com.denis.projectmanager.controllers;

import com.denis.projectmanager.models.LoginUser;
import com.denis.projectmanager.models.Project;
import com.denis.projectmanager.models.Task;
import com.denis.projectmanager.models.User;
import com.denis.projectmanager.services.ProjectService;
import com.denis.projectmanager.services.TaskService;
import com.denis.projectmanager.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    TaskService taskService;

    //INDEX PAGE
    @GetMapping("/")
    public String index(@ModelAttribute("newUser")User user,
                        @ModelAttribute("newLogin")LoginUser loginUser,
                        HttpSession session){
        session.setAttribute("loggedInUserID", null);
        return"index";
    }

    //REGISTERING THE USER
    @PostMapping("/register")
    public String registerIndex(@Valid @ModelAttribute("newUser")User user,
                                BindingResult result, Model model, HttpSession session){
        userService.register(user,result);

        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/dashboard";
    }

    //LOGGING IN THE USER
    @PostMapping("/login")
    public String loginIndex(@Valid @ModelAttribute("newLogin") LoginUser loginUser,
                             BindingResult result, Model model, HttpSession session){
        User user = userService.login(loginUser,result);

        if(result.hasErrors()){
            model.addAttribute("newUser",new User());
            return "index";
        }

        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/dashboard";
    }




    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){
        model.addAttribute("user",userService.findUser((Long) session.getAttribute("loggedInUserID")));
        model.addAttribute("projectsNotContains",
                projectService.getProjectNotContains(userService.findUser((Long) session.getAttribute("loggedInUserID"))));
        model.addAttribute("projectsContains", projectService.getProjectContains(userService.findUser((Long) session.getAttribute("loggedInUserID"))));


        return "dashboard";
    }

    @GetMapping("/projects/new")
    public String newproject(@ModelAttribute("project") Project project, Model model, HttpSession session){
        model.addAttribute("user",userService.findUser((Long) session.getAttribute("loggedInUserID")));

        return "newproject";
    }

    @PostMapping("/projects/new")
    public String addingProject(@Valid @ModelAttribute("project") Project project,
                                BindingResult result, HttpSession session){
        if(result.hasErrors()){
            System.out.println(result);
            return "newproject";
        }
        project.setTeamLeader(userService.findUser((Long) session.getAttribute("loggedInUserID")));
        projectService.createProject(project);
        return"redirect:/dashboard";
    }
    @GetMapping("/jointeam/{projectId}")
    public String jointeam(HttpSession session,@PathVariable("projectId") Long projectId){
        User user = userService.findUser((Long) session.getAttribute("loggedInUserID"));
        Project project = projectService.findProject(projectId);

        project.getParticipatedUsers().add(user);
        user.getParticpatedProjects().add(project);
        userService.saveUser(user);
        projectService.saveProject(project);

        return "redirect:/dashboard";
    }

    @GetMapping("/leaveteam/{projectId}")
    public String levaingTeam(HttpSession session, @PathVariable(name = "projectId") Long projectId){
        User user = userService.findUser((Long) session.getAttribute("loggedInUserID"));
        Project project = projectService.findProject(projectId);

        project.getParticipatedUsers().remove(user);
        user.getParticpatedProjects().remove(project);
        userService.saveUser(user);
        projectService.saveProject(project);

        return "redirect:/dashboard";
    }

    @GetMapping("/projects/edit/{projectId}")
    public String editProject(@PathVariable(name = "projectId")Long projectId,Model model){
        Project project = projectService.findProject(projectId);
        model.addAttribute("project", project);

        return "editproject";
    }

    @PutMapping("/projects/{projectId}")
    public String editing(@Valid @ModelAttribute("project") Project project,
                          @PathVariable(name = "projectId") Long projectId,
                          BindingResult result, HttpSession session){
        if(result.hasErrors()){
            System.out.println(result);
            return "editproject";
        }

        project.setTeamLeader(userService.findUser((Long) session.getAttribute("loggedInUserID")));
        project.setId(projectId);
        projectService.saveProject(project);

        return  "redirect:/dashboard";
    }

    @GetMapping("/projects/{projectId}")
    public String showProject(@PathVariable(name = "projectId") Long projectId, Model model, HttpSession session){

        Project project = projectService.findProject(projectId);
        model.addAttribute("project", project);
        model.addAttribute("user", userService.findUser((Long) session.getAttribute("loggedInUserID")));

        return "showproject";

    }

    @GetMapping("/projects/delete/{projectId}")
    public String deleteProject(@PathVariable(name = "projectId")Long projectId,HttpSession session){

        User user = userService.findUser((Long) session.getAttribute("loggedInUserID"));
        Project project = projectService.findProject(projectId);

        projectService.deleteProject(project);
        return "redirect:/dashboard";
    }

    @GetMapping("/projects/{projectId}/tasks")
    public String tasks(@ModelAttribute("task")Task task,
                        @PathVariable(name = "projectId")Long projectId,
                        HttpSession session, Model model){
        Project project = projectService.findProject(projectId);
        model.addAttribute("tasks", taskService.allTAsksByProject(project));
        model.addAttribute("project", project);

        return "tasksindex";
    }

    @PostMapping("/projects/{projectId}/tasks")
    public String addingTask(@Valid @ModelAttribute("task")Task task,
                             @PathVariable(name = "projectId") Long projectId,
                             BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "tasksindex";
        }
        task.setProject(projectService.findProject(projectId));
        task.setUser(userService.findUser((Long) session.getAttribute("loggedInUserID")));
        taskService.saveTask(task);

        return "redirect:/projects/"+projectId+"/tasks";
    }
}
