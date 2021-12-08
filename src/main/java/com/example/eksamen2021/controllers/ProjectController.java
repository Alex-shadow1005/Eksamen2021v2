package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.CalculateService;
import com.example.eksamen2021.domain.services.ProjectService;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService();
  private CalculateService calculateService = new CalculateService();
  private SubprojectRepositoryImpl subprojectRepository = new SubprojectRepositoryImpl();


  //ny ændert Jens kl.15:03 02-12-2021 HttpSession session GET
  @GetMapping("/create-project")
  public String addProject(@ModelAttribute Project project, Model model, HttpSession session) throws ErrorMessageException {
    model.addAttribute("project", project);
    User usersession = (User) session.getAttribute("session");//jens
    model.addAttribute("sessionID", usersession.getUserId());

    System.out.println(project.getProjectName() + project.getProjectDescription() + project.getProjectPrice());
    return "create-project";
  }//før ændert Jens kl.14:33 03-12-2021
/*  @GetMapping("/create-project")
  public String addProject(@ModelAttribute Project project, Model model) throws ErrorMessageException {
    model.addAttribute("project", project);
    model.addAttribute("sessionID", UserController.session.getUserId());
    System.out.println(project.getProjectName() + project.getProjectDescription() + project.getProjectPrice());
    return "create-project";
  } */
//ny ændert Jens kl.1 02-12-2021 HttpSession session POST
  /*@PostMapping("/create-project")
  public String createProject(@ModelAttribute Project project, User user, Model model,HttpSession session) throws ErrorMessageException {
    model.addAttribute("project", project);
    User usersession = (User) session.getAttribute("session");//jens
    user.setUserId(usersession.getUserId());
    projectService.createProject(project, user);
    return "redirect:/show/" + usersession.getUserId();
  }//før ændert Jens kl.14:33 03-12-2021
/* @PostMapping("/create-project")
  public String createProject(@ModelAttribute Project project, User user, Model model) throws ErrorMessageException {
    model.addAttribute("project", project);
    user.setUserId(UserController.session.getUserId());
    projectService.createProject(project, user);
    return "redirect:/show/" + UserController.session.getUserId();
  }

 */
//ny ændert alex kl.15:03 02-12-2021 HttpSession session POST
@PostMapping("/create-project")
public String createProject(@ModelAttribute Project project, User user, Model model,HttpSession session) throws ErrorMessageException {
  model.addAttribute("project", project);
  User usersession = (User) session.getAttribute("session");//jens
  user.setUserId(usersession.getUserId());
  projectService.createProject(project, user);
  return "redirect:/show/" + usersession.getUserId();
}

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/update-project/{projectId}")
  public String updateproject(@PathVariable("projectId") int projectId, Model model) throws ErrorMessageException {
    Project project = projectService.findProjectID(projectId);
    model.addAttribute("project", project);
    return "udate2";
  }

  //Post
  @PostMapping("/new-update-project")
  public String updateProject(@ModelAttribute Project project) throws ErrorMessageException {
    projectService.updateProject(project);
    return "redirect:/show-projects";
  }

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/delete-project/{projectId}")
  public String deleteProject(@PathVariable int projectId, Model model) throws ErrorMessageException {
    model.addAttribute("projectId", projectId);
    System.out.println("Yo yo yo");
    System.out.println(projectId);
    projectService.deleteProject(projectId);
    return "redirect:/show/";
  }
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  //@DeleteMapping


  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model, User user) throws ErrorMessageException {

    List<Project> projects = projectService.showAllProjects(id);
    List<Subproject> subprojects = subprojectRepository.showAllSubprojects(id);

   calculateService.calprojecthours(subprojects,projects);
   calculateService.calprojectprice(subprojects,projects);


    model.addAttribute("projects", projects);
    model.addAttribute("user", user);
    return "show-projects";
  }


  @ExceptionHandler(ErrorMessageException.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessagePage";
  }
}

//UDKOMMENTEREDE METODER:


