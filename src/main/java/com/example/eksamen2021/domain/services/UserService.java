package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;

public interface UserService {
  public User loginUser(User user) throws UserErrorMessageException;

  public User createUser(User user) throws UserErrorMessageException;
}
