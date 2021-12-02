package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.CalculateService;
import com.example.eksamen2021.domain.services.SubprojectService;
import com.example.eksamen2021.repositories.SubprojectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SubprojectController {

  private SubprojectService subprojectService = new SubprojectService();
  private CalculateService calculatService = new CalculateService();


  //subproject id = 0, får den ikke rigtigt med? uden path
  //med path: viser ikke sout 
  @GetMapping("/add-subproject")
  public String addSubproject(@PathVariable("subprojectId") int subprojectId, @ModelAttribute Subproject subproject, Model model) {
    model.addAttribute("subprojectId", subprojectId);
    //subproject.getSubprojectId();
    System.out.println("subproject id in addsubpro. id = " + subprojectId);
    return "add-subproject";
  }

  @PostMapping("/add-subproject")
  public String addSubprojectPost(@ModelAttribute Subproject subproject, Project project, Model model) {
    model.addAttribute("subproject", subproject);
    subproject.getSubprojectId();
    subprojectService.addSubproject(project, subproject);
    return "redirect:/subprojects/" + project.getProjectId();
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
    model.addAttribute("subproject", subprojects);
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

  @PostMapping("/calculateSubprojectPrice/ {subprojectId}")
  public String calculateSubprojectPrice(@ModelAttribute Subproject subproject) throws SQLException {

    calculatService.calsubprice(
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectGraphicHours());
    return "show-projects";
  }

  @PostMapping("/calculateSubprojectHours/ {subprojectId}")
  public String calculateSubprojectHours(@ModelAttribute Subproject subproject) throws SQLException {

    calculatService.calsubhours(
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectDeveloperHours(),
        subproject.getSubprojectGraphicHours());
    return "show-projects";
  }
}




    /*
  @GetMapping("/showsubprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, Model model) throws SQLException {
    List<Subproject> subprojects = subprojectService.showAllSubprojects(id);
    model.addAttribute("subprojects", subprojects);
    return "show-projects";
  }
  */

    /*
  @GetMapping("/show-subprojects/{id}")
  public String showSubprojects(@PathVariable("projectid") int projectid, Model model) {
    List<Subproject> subprojects = projectService.showAllSubprojects(projectid);
    System.out.println("project id test here: " + projectid);
    model.addAttribute("subprojects", subprojects);
    return "show-subprojects";
  }
     */


  /*
@GetMapping("/show-subprojects/{id}")
public String showSubprojects(@PathVariable("projectid") int projectid, Model model) {
  List<Subproject> subprojects = projectService.showAllSubprojects(projectid);
  System.out.println("project id test here: " + projectid);
  model.addAttribute("subprojects", subprojects);
  return "show-subprojects";
}
   */


    /*
    //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject/{subproject_id}")
    public String updateSubproject(@PathVariable("subproject_id") int subprojectId, Model model) throws SQLException {
        Subproject subEdt = subprojectService.updateSubproject(subprojectId);
        model.addAttribute("subproject", subEdt);
        return "show-projects";
    }

 */
