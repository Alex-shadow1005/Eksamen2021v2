package com.example.eksamen2021.domain;

//@Author: Jens
public class UserErrorMessageException extends Exception {
  //OBS UserErrorMessageException = ueme
  public UserErrorMessageException(String ueme) {
    super(ueme);
  }
}
