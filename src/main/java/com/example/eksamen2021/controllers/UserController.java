package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.ErrorMessageException;
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
 public static User session; //OBS Den  vedr.figur1#

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
  public String loginUser(@ModelAttribute User user, Model model) throws ErrorMessageException { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
//OBS ny  ændert Jens kl.15:03 02-12-2021
    model.addAttribute("user", user);
    System.out.println("user WWaazzaaa" + user);
     session = userService.loginUser(user);
    return "redirect:/show/" + session.getUserId();
  }

  //OBS figur1#
  //før ændert Jens kl.15:03 02-12-2021
   /* model.addAttribute("user", user);
    System.out.println("user WWaazzaaa" + user);
    session = userService.loginUser(user);
    if (session == null) {
      return "login-page";
    }
    return "redirect:/show/" + session.getUserId();
    */
  //OBS figur1#


  @PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model) throws ErrorMessageException { //Jens' version af createUser
    model.addAttribute("user", user);
    userService.createUser(user);
    return "redirect:/login-page";
  }

  @ExceptionHandler(ErrorMessageException.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessagePage";
  }

}
