package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.ProjectService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ProjectController {
  private ProjectService projectService = new ProjectService();


  @GetMapping("/add-project")
  public String addProject(@ModelAttribute Project project, Model model) {
    model.addAttribute("project", project);
    model.addAttribute("sessionID", UserController.session.getUser_id());
    System.out.println(project.getProject_name() + project.getProject_description() + project.getProject_price());
    return "add-project";
  }

  @GetMapping("/add-subproject")
  public String addSubproject(@ModelAttribute Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    model.addAttribute("sessionID", UserController.session.getUser_id());
    //System.out.println(project.getProject_name() + project.getProject_description() + project.getProject_price());
    return "add-subproject";
  }

  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model) {
    List<Project> projects = projectService.showAll(id);
    model.addAttribute("projects", projects);
    return "show-project2";
  }

  @GetMapping("/showsubprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, Model model) {
    List<Subproject> subprojects = projectService.showAllSubprojects(id);
    model.addAttribute("subprojects", subprojects);
    return "show-project2";
  }

  @PostMapping("/save")
  public String saveProject(@ModelAttribute Project project, User user) {
    projectService.addProject(project, user);
    return "redirect:/show-project";
  }

  @PostMapping("/add-project")
  public String addProjectPost(@ModelAttribute Project project, User user, Model model) {
    model.addAttribute("project", project);
    //System.out.println(wish.getWishName() + wish.getWishDescription() + wish.getWishPrice());
    user.setUser_id(UserController.session.getUser_id());
    projectService.addProject(project, user);
    return "redirect:/show/" + UserController.session.getUser_id();
  }

  @PostMapping("/add-subproject/{projectid}")
  public String addSubprojectPost(@PathVariable("projectid") int projectid, @ModelAttribute Project project, Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    project.setProject_id(projectid); //kan kalde vores id her i stedet, skal laves i Thymeleaf
    projectService.addSubproject(project, subproject);
    return "redirect:/show/" + projectid;
  }

}
