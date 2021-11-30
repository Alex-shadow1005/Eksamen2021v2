package com.example.eksamen2021.domain.models;

public class Project {
  private int userId;
  private int projectId;
  private String projectName;
  private String projectDescription;
  private int projectHours;
  private int projectPrice;


  public Project(String projectName, String projectDescription, int projectHours, int projectPrice) {
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectHours = projectHours;
    this.projectPrice = projectPrice;
  }

  //DENNE KONSTRUKTØR BRUGES I SHOW-PROJECTS.HTML
  public Project(int projectId, String projectName, String projectDescription, int projectHours, int projectPrice) {
    //this.userId = userId;
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectHours = projectHours;
    this.projectPrice = projectPrice;
  }

  public Project() {
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public int getProjectPrice() {
    return projectPrice;
  }

  public void setProjectPrice(int projectPrice) {
    this.projectPrice = projectPrice;
  }

  public int getProjectHours() {
    return projectHours;
  }

  public void setProjectHours(int projectHours) {
    this.projectHours = projectHours;
  }

  @Override
  public String toString() {
    return "Project: " +
        "project id = " + projectId +
        ", project name = " + projectName +
        ", project description = " + projectDescription +
        ", project price = " + projectPrice;
  }

}
