package com.example.eksamen2021.domain.models;

import com.example.eksamen2021.domain.services.CalculateService;

public class Subproject {
  CalculateService calculateService = new CalculateService();
  CalculateHourlyRate calculateHourlyRate = new CalculateHourlyRate();

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

  //BRUGES I addSubproject METODEN
  public Subproject(int subprojectId, String subprojectName, String subprojectDescription,int subprojectSeniordeveloperHours, int subprojectDeveloperHours, int subprojectGraphicHours) {
    this.subprojectId = subprojectId;
    this.subprojectName = subprojectName;
    this.subprojectDescription = subprojectDescription;
    this.subprojectSeniordeveloperHours = subprojectSeniordeveloperHours;
    this.subprojectDeveloperHours = subprojectDeveloperHours;
    this.subprojectGraphicHours = subprojectGraphicHours;

    subprojectPrice = (int) calculateService.calsubprice(getSubprojectSeniordeveloperHours(),getSubprojectDeveloperHours(),getSubprojectGraphicHours()) *
            (calculateHourlyRate.getSeniorDeveloper() + calculateHourlyRate.getDeveloper() + calculateHourlyRate.getGraphicDesigner());

    subprojectTotalHours = (int) calculateService.calsubhours(getSubprojectSeniordeveloperHours(),getSubprojectDeveloperHours(),getSubprojectGraphicHours());
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
}

