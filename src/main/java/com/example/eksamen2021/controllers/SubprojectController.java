package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

public interface SubprojectController {
  @GetMapping("/create-subproject")
  public String addSubproject(@ModelAttribute Subproject subproject, Model model) throws SubProjectErrorMessageException;

  @PostMapping("/create-subproject")
  public String createSubproject(@ModelAttribute Subproject subproject, Project project, Model model) throws SubProjectErrorMessageException;

  @GetMapping("/update-subproject/{subprojectId}")
  public String updateSubproject(@PathVariable("subprojectId") int subprojectId, Model model) throws SubProjectErrorMessageException;

  @PostMapping("/new-update-subproject")
  public String updateSubproject(@ModelAttribute Subproject subproject) throws SubProjectErrorMessageException;

  @GetMapping("/delete-subproject/{subprojectId}")
  public String deleteSubproject(@PathVariable int subprojectId) throws SubProjectErrorMessageException;
//OBS SKla den ikke være PostMapping
  @GetMapping("/subprojects/{id}")
  public String showSubprojects(@PathVariable("id") int id, @ModelAttribute Project project, Model model) throws SubProjectErrorMessageException;

  @GetMapping("/show-subprojects/{projectId}")
  public String showSubprojects2(@PathVariable("projectId") int projectId, Model model, HttpSession session) throws SubProjectErrorMessageException;

  @ExceptionHandler(SubProjectErrorMessageException.class)
  public String handleSubProjectError(Model model, Exception exception);
}
