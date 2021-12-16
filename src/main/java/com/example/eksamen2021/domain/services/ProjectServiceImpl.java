package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.ProjectRepositoryImpl;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{

  private ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl();
  private Project project = new Project();

  public int createProject(Project project, User user) throws ProjectErrorMessageException {
    return projectRepositoryImpl.createProject(project, user);
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


  //Author: Alexander + Jens
  public void calprojecthours(List<Subproject> gettingAllSubprojects,List<Project> projects) throws ProjectErrorMessageException {

    project.calprojecthours(gettingAllSubprojects,projects);
  }
  public void calprojectprices(List<Subproject> gettingAllSubprojects,List<Project> projects) throws ProjectErrorMessageException {

    project.calprojectprice(gettingAllSubprojects,projects);
  //  project.calprojectprices(subprojects,projects);

  }

}