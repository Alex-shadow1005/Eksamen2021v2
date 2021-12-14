package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.ProjectServiceImpl;
import com.example.eksamen2021.domain.services.SubprojectServiceImpl;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProjectControllerImpl implements ProjectController {
  private ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
  private SubprojectServiceImpl subprojectServiceImpl = new SubprojectServiceImpl();



  @GetMapping("/create-project")
  public String addProject(@ModelAttribute Project project, Model model, HttpSession session) throws ProjectErrorMessageException {
    model.addAttribute("project", project);
    User usersession = (User) session.getAttribute("session");
    model.addAttribute("sessionID", usersession.getUserId());
    return "create-project";
  }


  @PostMapping("/create-project")
  public String createProject(@ModelAttribute Project project, User user, Model model, HttpSession session) throws ProjectErrorMessageException {
    model.addAttribute("project", project);

    User usersession = (User) session.getAttribute("session");
    user.setUserId(usersession.getUserId());

    projectServiceImpl.createProject(project, user);
    return "redirect:/show/" + usersession.getUserId();
  }

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/update-project/{projectId}")
  public String updateproject(@PathVariable("projectId") int projectId, Model model) throws ProjectErrorMessageException {
    Project project = projectServiceImpl.findProjectID(projectId);
    model.addAttribute("project", project);
    return "update-project";
  }

  //Post
  @PostMapping("/new-update-project")
  public String updateProject(@ModelAttribute Project project, User user, HttpSession session) throws ProjectErrorMessageException {
    User usersession = (User) session.getAttribute("session");//jens
    user.setUserId(usersession.getUserId());
    projectServiceImpl.updateProject(project);
    return "redirect:/show/" + usersession.getUserId();
  }

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/delete-project/{projectId}")
  public String deleteProject(@PathVariable int projectId, User user, HttpSession session) throws ProjectErrorMessageException {
    User usersession = (User) session.getAttribute("session");//jens
    user.setUserId(usersession.getUserId());
    projectServiceImpl.deleteProject(projectId);
    return "redirect:/show/" + usersession.getUserId();
  }
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  //@DeleteMapping


  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model, User user) throws ProjectErrorMessageException, SubProjectErrorMessageException {

    List<Project> projects = projectServiceImpl.showAllProjects(id);
    List<Subproject> gettingAllSubprojects = subprojectServiceImpl.gettingAllSubprojects();

    projectServiceImpl.calprojecthours(gettingAllSubprojects, projects);
    projectServiceImpl.calprojectprices(gettingAllSubprojects, projects);

    model.addAttribute("projects", projects);
    model.addAttribute("user", user);
    return "show-projects";
  }


  public String handleProjectError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessageExceptions/project-error-message-exception";
  }

}

//UDKOMMENTEREDE METODER:


