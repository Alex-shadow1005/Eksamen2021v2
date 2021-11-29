package com.example.eksamen2021.domain.models;

public class Project {
  private int project_id;
  private String project_name;
  private String project_description;
  private int project_price;
  private int project_hours;


  public Project(int project_id, String project_name, String project_description, int project_price) {
    this.project_id = project_id;
    this.project_name = project_name;
    this.project_description = project_description;
    this.project_price = project_price;
  }

  public Project(String project_name, String project_description, int project_price) {
    this.project_name = project_name;
    this.project_description = project_description;
    this.project_price = project_price;
    this.project_hours = project_hours;
  }

  public Project() {
  }

  public int getProject_id() {
    return project_id;
  }

  public void setProject_id(int project_id) {
    this.project_id = project_id;
  }

  public String getProject_name() {
    return project_name;
  }

  public void setProject_name(String project_name) {
    this.project_name = project_name;
  }

  public String getProject_description() {
    return project_description;
  }

  public void setProject_description(String project_description) {
    this.project_description = project_description;
  }

  public int getProject_price() {
    return project_price;
  }

  public void setProject_price(int project_price) {
    this.project_price = project_price;
  }

  public int getProject_hours() {
    return project_hours;
  }

  public void setProject_hours(int project_hours) {
    this.project_hours = project_hours;
  }

  @Override
  public String toString() {
    return "Project: " +
        "project id = " + project_id +
        ", project name = " + project_name +
        ", project description = " + project_description +
        ", project price = " + project_price;
  }

}
