package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

public class h {

/*
  @GetMapping("/create-project")
  public String addProject(@ModelAttribute Project project, Model model, HttpSession session) throws ErrorMessageException {
    model.addAttribute("project", project);
    User usersession = (User) session.getAttribute("session");//jens
    model.addAttribute("sessionID", usersession.getUserId());

    System.out.println(project.getProjectName() + project.getProjectDescription() + project.getProjectPrice());
    return "create-project";
  }

  @PostMapping("/create-project")
  public String createProject(@ModelAttribute Project project, User user, Model model,HttpSession session) throws ErrorMessageException {
    model.addAttribute("project", project);
    User usersession = (User) session.getAttribute("session");//jens
    user.setUserId(usersession.getUserId());
    projectService.createProject(project, user);
    return "redirect:/show/" + usersession.getUserId();
  }


 */



}
