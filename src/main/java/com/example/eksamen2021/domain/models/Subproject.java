package com.example.eksamen2021.domain.models;

import com.example.eksamen2021.domain.services.CalculateService;

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


  //KONSTRUKTØRER:



  //bruges i addsubprojekt - d.2/12 kl 13 Silke
  public Subproject(int subprojectId, String subprojectName, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
  }

//find  subID
  public Subproject(int subprojectId, String subprojectName, String subprojectDescription, int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours, int subprojectPrice) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;
    this.subprojectPrice = subprojectPrice;
  }

//show all subproject

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


  //test den her om den bruges??????????
  public Subproject(int subprojectId, String subprojectName, String subprojectDescription, int subprojectPrice) {
    this.subprojectId = subprojectId;
    this.projectId = projectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
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


  //GETTERS AND SETTERS


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

  public int getSubprojectSeniordeveloperHours() {
    return subprojectSeniordeveloperHours;
  }

  public void setSubprojectSeniordeveloperHours(int subprojectSeniordeveloperHours) {
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
  }

  public int getSubprojectDeveloperHours() {
    return subprojectDeveloperHours;
  }

  public void setSubprojectDeveloperHours(int subprojectDeveloperHours) {
    this.subprojectDeveloperHours = subprojectDeveloperHours;
  }

  public int getSubprojectGraphicHours() {
    return subprojectGraphicHours;
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

  public int getSubprojectTotalHours() {
    return subprojectTotalHours;
  }

  public void setSubprojectTotalHours(int subprojectTotalHours) {
    this.subprojectTotalHours = subprojectTotalHours;
  }

  @Override
  public String toString() {
    return "Subproject{" +
        "subprojectId=" + subprojectId +
        ", projectId=" + projectId +
        ", subprojectName='" + subprojectName + '\'' +
        ", subprojectDescription='" + subprojectDescription + '\'' +
        ", subprojectSeniordeveloperHours=" + subprojectSeniordeveloperHours +
        ", subprojectDeveloperHours=" + subprojectDeveloperHours +
        ", subprojectGraphicHours=" + subprojectGraphicHours +
        ", subprojectPrice=" + subprojectPrice +
        ", subprojectTotalHours=" + subprojectTotalHours +
        '}';
  }
}

