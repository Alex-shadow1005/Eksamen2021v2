package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private UserService userService = new UserService();
  public static User session;

  //OBS! Ænder createUser til newUser newUser23-11-2021 kl.10:26
  @PostMapping("/newUser")
  public String createUser(@ModelAttribute User user, Model model) { //Jens' version af createUser
    model.addAttribute("user", user);
    userService.createUser(user);
    return "redirect:/loginpage";
  }

  @GetMapping("/loginpage") //starter login-process her -> loginpage.html
  public String login() {
    return "loginpage";
  }

  @GetMapping("/login")
  public String loginUser(@ModelAttribute User user, Model model) { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    model.addAttribute("user", user);
    System.out.println("user WWaazzaaa" + user);
    session = userService.loginUser(user);
    if (session == null) {
      return "loginpage";
    }
    return "redirect:/show/" + session.getUser_id();
  }

}
