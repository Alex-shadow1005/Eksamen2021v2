package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

public interface UserController{
  @GetMapping("/")
  public String index() throws UserErrorMessageException;

  @GetMapping("/login-page")
  public String login() throws UserErrorMessageException;

  @GetMapping("/login")
  public String loginUser(@ModelAttribute User user, Model model, HttpSession session)throws UserErrorMessageException;

  @PostMapping("/new-user")
  public String createUser(@ModelAttribute User user, Model model) throws UserErrorMessageException;

  @ExceptionHandler(UserErrorMessageException.class)
  public String handleUserError(Model model, Exception exception);

}
