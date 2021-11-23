package com.example.eksamen2021.domain.models;

public class HourlyRate {
 final private int seninerDeveloper = 1500;
 final private int developer = 750;
 final private int graphicDesigner = 500;

  private int seninerDeveloperSum;
  private int developerSum;
  private int graphicDesignerSum;

  public int getSeninerDeveloper() {
    return seninerDeveloper;
  }

  public int getDeveloper() {
    return developer;
  }

  public int getGraphicDesigner() {
    return graphicDesigner;
  }

  public int getSeninerDeveloperSum() {
    return seninerDeveloperSum;
  }

  public void setSeninerDeveloperSum(int seninerDeveloperSum) {
    this.seninerDeveloperSum = seninerDeveloperSum;
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
