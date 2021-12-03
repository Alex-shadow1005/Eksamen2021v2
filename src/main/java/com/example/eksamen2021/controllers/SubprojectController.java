package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.CalculateService;
import com.example.eksamen2021.domain.services.SubprojectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SubprojectController {

  private SubprojectService subprojectService = new SubprojectService();
  private CalculateService calculatService = new CalculateService();
  public static Project currentProject = new Project();


  //subproject og project id = 0
  @GetMapping("/add-subproject")
  public String addSubproject(@ModelAttribute Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    model.addAttribute("currentproject", currentProject.getProjectId());
    //subproject.getSubprojectId();
    System.out.println("CONTROLLER: subproject id in addsubpro. id = " + subproject);
    return "add-subproject";
  }

  @PostMapping("/add-subproject")
  public String addSubprojectPost(@ModelAttribute Subproject subproject, Project project, Model model) {
    model.addAttribute("subproject", subproject);
    project.setProjectId(currentProject.getProjectId());
    //subproject.getSubprojectId();
    subprojectService.addSubproject(project, subproject);
    return "redirect:/show-subprojects/" + currentProject.getProjectId();
  }


  /* SILKE TEST
  @GetMapping("/add-subproject")
  public String addSubproject(@PathVariable("subprojectId") int subprojectId, @ModelAttribute Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    System.out.println("add subproject id = " + subprojectId);
    return "redirect:/add-subproject2/" + subproject.getSubprojectId();
  }

  @PostMapping("/add-subproject")
  public String addSubprojectPost(@PathVariable("subprojectId") int subprojectId, @ModelAttribute Subproject subproject, Project project, Model model) {
    model.addAttribute("subproject", subproject);
    System.out.println("POST add subpro id = " + subprojectId);
    subproject.getSubprojectId();
    subprojectService.addSubproject(project, subproject);
    return "redirect:/subprojects/" + project.getProjectId();
  }

   */


  //@Author: Silke
  @GetMapping("/subprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, @ModelAttribute Project project, Model model) {
    model.addAttribute("project", project);
    System.out.println("showsubprojects/id test i controller: + id = " + project);
    return "redirect:/show-subprojects/" + project.getProjectId();
  }

  //@Author: Silke
  @GetMapping("/show-subprojects/{projectId}")
  public String showSubprojects2(@PathVariable("projectId") int projectId, Model model) { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    List<Subproject> subprojects = subprojectService.showAllSubprojects(projectId);
    for (Subproject sp:subprojects) {
     sp.setSubprojectPrice((int) calculatService.calsubprice(sp.getSubprojectSeniordeveloperHours(),sp.getSubprojectDeveloperHours(), sp.getSubprojectGraphicHours()));
    }
    for (Subproject sp:subprojects) {
      sp.setSubprojectTotalHours((int)calculatService.calsubhours(sp.getSubprojectSeniordeveloperHours(),sp.getSubprojectDeveloperHours(),sp.getSubprojectGraphicHours()));
    }
    model.addAttribute("subprojects", subprojects);
    currentProject.setProjectId(projectId);
    model.addAttribute("currentproject",currentProject);
    System.out.println("show subproject test i controller" + subprojects + " " + projectId);
    return "show-subprojects";

  }
/* SILKE TEST
  @PostMapping("/add-subproject/{projectid}")
  public String addSubprojectPost(@PathVariable("projectid") int projectid, @ModelAttribute Project project, Subproject subproject, Model model) {
    model.addAttribute("subproject", subproject);
    project.setProjectId(projectid); //kan kalde vores id her i stedet, skal laves i Thymeleaf
    subprojectService.addSubproject(project, subproject);
    return "redirect:/show/" + projectid;
  }

 */

  @GetMapping("/delete-subproject/{subprojectId}")
  public String deleteSubproject(@PathVariable int subprojectId) throws SQLException {
    subprojectService.deleteSubproject(subprojectId);

    return "show-projects";
  }

  //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
  @GetMapping("/update-subproject/{subprojectId}")
  public String updateSubproject(@PathVariable("subprojectId") int subprojectId, Model model) throws SQLException {
    Subproject subproject = subprojectService.findSubprojectID(subprojectId);
    model.addAttribute("subproject", subproject);
    return "update";
  }

  //Post
  @PostMapping("/new-update-subproject")
  public String updateSubproject(@ModelAttribute Subproject subproject) throws SQLException {
    subprojectService.updateSubproject(subproject);
    return "redirect:/show-subprojects";
  }

  @PostMapping("/calculateSubprojectPrice/{subprojectId}")
  public String calculateSubprojectPrice(@ModelAttribute Subproject subproject) throws SQLException {

/*    calculatService.calsubprice(
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectGraphicHours());

 */
    return "show-projects";
  }
}



//UDKOMMENTEREDE METODER

  /*
  @PostMapping("/calculateSubprojectHours/ {subprojectId}")
  public String calculateSubprojectHours(@ModelAttribute Subproject subproject) throws SQLException {

    calculatService.calsubhours(
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectGraphicHours());
    return "show-projects";
  }

   */