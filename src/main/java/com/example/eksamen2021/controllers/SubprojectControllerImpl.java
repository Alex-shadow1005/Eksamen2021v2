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

  //subproject og project id = 0

  @GetMapping("/create-subproject")
  public String addSubproject(@ModelAttribute Subproject subproject, Model model) throws SubProjectErrorMessageException {
    model.addAttribute("subproject", subproject);
    model.addAttribute("currentproject", currentProject.getProjectId());
    System.out.println("CONTROLLER: subproject id in addsubpro. id = " + subproject);
    return "create-subproject";
  }

  @PostMapping("/create-subproject")
  public String createSubproject(@ModelAttribute Subproject subproject, Project project, Model model) throws SubProjectErrorMessageException {
    //subproject.setSubprojectTotalHours((int)calculatService.calsubhours(subproject.getSubprojectSeniordeveloperHours(),subproject.getSubprojectDeveloperHours(),subproject.getSubprojectGraphicHours()));
    subprojectServiceImpl.calsubhours(subproject);
    subprojectServiceImpl.calsubprice(subproject);
    // subproject.setSubprojectPrice((int) calculatService.calsubprice(subproject.getSubprojectSeniordeveloperHours(),subproject.getSubprojectDeveloperHours(),subproject.getSubprojectGraphicHours()));
    model.addAttribute("subproject", subproject);
    project.setProjectId(currentProject.getProjectId());
    //subproject.getSubprojectId();
    subprojectServiceImpl.createSubproject(project, subproject);
    return "redirect:/show-subprojects/" + currentProject.getProjectId();
  }


  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/update-subproject/{subprojectId}")
  public String updateSubproject(@PathVariable("subprojectId") int subprojectId, Model model) throws SubProjectErrorMessageException {
    //subprojectId = currentSubproject.getSubprojectId();
    //System.out.println("UPDATE: subprojekt id = " + subprojectId + " getter: " + currentSubproject.getSubprojectId());
    System.out.println(subprojectId + "<- subprojectid i update subpro controller");
    Subproject subproject = subprojectServiceImpl.findSubprojectID(subprojectId);
    System.out.println("Efter service i UPDATE: id = " + subprojectId);
    model.addAttribute("subproject", subproject);
    return "update";
  }

  //Post
  @PostMapping("/new-update-subproject")
  public String updateSubproject(@ModelAttribute Subproject subproject) throws SubProjectErrorMessageException {
    System.out.println("Test af new-update-subproject");
    subprojectServiceImpl.updateSubproject(subproject);
    System.out.println("test 2 af new-update-subproject");
    return "redirect:/show-subprojects/" + subproject.getProjectId(); //returnerer 0 i projektid :c
  }

  @GetMapping("/delete-subproject/{subprojectId}")
  public String deleteSubproject(@PathVariable int subprojectId) throws SubProjectErrorMessageException {
    subprojectServiceImpl.deleteSubproject(subprojectId);
    return "show-subprojects";
  }

  //@Author: Silke
  @GetMapping("/subprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, @ModelAttribute Project project, Model model) throws SubProjectErrorMessageException {
    model.addAttribute("project", project);
    System.out.println("showsubprojects/id test i controller: + id = " + project);
    return "redirect:/show-subprojects/" + project.getProjectId();
  }


  //@Author: Silke (show) & Alexander (calculate)
  @GetMapping("/show-subprojects/{projectId}")
  public String showSubprojects2(@PathVariable("projectId") int projectId, Model model, HttpSession session) throws SubProjectErrorMessageException { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    List<Subproject> subprojects = subprojectServiceImpl.showAllSubprojects(projectId);
    model.addAttribute("subprojects", subprojects);
    currentProject.setProjectId(projectId);

    User user = (User) session.getAttribute("session"); //session er en KEY
    model.addAttribute("userId", user.getUserId());
    model.addAttribute("currentproject", currentProject);

    System.out.println("test af currentproject.getuserid. userid = " + currentProject.getUserId()); // = 0
    System.out.println("show subproject test i controller" + subprojects + " " + projectId);
    return "show-subprojects";

  }

  @Override
  public String handleSubProjectError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessageExceptions/subproject-error-message-exception";
  }



  /* SILKE TEST
  @GetMapping("/add-subproject")
  public String addSubproject(@PathVariable("subprojectId") int subprojectId, @ModelAttribute Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    System.out.println("add subproject id = " + subprojectId);
    return "redirect:/add-subproject2/" + subproject.getSubprojectId();
  }

  //Post
  @PostMapping("/new-update-subproject")
  public String updateSubproject(@ModelAttribute Subproject subproject) throws SQLException {
    subprojectService.updateSubproject(subproject);
    return "redirect:/show-subprojects/" + currentProject.getProjectId();


  @PostMapping("/add-subproject")
  public String addSubprojectPost(@PathVariable("subprojectId") int subprojectId, @ModelAttribute Subproject subproject, Project project, Model model) {
    model.addAttribute("subproject", subproject);
    System.out.println("POST add subpro id = " + subprojectId);
    subproject.getSubprojectId();
    subprojectService.addSubproject(project, subproject);
    return "redirect:/subprojects/" + project.getProjectId();
  }

   */
}

