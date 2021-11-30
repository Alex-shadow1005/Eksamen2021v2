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
//viser alle id nummere fra Project
  @GetMapping("/showall")
  public String showAll(Model model) {
    List<Project> projectId = projectService.showAll(1);
    model.addAttribute("Projectlist", projectId);
    return "show-projects";
  }


//sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/delete-project/{projectId}")
  public String deleteProject(@PathVariable int projectId) throws SQLException {
   projectService.deleteProject(projectId);
    return "show-projects";
  }
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  //@DeleteMapping

/*
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject")
    public String updateSubproject(@ModelAttribute Subproject subproject) throws SQLException{
      projectService.updateSubproject(subproject);

      return "show-projects";
    }*/


  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model) {
    List<Project> projects = projectService.showAll(id);
    model.addAttribute("projects", projects);
    return "show-projects";
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
    //We will return to this one ^
    user.setUserId(UserController.session.getUserId());
    projectService.addProject(project, user);
    return "redirect:/show/" + UserController.session.getUserId();
  }

  /*
  @PostMapping("/add-subproject/{projectid}")
  public String addSubprojectPost(@PathVariable("projectid") int projectid, @ModelAttribute Project project, Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    project.setProjectId(projectid); //kan kalde vores id her i stedet, skal laves i Thymeleaf
    projectService.addSubproject(project, subproject);
    return "redirect:/show-subprojects/" + projectid;
  }

   */

}
