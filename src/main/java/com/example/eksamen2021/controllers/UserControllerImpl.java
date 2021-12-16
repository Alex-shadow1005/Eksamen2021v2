package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.domain.services.UserService;
import com.example.eksamen2021.domain.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserControllerImpl implements UserController {


  private UserServiceImpl userServiceImpl = new UserServiceImpl();

  //@Author: Jens, Kristian, Silke, Alexander
  @GetMapping("/")
  public String index() throws UserErrorMessageException {
    return "index";
  }

  //@Author: Jens, Kristian, Silke, Alexander
  @GetMapping("/login-page") //starter login-process her -> login-page.html
  public String login() throws UserErrorMessageException {
    return "login-page";
  }

  //@Author: Jens, Kristian, Silke, Alexander
  @GetMapping("/login")
  public String loginUser(@ModelAttribute User user, Model model, HttpSession session) throws UserErrorMessageException { //ModelAttribute gemmer parametre i User ved at lave det til et objekt
    //OBS ny  ændert Jens kl.15:03 02-12-2021
    model.addAttribute("user", user);
    session.setAttribute("session", userServiceImpl.loginUser(user));
    User usersession = (User) session.getAttribute("session");
    return "redirect:/show/" + usersession.getUserId();
  }


  //@Author: Jens, Kristian, Silke
  @PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model) throws UserErrorMessageException { //Jens' version af createUser
    model.addAttribute("user", user);
    userServiceImpl.createUser(user);
    return "redirect:/login-page";
  }

  //@Author: Jens
  @Override
  public String handleUserError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "errorMessageExceptions/user-error-message-exception";
  }

}


