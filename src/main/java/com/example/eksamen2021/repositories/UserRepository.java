package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.UserExceptionMessage;
import com.example.eksamen2021.domain.models.User;

public interface UserRepository {
  public int createUser(User user) throws UserExceptionMessage;
  public User validateUser(User user) throws UserExceptionMessage;
}
