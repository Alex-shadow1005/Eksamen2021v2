package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.services.SubprojectService;
import com.example.eksamen2021.repositories.SubprojectRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

public class SubprojectController {

    private SubprojectService subprojectService = new SubprojectService();
/*
    //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject/{subproject_id}")
    public String updateSubproject(@PathVariable("subproject_id") int subprojectId, Model model) throws SQLException {
        Subproject subEdt = subprojectService.updateSubproject(subprojectId);
        model.addAttribute("subproject", subEdt);
        return "show-projects";
    }

 */

    @GetMapping("/add-subproject")
    public String addSubproject(@ModelAttribute Subproject subproject, Model model) {
        model.addAttribute("subproject", subproject);
        model.addAttribute("sessionID", UserController.session.getUserId());
        //System.out.println(project.getProject_name() + project.getProject_description() + project.getProject_price());
        //We will return to this one ^
        return "add-subproject";
    }

    @GetMapping("/subprojects/")
    public String showSubprojects(@ModelAttribute Project project, Model model) {
        model.addAttribute("project", project);
        System.out.println("showsubprojects/id test i controller: + id = " + project);
        return "redirect:/show-subprojects/" + project.getProjectId();
    }


    @GetMapping("/show-subprojects/{id}")
    public String showSubprojects2(@PathVariable("id") int id, Model model) { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
        List<Subproject> subprojects = subprojectService.showAllSubprojects(id);
        model.addAttribute("subproject", subprojects);
        System.out.println("show subproject test i controller" + subprojects + " " + id);
        return "show-subprojects";
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

    @PostMapping("/add-subproject/{projectid}")
    public String addSubprojectPost(@PathVariable("projectid") int projectid, @ModelAttribute Project project, Subproject subproject, Model model) {
        model.addAttribute("subproject", subproject);
        project.setProjectId(projectid); //kan kalde vores id her i stedet, skal laves i Thymeleaf
        subprojectService.addSubproject(project, subproject);
        return "redirect:/show/" + projectid;
    }

    @GetMapping ("/delete-subproject/{subprojectId}")
    public String deleteSubproject(@PathVariable int subprojectId) throws SQLException {
        subprojectService.deleteSubproject(subprojectId);

        return "show-projects";
    }
}
