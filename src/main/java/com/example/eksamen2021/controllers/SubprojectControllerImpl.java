package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.SubprojectServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SubprojectControllerImpl implements SubprojectController {

  private SubprojectServiceImpl subprojectServiceImpl = new SubprojectServiceImpl();
  public static Project currentProject = new Project();

  //@Author: Jens, Kristian, Silke
  @GetMapping("/create-subproject")
  public String addSubproject(@ModelAttribute Subproject subproject, Model model) throws SubProjectErrorMessageException {
    model.addAttribute("subproject", subproject);
    model.addAttribute("currentproject", currentProject.getProjectId());
    return "create-subproject";
  }

  //@Author: Jens, Kristian, Silke
  @PostMapping("/create-subproject")
  public String createSubproject(@ModelAttribute Subproject subproject, Project project, Model model) throws SubProjectErrorMessageException {
    subprojectServiceImpl.calsubhours(subproject);
    subprojectServiceImpl.calsubprice(subproject);
    model.addAttribute("subproject", subproject);
    project.setProjectId(currentProject.getProjectId());
    subprojectServiceImpl.createSubproject(project, subproject);
    return "redirect:/show-subprojects/" + currentProject.getProjectId();
  }


  //@Author: Jens
  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/update-subproject/{subprojectId}")
  public String updateSubproject(@PathVariable("subprojectId") int subprojectId, Model model) throws SubProjectErrorMessageException {
    System.out.println(subprojectId + "<- subprojectid i update subpro controller");
    Subproject subproject = subprojectServiceImpl.findSubprojectID(subprojectId);
    System.out.println("Efter service i UPDATE: id = " + subprojectId);
    model.addAttribute("subproject", subproject);
    return "update-subproject";
  }

  //Post
  //@Author: Jens
  @PostMapping("/new-update-subproject")
  public String updateSubproject(@ModelAttribute Subproject subproject) throws SubProjectErrorMessageException {
    System.out.println("Test af new-update-subproject");
    subprojectServiceImpl.calsubhours(subproject);
    subprojectServiceImpl.calsubprice(subproject);
    subprojectServiceImpl.updateSubproject(subproject);
    System.out.println("test 2 af new-update-subproject");
    return "redirect:/show-subprojects/" + currentProject.getProjectId();
  }

  //@Author: Kristian, Alexander
  @GetMapping("/delete-subproject/{subprojectId}")
  public String deleteSubproject(@PathVariable int subprojectId) throws SubProjectErrorMessageException {
    int projectId = subprojectServiceImpl.findSubprojectID(subprojectId).getProjectId();
    subprojectServiceImpl.deleteSubproject(subprojectId);
    return "redirect:/show-subprojects/" + currentProject.getProjectId();
  }

  //@Author: Silke
  @GetMapping("/subprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, @ModelAttribute Project project, Model model) throws SubProjectErrorMessageException {
    model.addAttribute("project", project);
    System.out.println("showsubprojects/id test i controller: + id = " + project);
    return "redirect:/show-subprojects/" + project.getProjectId();
  }


  //@Author: Silke (show) Alexander (calculate) og Jens (calculate)
  @GetMapping("/show-subprojects/{projectId}")
  public String showSubprojects2(@PathVariable("projectId") int projectId, Model model, HttpSession session) throws SubProjectErrorMessageException { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    List<Subproject> subprojects = subprojectServiceImpl.showAllSubprojects(projectId);
    model.addAttribute("subprojects", subprojects);
    currentProject.setProjectId(projectId);
    User user = (User) session.getAttribute("session"); //session er en KEY
    model.addAttribute("userId", user.getUserId());
    model.addAttribute("currentproject", currentProject);
    return "show-subprojects";
  }

  //@Author: Jens
  public String handleSubProjectError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessageExceptions/subproject-error-message-exception";
  }

}

