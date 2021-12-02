package com.example.eksamen2021.domain.services;


import com.example.eksamen2021.domain.UserExceptionMessage;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.UserRepositoryImpl;

public class UserService {

  UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
  //OBS ny  int# ændert Jens kl.15:03 02-12-2021 vedr.public #int# createUser(User user)
  //før String# ændert Jens kl.15:03 02-12-2021 vedr.public #String# createUser(User user)
  public int createUser(User user) throws UserExceptionMessage {  //DEN HER SKAL LAVES OM, SÅ endpoints kun ligger i Controllers
    return userRepositoryImpl.createUser(user);

   //før ændert Jens kl.15:03 02-12-2021
    /* int createUserSuccess = userRepositoryImpl.createUser(user);
    if (createUserSuccess == 1)
      return "redirect:/login";//end pont = yes
    else
      System.out.println("errr");

    return "redirect:/login";
     */
  }

    public User loginUser(User user)throws UserExceptionMessage { //modtager information (email, password) fra PostController /login -> PostRepository /validateUser
      return userRepositoryImpl.validateUser(user);
    }
}
