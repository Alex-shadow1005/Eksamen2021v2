package com.example.eksamen2021.domain.models;

public class CalculateHourlyRate {

  private final int seniorDeveloper = 1500;
  private final int developer = 750;
  private final int graphicDesigner = 500;


  public int getSeniorDeveloper() {
    return seniorDeveloper;
  }

  public int getDeveloper() {
    return developer;
  }

  public int getGraphicDesigner() {
    return graphicDesigner;
  }
}
