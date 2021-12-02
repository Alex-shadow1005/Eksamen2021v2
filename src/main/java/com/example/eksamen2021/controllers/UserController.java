package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.UserExceptionMessage;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private UserService userService = new UserService();
  public static User session;

 // Denne metode tager oplysninger, som brugeren har indtastet om en ny kunde.
 // Objektet bruges til at gemme oplysninger om kunden i databasen.
  //OBS! Ænder createUser til newUser newUser23-11-2021 kl.10:26
 @GetMapping("/")
 public String index() {
   return "index";
 }

  @GetMapping("/login-page") //starter login-process her -> login-page.html
  public String login() {
    return "login-page";
  }


  @GetMapping("/login")
  public String loginUser(@ModelAttribute User user, Model model) throws UserExceptionMessage { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    model.addAttribute("user", user);
    System.out.println("user WWaazzaaa" + user);
    session = userService.loginUser(user);
    if (session == null) {
      return "login-page";
    }
    return "redirect:/show/" + session.getUserId();
  }

  @PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model)throws UserExceptionMessage { //Jens' version af createUser
    model.addAttribute("user", user);
    userService.createUser(user);
    return "redirect:/login-page";
  }

  @ExceptionHandler(UserExceptionMessage.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message",exception.getMessage());
    return "errorMessagePage";
  }
}
