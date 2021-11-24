package com.example.eksamen2021.domain.models;

public class HourlyRate {
 final private int seniorDeveloper = 1500;
 final private int developer = 750;
 final private int graphicDesigner = 500;

  private int seniorDeveloperSum;
  private int developerSum;
  private int graphicDesignerSum;

  public int getSeniorDeveloper() {
    return seniorDeveloper;
  }

  public int getDeveloper() {
    return developer;
  }

  public int getGraphicDesigner() {
    return graphicDesigner;
  }

  public int getSeniorDeveloperSum() {
    return seniorDeveloperSum;
  }

  public void setSeniorDeveloperSum(int seniorDeveloperSum) {
    this.seniorDeveloperSum = seniorDeveloperSum;
  }

  public int getDeveloperSum() {
    return developerSum;
  }

  public void setDeveloperSum(int developerSum) {
    this.developerSum = developerSum;
  }

  public int getGraphicDesignerSum() {
    return graphicDesignerSum;
  }

  public void setGraphicDesignerSum(int graphicDesignerSum) {
    this.graphicDesignerSum = graphicDesignerSum;
  }
}
