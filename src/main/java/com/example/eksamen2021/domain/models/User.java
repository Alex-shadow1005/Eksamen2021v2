package com.example.eksamen2021.domain.models;

public class User {
  private int user_id;
  private String user_email;
  private String user_password;
  private String user_username;
  //Vi skal se vi kan nå det også
  private String passwordRepeat;


  public User(int user_id, String user_email, String user_password, String user_username) {
    this.user_id = user_id;
    this.user_email = user_email;
    this.user_password = user_password;
    this.user_username = user_username;
  }

  public User(int user_id, String user_email, String user_password) {
    this.user_id = user_id;
    this.user_email = user_email;
    this.user_password = user_password;
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

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getUser_email() {
    return user_email;
  }

  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }

  public String getUser_password() {
    return user_password;
  }

  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }

  public String getUser_username() {
    return user_username;
  }

  public void setUser_username(String user_username) {
    this.user_username = user_username;
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
