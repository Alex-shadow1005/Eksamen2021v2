package com.example.eksamen2021.domain.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalculateHourlyRate {
  /* public void calsubhours3(Subproject subproject) {


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
   */

  //skal ha alle timer fra sub udfra et project id
  public void calprojecthours(List<Subproject> gettingAllSubprojects, List<Project> projects) {

    for (Project project : projects) {
      int projectID = project.getProjectId();
      int projecttotalhours = 0;
      for (Subproject sp : gettingAllSubprojects) {
        int ProjectIdFromSubproject = sp.getProjectId();
        if (projectID == ProjectIdFromSubproject) {
          projecttotalhours += sp.getSubprojectTotalHours();
        }
        project.setProjectHours(projecttotalhours);
      }


    }
  }


  public void calprojectprice(List<Subproject> gettingAllSubprojects, List<Project> projects) {
    for (Project project : projects) {
      int projectID = project.getProjectId();
      int projectotalprice = 0;
      for (Subproject subproject : gettingAllSubprojects) {
        int ProjectIdFromSubproject = subproject.getProjectId();

        if (projectID == ProjectIdFromSubproject) {
          projectotalprice += subproject.getSubprojectPrice();
        }
        project.setProjectPrice(projectotalprice);

      }

    }

  }
}

