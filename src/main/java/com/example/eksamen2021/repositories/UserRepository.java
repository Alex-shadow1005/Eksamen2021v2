package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.User;

public interface UserRepository {
  public User createUser(User user) throws ErrorMessageException;

  public User validateUser(User user) throws ErrorMessageException;
}
