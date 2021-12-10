package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class SubprojectServiceImpl implements SubprojectService {
  //@Autowired
  //CalculateService calculateService;
  CalculateService calculateService = new CalculateService();

  private SubprojectRepositoryImpl subprojectRepositoryImpl = new SubprojectRepositoryImpl();

  public String createSubproject(Project project, Subproject subproject) throws SubProjectErrorMessageException {
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

  public Subproject findSubprojectID(int subprojectId) throws SubProjectErrorMessageException {
    return subprojectRepositoryImpl.findSubprojectID(subprojectId);
  }

  //updater subprojecter ud fra sub_ID
  public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException {
    subprojectRepositoryImpl.updateSubproject(subproject);
  }

  //deleter projectet ud fra dens SubID
  public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException{
    subprojectRepositoryImpl.deleteSubproject(subprojectId);
  }

  public List<Subproject> showAllSubprojects(int projectid) throws SubProjectErrorMessageException {
    System.out.println("projectid in service here: " + projectid);
    return subprojectRepositoryImpl.showAllSubprojects(projectid);

  }
  public void calsubhours(Subproject subproject) throws SubProjectErrorMessageException{
    subproject.calsubhours();

  }
  public void calsubprice(Subproject subproject) throws SubProjectErrorMessageException{
    subproject.calsubprice();
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


