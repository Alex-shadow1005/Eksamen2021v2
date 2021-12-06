package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.ProjectService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService();

  @GetMapping("/add-project")
  public String addProject(@ModelAttribute Project project, Model model) {
    model.addAttribute("project", project);
    model.addAttribute("sessionID", UserController.session.getUserId());
    System.out.println(project.getProjectName() + project.getProjectDescription() + project.getProjectPrice());
    return "add-project";
  }

  @PostMapping("/add-project")
  public String addProjectPost(@ModelAttribute Project project, User user, Model model) {
    model.addAttribute("project", project);
    user.setUserId(UserController.session.getUserId());
    projectService.addProject(project, user);
    return "redirect:/show/" + UserController.session.getUserId();
  }

//sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/delete-project/{projectId}")
  public String deleteProject(@PathVariable int projectId) throws SQLException {
   projectService.deleteProject(projectId);
    return "show-projects";
  }
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  //@DeleteMapping


  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model, User user) {
    List<Project> projects = projectService.showAllProjects(id);
    model.addAttribute("projects", projects);
    model.addAttribute("user", user);
    return "show-projects";
  }

  /*
  @PostMapping("/save")
  public String saveProject(@ModelAttribute Project project, User user) {
    projectService.addProject(project, user);
    return "redirect:/show-project";
  }

   */


}

//UDKOMMENTEREDE METODER:

  /*
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject")
    public String updateSubproject(@ModelAttribute Subproject subproject) throws SQLException{
      projectService.updateSubproject(subproject);

      return "show-projects";
    }*/


