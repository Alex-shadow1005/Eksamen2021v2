package com.example.eksamen2021.domain.models;

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
// Lave den til test
  public User(String user_email, String user_password, String user_username) {
    this.user_email = user_email;
    this.user_password = user_password;
    this.user_username = user_username;
  }

  public User(String user_email, String user_password) {
    this.user_email = user_email;
    this.user_password = user_password;
  }

  public User() {
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
