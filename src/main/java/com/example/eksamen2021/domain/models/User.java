package com.example.eksamen2021.domain.models;
//@Author: Silke, Kristian, Alexander, Jens
public class User {
  private int userId;
  private String userEmail;
  private String userPassword;
  private String userUsername;
  //Vi skal se vi kan nå det også
  private String passwordRepeat;



  public User(int userId, String userEmail, String userPassword, String userUsername) {
    this.userId = userId;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userUsername = userUsername;
  }

  public User(int userId, String userEmail, String userPassword) {
    this.userId = userId;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  public User(String userEmail, String userPassword, String userUsername) {
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userUsername = userUsername;
  }
  public User(){}

  public User(String string, String string1) {
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserUsername() {
    return userUsername;
  }

  public void setUserUsername(String userUsername) {
    this.userUsername = userUsername;
  }
}


/* MULIGHED FOR FREMTIDIG TILFØJELSE (index.html)

  public User(int user_id, String email, String password, String passwordRepeat) { //bruges ikke - slettes?
    this.user_id = user_id;
    this.email = email;
    this.password = password;
    this.passwordRepeat = passwordRepeat;
  }


  public String getPasswordRepeat() {
    return passwordRepeat;
  } //bruges ikke - slettes?

  public void setPasswordRepeat(String passwordRepeat) {
    this.passwordRepeat = passwordRepeat;
  }
 */
