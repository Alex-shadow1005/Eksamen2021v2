package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.CalculateHourlyRate;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.util.List;

public class CalculateService {
  //@Autowired
//CalculateHourlyRate calculateHourlyRate;
  CalculateHourlyRate calculateHourlyRate = new CalculateHourlyRate();


  public double calsubhours3(Subproject subproject) {

    return calculateHourlyRate.calsubhours3(subproject);
  }


  public double calsubprice3(Subproject subproject) {
    return calculateHourlyRate.calsubprice3(subproject);
  }


  //skal ha alle timer fra sub udfra et project id
  public int calprojecthours(List<Subproject> subprojects) {
    int projecttotalhours = 0;

    for (Subproject sp : subprojects) {
      projecttotalhours += sp.getSubprojectTotalHours();

    }


    return projecttotalhours;
  }


  public int calprojectprice(List<Subproject> subprojects) {
    int projectotalprice = 0;

    for (Subproject sp : subprojects) {
      projectotalprice += sp.getSubprojectPrice();
    }
    return projectotalprice;
  }

}

