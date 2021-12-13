package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserControllerImpl implements UserController {

  private UserService userService = new UserService();

  @GetMapping("/")
  public String index() throws UserErrorMessageException {
    return "index";
  }

  @GetMapping("/login-page") //starter login-process her -> login-page.html
  public String login() throws UserErrorMessageException {
    return "login-page";
  }


  @GetMapping("/login")
  public String loginUser(@ModelAttribute User user, Model model, HttpSession session) throws UserErrorMessageException { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
//OBS ny  ændert Jens kl.15:03 02-12-2021
    model.addAttribute("user", user);
    session.setAttribute("session",userService.loginUser(user));
    User usersession = (User) session.getAttribute("session");
    return "redirect:/show/" + usersession.getUserId();
  }

  @PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model) throws UserErrorMessageException { //Jens' version af createUser
    model.addAttribute("user", user);
     userService.createUser(user);
    //if(user1.equals(user)){
      return "redirect:/login-page";
//    }else {

//    throw new ErrorMessageException("UserEmail & UserPassword is Not validate login OBS  vedr. metode = public User validateUser(User user) ");
  }

  @Override
  public String handleUserError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessageExceptions/user-error-message-exception";
  }

}


  /*@PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model) throws ErrorMessageException { //Jens' version af createUser
    model.addAttribute("user", user);
    int createUserSuccess = userService.createUser(user);
    if(createUserSuccess == 1) {
      System.out.println("User added");
      return "redirect:/login-page";
    }else {
      throw new ErrorMessageException("Fejl i count createUser  err=");
    }

  }

   */


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


