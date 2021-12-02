package com.example.eksamen2021.domain;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionMessage extends Throwable {
  // info. uem = UserExceptionMessage
  public UserExceptionMessage(String uem) {
    super(uem);
  }
 /* @ExceptionHandler(UserExceptionMessage.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message",exception.getMessage());
    return "errorMessagePage";
  }

  */
}
