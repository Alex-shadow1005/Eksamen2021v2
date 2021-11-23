package com.example.eksamen2021.domain.models;

public class User {

  private String email;
  private String password;
  private String passwordRepeat;
  private int user_id;

  public User(int user_id, String email, String password) {
    this.user_id = user_id;
    this.email = email;
    this.password = password;
  }

  public User() {
  }

  public String getEmail() {
    return email.toLowerCase();
  }

  public void setEmail(String email) {
    this.email = email.toLowerCase();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
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
