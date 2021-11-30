package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.ProjectService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;
@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService();
  User user = new User();


  @GetMapping("/add-project")
  public String addProject(@ModelAttribute Project project, Model model) {
    model.addAttribute("project", project);
    model.addAttribute("sessionID", UserController.session.getUser_id());
    System.out.println(project.getProject_name() + project.getProject_description() + project.getProject_price());
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
 @GetMapping("/delete-subproject/{subprojectId}")
  public String deleteSubproject(@PathVariable int subprojectId) throws SQLException {
    projectService.deleteSubproject(subprojectId);

    return "show-projects";
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
    return "show-projects";
  }

  @GetMapping("/show-subprojects")
  public String showSubprojects(@PathVariable("projectid2") int projectid2, Project project, Model model) { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    List<Subproject> subprojects = projectService.showAllSubprojects(projectid2);
    model.addAttribute("subproject", subprojects);
    System.out.println("show subproject test" + subprojects);
    return "redirect:/show-subprojects/" + project.getProject_id();
  }

    /*
  @GetMapping("/show-subprojects/{id}")
  public String showSubprojects(@PathVariable("projectid") int projectid, Model model) {
    List<Subproject> subprojects = projectService.showAllSubprojects(projectid);
    System.out.println("project id test here: " + projectid);
    model.addAttribute("subprojects", subprojects);
    return "show-subprojects";
  }

     */

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
    return "redirect:/show-subprojects/" + projectid;
  }

}
