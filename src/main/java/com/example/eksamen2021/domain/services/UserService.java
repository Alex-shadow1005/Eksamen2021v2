package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.UserRepository;

public class UserService {

  private UserRepository userRepository = new UserRepository();

  public User loginUser(User user) { //modtager information (email, password) fra PostController /login -> PostRepository /validateUser
    return userRepository.validateUser(user);
  }
}
