package com.example.eksamen2021.domain.models;

public class Project {
  private int project_id;
  private String project_name;
  private String project_description;
  private int project_cost;


  public Project(int project_id, String project_name, String project_description, int project_cost) {
    this.project_id = project_id;
    this.project_name = project_name;
    this.project_description = project_description;
    this.project_cost = project_cost;
  }

  public Project(String project_name, String project_description, int project_cost) {
    this.project_name = project_name;
    this.project_description = project_description;
    this.project_cost = project_cost;
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

  public int getProject_cost() {
    return project_cost;
  }

  public void setProject_cost(int project_cost) {
    this.project_cost = project_cost;
  }

  @Override
  public String toString() {
    return "Project: " +
        "project id = " + project_id +
        ", project name = " + project_name +
        ", project description = " + project_description +
        ", project price = " + project_cost;
  }

}
