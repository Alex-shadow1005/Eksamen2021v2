package com.example.eksamen2021.domain.models;

public class ProjectList {

  private User user;
  private String wishlistName;

  public Wishlist(String wishlistName, User user) {
    this.wishlistName = wishlistName;
    this.user = user;
  }

  public Wishlist() {
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
