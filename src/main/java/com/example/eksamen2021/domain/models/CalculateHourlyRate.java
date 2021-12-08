package com.example.eksamen2021.domain.models;

import java.util.List;

public class CalculateHourlyRate {

  public void calsubhours3(Subproject subproject) {


    int subprojecttotalhours = 0;
    subprojecttotalhours += subproject.getSubprojectSeniordeveloperHours() + subproject.getSubprojectDeveloperHours() + subproject.getSubprojectGraphicHours();
    subproject.setSubprojectTotalHours(subprojecttotalhours);

    //return subprojecttotalhours;
  }

  public void calsubprice3(Subproject subproject) {

    //seniorDeveloper = 1500;
    int cal1 = subproject.getSubprojectSeniordeveloperHours() * subproject.getSeniorDeveloper();

    //developer = 750;
    int cal2 = subproject.getSubprojectDeveloperHours() * subproject.getDeveloper();

    //graphicDesigner = 500;
    int cal3 = subproject.getSubprojectGraphicHours() * subproject.getGraphicDesigner();
    int subprojectPrice = cal1 + cal2 + cal3;


    subproject.setSubprojectPrice(subprojectPrice);

  }

  //skal ha alle timer fra sub udfra et project id
  public void calprojecthours(List<Subproject> subprojects, List<Project> projects) {
    int projecttotalhours = 0;
    for (Project ps : projects) {
      for (Subproject sp : subprojects) {
        projecttotalhours += sp.getSubprojectTotalHours();
      }
      ps.setProjectHours(projecttotalhours);
    }


  }

  public void calprojectprice(List<Subproject> subprojects,List<Project> projects) {
    int projectotalprice = 0;
    for (Project ps:projects) {
      for (Subproject sp : subprojects) {
        projectotalprice += sp.getSubprojectPrice();
      }
      ps.setProjectPrice(projectotalprice);
    }

  }

}
