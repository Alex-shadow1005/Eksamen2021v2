package com.example.eksamen2021.domain.models;

public class Subproject {


  private int subprojectId;
  private int projectId;
  private String subprojectName;
  private String subprojectDescription;
  private int subprojectSeniordeveloperHours;
  private int subprojectDeveloperHours;
  private int subprojectGraphicHours;
  private int subprojectPrice;

  public int getSubprojectSeniordeveloperHours() {
    return subprojectSeniordeveloperHours;
  }

  public int getSubprojectDeveloperHours() {
    return subprojectDeveloperHours;
  }

  public int getSubprojectGraphicHours() {
    return subprojectGraphicHours;
  }

  /*
  private User user;
  private String projectlistName;
  */


  public Subproject(int subprojectId, String subprojectName, String subprojectDescription, int subprojectPrice) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectPrice = subprojectPrice;
  }

  public Subproject(int subprojectId, String subprojectName, String subprojectDescription) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
  }

  public Subproject() {
  }

  public Subproject(String subprojectName, String subprojectDescription, int subprojectPrice) {
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectPrice = subprojectPrice;
  }

  public int getSubprojectId() {
    return subprojectId;
  }

  public void setSubprojectId(int subprojectId) {
    this.subprojectId = subprojectId;
  }

  public String getSubprojectName() {
    return subprojectName;
  }

  public void setSubprojectName(String subprojectName) {
    this.subprojectName = subprojectName;
  }

  public String getSubprojectDescription() {
    return subprojectDescription;
  }

  public void setSubprojectDescription(String subprojectDescription) {
    this.subprojectDescription = subprojectDescription;
  }

  public int getSubprojectPrice() {
    return subprojectPrice;
  }

  public void setSubprojectPrice(int subprojectPrice) {
    this.subprojectPrice = subprojectPrice;
  }

}
