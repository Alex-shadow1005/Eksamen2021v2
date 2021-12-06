package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class SubprojectService {
  //@Autowired
  //CalculateService calculateService;
  CalculateService calculateService = new CalculateService();

  private SubprojectRepositoryImpl subprojectRepositoryImpl = new SubprojectRepositoryImpl();

  public String createSubproject(Project project, Subproject subproject) throws ErrorMessageException {
    /* SILKE HAR UDKOMMENTERET: SORRY ALEX. til test.::: double sum = calculateService.calsubprice(100,200,300);
    System.out.println(sum);
     */

    int addSubprojectSuccess = subprojectRepositoryImpl.createSubproject(project, subproject);
    if (addSubprojectSuccess == 1) {
      return "redirect:/subprojects/";
    } else {
      System.out.println("sut :c");
      return "redirect:/add-subprojects";
    }
  }

  public Subproject findSubprojectID(int subprojectId) throws ErrorMessageException {
    return subprojectRepositoryImpl.findSubprojectID(subprojectId);
  }

  //updater subprojecter ud fra sub_ID
  public void updateSubproject(Subproject subproject) throws ErrorMessageException {
    subprojectRepositoryImpl.updateSubproject(subproject);
  }

  //deleter projectet ud fra dens SubID
  public void deleteSubproject(int subprojectid) throws ErrorMessageException {
    subprojectRepositoryImpl.deleteSubproject(subprojectid);
  }

  public List<Subproject> showAllSubprojects(int projectid2) throws ErrorMessageException {
    System.out.println("projectid in service here: " + projectid2);
    return subprojectRepositoryImpl.showAllSubprojects(projectid2);

  }

/*
    //updater subprojecter ud fra sub_ID
    public void updateSubproject(int subproject_id, Subproject subEdt) throws SQLException{
        subprojectRepository.updateSubproject(subproject_id, subEdt);
    }

/*
  public List<Subproject> showAllSubprojects(int id) throws SQLException {
    return subprojectRepository.showAllSubprojects(id);
  }

 */


 /* public List<Subproject> showAllSubprojects(int projektId) {
    System.out.println("test i service + id = " + projektId);
    return subprojectRepository.showAllSubprojects(projektId);
  }

  */

}


