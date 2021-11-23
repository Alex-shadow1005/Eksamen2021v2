package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private UserService userService = new UserService();
  public static User session;

  //OBS! Ænder createUser til createUser newUser23-11-2021 kl.10:26

  @PostMapping("/newUser")
  public String newUser(@ModelAttribute User user, Model model) { //Jens' version af createUser
    model.addAttribute("user", user);
    userService.createUser(user);
    return "redirect:/loginpage";
  }

}
