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

    //sender projct id til projectservice (@Path tager id,et fra urlen og gemmer det??)
    @GetMapping("/update-subproject/{subproject_id}")
    public String updateSubproject(@PathVariable("subproject_id") int subprojectId, Model model) throws SQLException {
        Subproject subEdt = subprojectService.updateSubproject(subprojectId);
        model.addAttribute("subproject", subEdt);
        return "show-projects";
    }


    @GetMapping("/add-subproject")
    public String addSubproject(@ModelAttribute Subproject subproject, Model model) {
        model.addAttribute("subproject", subproject);
        model.addAttribute("sessionID", UserController.session.getUserId());
        //System.out.println(project.getProject_name() + project.getProject_description() + project.getProject_price());
        //We will return to this one ^
        return "add-subproject";
    }

    @GetMapping("/showsubprojects/{id}")
    public String showSubprojects(@PathVariable("id") int id, Model model) {
        List<Subproject> subprojects = subprojectService.showAllSubprojects(id);
        model.addAttribute("subprojects", subprojects);
        return "show-projects";
    }

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
