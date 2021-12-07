package com.example.eksamen2021.domain.models;

public class CalculateHourlyRate {

  public double calsubhours3(Subproject subproject) {

    int subprojecttotalhours = subproject.getSubprojectDeveloperHours() + subproject.getSubprojectDeveloperHours() + subproject.getSubprojectSeniordeveloperHours();
    subproject.setSubprojectTotalHours(subprojecttotalhours);

    return subprojecttotalhours;
  }

  public double calsubprice3(Subproject subproject) {

    //seniorDeveloper = 1500;
   int cal1 = subproject.getSubprojectSeniordeveloperHours() * subproject.getSeniorDeveloper();

    //developer = 750;
    int cal2 = subproject.getSubprojectDeveloperHours() * subproject.getDeveloper();

    //graphicDesigner = 500;
    int cal3 = subproject.getSubprojectGraphicHours() * subproject.getGraphicDesigner();
    int subprojectPrice = cal1 + cal2 + cal3;


   subproject.setSubprojectPrice(subprojectPrice);


    return subprojectPrice;
  }

}
