package com.example.eksamen2021.domain.models;

public class Project {
  private int projectId;
  private String projectName;
  private String projectDescription;
  private int projectPrice;
  private int projectHours;


  public Project(int projectId, String projectName, String projectDescription, int projectPrice) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectPrice = projectPrice;
  }

  public Project(String projectName, String projectDescription, int projectPrice) {
    this.projectName = projectName;
    this.projectDescription = projectDescription;
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


  @Override
  public String toString() {
    return "Project: " +
        "project id = " + projectId +
        ", project name = " + projectName +
        ", project description = " + projectDescription +
        ", project price = " + projectPrice;
  }

}
