package com.example.eksamen2021.domain.models;

public class Project {
  private int wishID;
  private String wishName;
  private String wishDescription;
  private int wishPrice;


  public Project(int wishID, String wishName, String wishDescription, int wishPrice) {
    this.wishID = wishID;
    this.wishName = wishName;
    this.wishDescription = wishDescription;
    this.wishPrice = wishPrice;
  }

  public Project(String wishName, String wishDescription, int wishPrice) {
    this.wishName = wishName;
    this.wishDescription = wishDescription;
    this.wishPrice = wishPrice;
  }

  public Project() {
  }


  public Project(int user_id, int wish_id, int wishlist_id, String wishName, String wishDescription, int wishPrice) {
  }


  public int getWishID() {
    return wishID;
  }

  public void setWishID(int wishID) {
    this.wishID = wishID;
  }

  public String getWishName() {
    return wishName;
  }

  public void setWishName(String wishName) {
    this.wishName = wishName;
  }

  public String getWishDescription() {
    return wishDescription;
  }

  public void setWishDescription(String wishDescription) {
    this.wishDescription = wishDescription;
  }

  public int getWishPrice() {
    return wishPrice;
  }

  public void setWishPrice(int wishPrice) {
    this.wishPrice = wishPrice;
  }

  @Override
  public String toString() {
    return "Wish: " +
        "wishID = " + wishID +
        ", wishName = " + wishName +
        ", wishDescription = " + wishDescription +
        ", wishPrice=" + wishPrice;
  }

}
