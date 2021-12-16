package com.example.eksamen2021.domain.services;


import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

  UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();


  public User loginUser(User user)throws UserErrorMessageException { //modtager information (email, password) fra PostController /login -> PostRepository /validateUser
    return userRepositoryImpl.validateUser(user);
  }


  public User createUser(User user) throws UserErrorMessageException {
    return userRepositoryImpl.createUser(user);

  }

}
