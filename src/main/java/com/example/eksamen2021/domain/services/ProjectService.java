package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.ProjectRepositoryImpl;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class ProjectService {
  private ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl();
  private SubprojectRepositoryImpl subprojectRepository = new SubprojectRepositoryImpl();

  //OBS ny  int# ændert Jens kl.10:38 03-12-2021 vedr.public #int# createUser(User user)
  //før String# ændert Jens kl.10:38 03-12-2021 vedr.public #String# createUser(User user)
  public int createProject(Project project, User user) throws ErrorMessageException {
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

  //alex!!!!
  public int createProject2(Project project, User user) throws ErrorMessageException {
    return projectRepositoryImpl.createProject2(project, user);
  }

  public Project findProjectID(int projectId) throws ErrorMessageException {
    return projectRepositoryImpl.findProjectID(projectId);
  }

  //updater subprojecter ud fra sub_ID
  public void updateProject(Project project) throws ErrorMessageException {
    projectRepositoryImpl.updateProject(project);
  }


  //deleter projectet ud fra dens ID
  public void deleteProject(int projectId) throws ErrorMessageException {
    projectRepositoryImpl.deleteProject(projectId);
  }


  public List<Project> showAllProjects(int id) throws ErrorMessageException {
    return projectRepositoryImpl.showAllProjects(id);
  }


  public List<Subproject> showAllSubprojects(int projectid2) throws ErrorMessageException {
    System.out.println("projectid in service here: " + projectid2);
    return subprojectRepository.showAllSubprojects(projectid2);
  }
}