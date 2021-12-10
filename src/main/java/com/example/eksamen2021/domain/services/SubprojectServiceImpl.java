package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class SubprojectServiceImpl implements SubprojectService {


  private SubprojectRepositoryImpl subprojectRepositoryImpl = new SubprojectRepositoryImpl();

  public String createSubproject(Project project, Subproject subproject) throws SubProjectErrorMessageException {
    int addSubprojectSuccess = subprojectRepositoryImpl.createSubproject(project, subproject);
    if (addSubprojectSuccess == 1) {
      return "redirect:/subprojects/";
    } else {
      System.out.println("sut :c");
      return "redirect:/add-subprojects";
    }
  }

  public Subproject findSubprojectID(int subprojectId) throws SubProjectErrorMessageException {
    return subprojectRepositoryImpl.findSubprojectID(subprojectId);
  }

  //opdaterer subprojecter ud fra subId
  public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException {
    subprojectRepositoryImpl.updateSubproject(subproject);
  }

  //sletter projectet ud fra dens subId
  public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException {
    subprojectRepositoryImpl.deleteSubproject(subprojectId);
  }

  public List<Subproject> showAllSubprojects(int projectid) throws SubProjectErrorMessageException {
    System.out.println("projectid in service here: " + projectid);
    return subprojectRepositoryImpl.showAllSubprojects(projectid);
  }

  public void calsubhours(Subproject subproject) throws SubProjectErrorMessageException {
    subproject.calsubhours();

  }

  public void calsubprice(Subproject subproject) throws SubProjectErrorMessageException {
    subproject.calsubprice();
  }

}