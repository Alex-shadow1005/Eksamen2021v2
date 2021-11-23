package com.example.eksamen2021.domain.models;

public class SubProject {

  private User user;
  private String wishlistName;

  public SubProject(String wishlistName, User user) {
    this.wishlistName = wishlistName;
    this.user = user;
  }

  public SubProject() {
  }

  public String getWishlistName() {
    return wishlistName.toLowerCase();
  }

  public void setWishlistName(String wishlistName) {
    this.wishlistName = wishlistName.toLowerCase();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
