package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.models.CalculateHourlyRate;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.ProjectRepositoryImpl;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class ProjectService {
  private ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl();
  private SubprojectRepositoryImpl subprojectRepository = new SubprojectRepositoryImpl();
  private CalculateHourlyRate calculateHourlyRate = new CalculateHourlyRate();
  private Project project = new Project();

  //OBS ny  int# ændert Jens kl.10:38 03-12-2021 vedr.public #int# createUser(User user)
  //før String# ændert Jens kl.10:38 03-12-2021 vedr.public #String# createUser(User user)
  public int createProject(Project project, User user) throws ProjectErrorMessageException {
    return projectRepositoryImpl.createProject(project, user);


    //før ændert Jens kl.10:38 03-12-2021
    /*int addProjectSuccess = projectRepositoryImpl.addProject(project, user);
    if (addProjectSuccess == 1) {
      return "redirect:/show";
    } else {
      System.out.println("sut :c");
      return "redirect:/addProject";
    }

     */
  }


  public Project findProjectID(int projectId) throws ProjectErrorMessageException {
    return projectRepositoryImpl.findProjectID(projectId);
  }

  //updater subprojecter ud fra sub_ID
  public void updateProject(Project project) throws ProjectErrorMessageException {
    projectRepositoryImpl.updateProject(project);
  }


  //deleter projectet ud fra dens ID
  public void deleteProject(int projectId) throws ProjectErrorMessageException {
    projectRepositoryImpl.deleteProject(projectId);
  }


  public List<Project> showAllProjects(int id) throws ProjectErrorMessageException {
    return projectRepositoryImpl.showAllProjects(id);
  }

  public void calprojecthours(List<Subproject> subprojects,List<Project> projects) throws ProjectErrorMessageException {
   calculateHourlyRate.calprojecthours(subprojects,projects);
   // project.calprojecthours(subprojects,projects);
  }
  public void calprojectprices(List<Subproject> subprojects,List<Project> projects) throws ProjectErrorMessageException {
    calculateHourlyRate.calprojectprice(subprojects,projects);
  //  project.calprojectprices(subprojects,projects);

  }

/*
  public List<Subproject> showAllSubprojects(int projectid2) throws ProjectErrorMessageException, SubProjectErrorMessageException {
    System.out.println("projectid in service here: " + projectid2);
    return subprojectRepository.showAllSubprojects(projectid2);
  }

 */

}