package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

public interface ProjectController {
  @GetMapping("/create-project")
  public String addProject(@ModelAttribute Project project, Model model, HttpSession session) throws ProjectErrorMessageException;

  @PostMapping("/create-project")
  public String createProject(@ModelAttribute Project project, User user, Model model, HttpSession session) throws ProjectErrorMessageException;

  @GetMapping("/update-project/{projectId}")
  public String updateproject(@PathVariable("projectId") int projectId, Model model) throws ProjectErrorMessageException;

  @PostMapping("/new-update-project")
  public String updateProject(@ModelAttribute Project project) throws ProjectErrorMessageException;

  @GetMapping("/delete-project/{projectId}/{userId}")
  public String deleteProject(@PathVariable int projectId, User user, HttpSession session) throws ProjectErrorMessageException;

  @GetMapping("/show/{id}")
  public String showProjects(@PathVariable("id") int id, Model model, User user) throws ProjectErrorMessageException, SubProjectErrorMessageException;

  @ExceptionHandler(ProjectErrorMessageException.class)
  public String handleProjectError(Model model, Exception exception);

}
