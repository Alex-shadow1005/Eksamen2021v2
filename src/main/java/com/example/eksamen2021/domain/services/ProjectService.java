package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.ProjectRepository;
import com.example.eksamen2021.repositories.SubprojectRepository;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
  private ProjectRepository projectRepository = new ProjectRepository();
  private SubprojectRepository subprojectRepository = new SubprojectRepository();

  public String addProject(Project project, User user) {
    int addProjectSuccess = projectRepository.addProject(project, user);
    if (addProjectSuccess == 1) {
      return "redirect:/show";
    } else {
      System.out.println("sut :c");
      return "redirect:/addProject";
    }
  }


//deleter projectet ud fra dens ID
  public void deleteProject(int projectId) throws SQLException {
    projectRepository.deleteProject(projectId);
  }


  public List<Project> showAllProjects(int id) {
    return projectRepository.showAllProjects(id);
  }



  public List<Subproject> showAllSubprojects(int projectid2) {
    System.out.println("projectid in service here: " + projectid2);
    return subprojectRepository.showAllSubprojects(projectid2);
  }



}
