package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService();
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
//ny ændert Jens kl.15:03 02-12-2021 HttpSession session POST
  @PostMapping("/create-project")
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

  @PostMapping("/save")
  public String saveProject(@ModelAttribute Project project, User user) throws ErrorMessageException {
    projectService.createProject(project, user);
    return "redirect:/show-project";
  }

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/delete-project/{projectId}")
  public String deleteProject(@PathVariable int projectId) throws ErrorMessageException {
    projectService.deleteProject(projectId);
    return "show-projects";
  }
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  //@DeleteMapping


  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model) throws ErrorMessageException {
    List<Project> projects = projectService.showAllProjects(id);
    model.addAttribute("projects", projects);
    return "show-projects";
  }


  @ExceptionHandler(ErrorMessageException.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessagePage";
  }


}

//UDKOMMENTEREDE METODER:

  /* test af om vi bruger den -> BRUGES IKKE
//viser alle id nummere fra Project
  @GetMapping("/showallprojects")
  public String showAllProjects(Model model) {
    List<Project> projectId = projectService.showAll(1);
    model.addAttribute("Projectlist", projectId);
    return "show-projects";
  }
   */

  /*
  @PostMapping("/add-subproject/{projectid}")
  public String addSubprojectPost(@PathVariable("projectid") int projectid, @ModelAttribute Project project, Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    project.setProjectId(projectid); //kan kalde vores id her i stedet, skal laves i Thymeleaf
    projectService.addSubproject(project, subproject);
    return "redirect:/show-subprojects/" + projectid;
  }

   */

  /*
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject")
    public String updateSubproject(@ModelAttribute Subproject subproject) throws SQLException{
      projectService.updateSubproject(subproject);

      return "show-projects";
    }*/


