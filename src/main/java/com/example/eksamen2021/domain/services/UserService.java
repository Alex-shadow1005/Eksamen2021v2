package com.example.eksamen2021.domain.services;

public class UserService {
  public String createUser(User user) {
    int createUserSuccess = userRepository.newUser(user);
    if (createUserSuccess == 1)
      return "redirect:/login";//end pont = yes
    else
      System.out.println("err");
    return "redirect:/login";
  }
}
