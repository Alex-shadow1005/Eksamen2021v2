package com.example.eksamen2021.domain.services;


import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.UserRepositoryImpl;
//@Author: Silke, Kristian, Alexander, Jens
public class UserServiceImpl implements UserService {

  UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

  //@Author: Silke, Kristian, Alexander, Jens
  public User loginUser(User user)throws UserErrorMessageException { //modtager information (email, password) fra PostController /login -> PostRepository /validateUser
    return userRepositoryImpl.validateUser(user);
  }

  //@Author: Silke, Kristian, Alexander, Jens
  public User createUser(User user) throws UserErrorMessageException {
    return userRepositoryImpl.createUser(user);

  }

}
