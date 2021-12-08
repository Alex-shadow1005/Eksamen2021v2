package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.CalculateHourlyRate;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.util.List;

public class CalculateService {
  //@Autowired
//CalculateHourlyRate calculateHourlyRate;
  CalculateHourlyRate calculateHourlyRate = new CalculateHourlyRate();


  public void calsubhours3(Subproject subproject) {
    calculateHourlyRate.calsubhours3(subproject);
    //return calculateHourlyRate.calsubhours3(subproject);
  }

  public void calsubprice3(Subproject subproject) {
    calculateHourlyRate.calsubprice3(subproject);
  }

  public void calprojecthours(List<Subproject> subprojects,List<Project> projects) {
    calculateHourlyRate.calprojecthours(subprojects,projects);

  }
  public void calprojectprice(List<Subproject> subprojects,List<Project> projects) {
    calculateHourlyRate.calprojectprice(subprojects,projects);

  }

}

