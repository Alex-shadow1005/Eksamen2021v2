package com.example.eksamen2021.domain;

public class UserErrorMessageException extends Exception {
  //OBS UserErrorMessageException = ueme
  public UserErrorMessageException(String ueme) {
    super(ueme);
  }
}
