package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @PostMapping("/createUser")
  public String createUser(@ModelAttribute User user, Model model) { //Jens' version af createUser
    model.addAttribute("user", user);
    //userService.createUser(user);
    return "redirect:/loginpage";
  }

}
