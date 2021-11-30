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
  private int subprojectTotalHours;

  /*
  private User user;
  private String projectlistName;
  */



  public Subproject(int subprojectId, String subprojectName, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours, int subprojectPrice, int subprojectTotalHours) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
    this.subprojectPrice = subprojectPrice;
    this.subprojectTotalHours = subprojectTotalHours;
  }
  //DENNE KONSTRUKTØR BRUGES I PROJECTREPO SHOWALLPROJECTS-METODEN
  public Subproject(String subproject_name, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours, int subprojectPrice) {
    this.subprojectName = subproject_name;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
    this.subprojectPrice = subprojectPrice;
  }

  public int getSubprojectSeniordeveloperHours() {
    return subprojectSeniordeveloperHours;
  }
  public int getSubprojectDeveloperHours() {
    return subprojectDeveloperHours;
  }
  public int getSubprojectGraphicHours() {
    return subprojectGraphicHours;
  }


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

  public Subproject(String subprojectName, String subprojectDescription, int subprojectPrice) {
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectPrice = subprojectPrice;
  }
  public Subproject() {
  }

  public int getSubprojectId() {
    return subprojectId;
  }

  public void setSubprojectId(int subprojectId) {
    this.subprojectId = subprojectId;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
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

  public void setSubprojectSeniordeveloperHours(int subprojectSeniordeveloperHours) {
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
  }

  public void setSubprojectDeveloperHours(int subprojectDeveloperHours) {
    this.subprojectDeveloperHours = subprojectDeveloperHours;
  }

  public void setSubprojectGraphicHours(int subprojectGraphicHours) {
    this.subprojectGraphicHours = subprojectGraphicHours;
  }

  public int getSubprojectPrice() {
    return subprojectPrice;
  }

  public void setSubprojectPrice(int subprojectPrice) {
    this.subprojectPrice = subprojectPrice;
  }
  public int getSubprojectTotalHours() {return subprojectTotalHours;}

  public void setSubprojectTotalHours(int subprojectTotalHours) {this.subprojectTotalHours = subprojectTotalHours;}

}


