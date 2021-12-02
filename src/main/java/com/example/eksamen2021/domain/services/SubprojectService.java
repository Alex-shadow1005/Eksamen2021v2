package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.ProjectRepository;
import com.example.eksamen2021.repositories.SubprojectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class SubprojectService {
  //@Autowired
  //CalculateService calculateService;
  CalculateService calculateService = new CalculateService();

  private SubprojectRepository subprojectRepository = new SubprojectRepository();

  public String addSubproject(Project project, Subproject subproject) {
    /* SILKE HAR UDKOMMENTERET: SORRY ALEX. til test.::: double sum = calculateService.calsubprice(100,200,300);
    System.out.println(sum);
     */

    int addSubprojectSuccess = subprojectRepository.addSubproject(project, subproject);
    if (addSubprojectSuccess == 1) {
      return "redirect:/subprojects/";
    } else {
      System.out.println("sut :c");
      return "redirect:/add-subprojects";
    }
  }

  //deleter projectet ud fra dens SubID
  public void deleteSubproject(int subprojectid) throws SQLException {
    subprojectRepository.deleteSubproject(subprojectid);
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




    public List<Subproject> showAllSubprojects(int projectid2) {
        System.out.println("projectid in service here: " + projectid2);
        return subprojectRepository.showAllSubprojects(projectid2);

    }



  public Subproject findSubprojectID(int subprojectId) throws SQLException {
    return subprojectRepository.findSubprojectID(subprojectId);
  }

  //updater subprojecter ud fra sub_ID
  public void updateSubproject(Subproject subproject) throws SQLException {
    subprojectRepository.updateSubproject(subproject);
  }
}


