package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;

public interface UserRepository {
  public User createUser(User user) throws UserErrorMessageException;

  public User validateUser(User user) throws UserErrorMessageException;
}
