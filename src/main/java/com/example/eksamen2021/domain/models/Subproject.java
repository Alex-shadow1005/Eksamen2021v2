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


  //KONSTRUKTØRER:

  //BRUGES I subproject HTML
  public Subproject(int subprojectId, int projectId, String subprojectName, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours, int subprojectPrice) {
    this.subprojectId = subprojectId;
    this.projectId = projectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
    this.subprojectPrice = subprojectPrice;
  }

  //BRUGES I addSubproject METODEN
  public Subproject(int subprojectId, String subprojectName, String subprojectDescription) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
  }

  public Subproject() {
  }

  /* TEST AF OM DEN BRUGES
  public Subproject(String subprojectName, String subprojectDescription, int subprojectPrice) {
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectPrice = subprojectPrice;
  }

   */

  /*
  //DENNE KONSTRUKTØR BRUGES I PROJECTREPO SHOWALLPROJECTS-METODEN
  public Subproject(int subprojectId, int projectId, String subprojectName, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours, int subprojectPrice) {
    this.subprojectId = subprojectId;
    this.projectId = projectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
    this.subprojectPrice = subprojectPrice;
  }
   */

  //GETTERS AND SETTERS

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

  public int getSubprojectSeniordeveloperHours() {
    return subprojectSeniordeveloperHours;
  }
  public int getSubprojectDeveloperHours() {
    return subprojectDeveloperHours;
  }
  public int getSubprojectGraphicHours() {
    return subprojectGraphicHours;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
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
}

