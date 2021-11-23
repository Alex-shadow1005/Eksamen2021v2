package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.UserRepository;

public class UserService {

  UserRepository userRepository = new UserRepository();

  public String createUser(User user) {
    int createUserSuccess = userRepository.createUser(user);
    if (createUserSuccess == 1)
      return "redirect:/login";//end pont = yes
    else
      System.out.println("errr");
    return "redirect:/login";
  }

    public User loginUser(User user){ //modtager information (email, password) fra PostController /login -> PostRepository /validateUser
      return userRepository.validateUser(user);
    }
}
