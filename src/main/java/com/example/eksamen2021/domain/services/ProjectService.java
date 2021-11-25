package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;
import com.example.eksamen2021.repositories.ProjectRepository;

import java.util.List;

public class ProjectService {
  private ProjectRepository projectRepository = new ProjectRepository();

  public String addProject(Project project, User user) {
    int addProjectSuccess = projectRepository.addProject(project, user);
    if (addProjectSuccess == 1) {
      return "redirect:/show";
    } else {
      System.out.println("sut :c");
      return "redirect:/addProject";
    }
  }

  public String addSubproject(Project project, Subproject subproject) {
    int addSubprojectSuccess = projectRepository.addSubproject(project, subproject);
    if (addSubprojectSuccess == 1) {
      return "redirect:/show";
    } else {
      System.out.println("sut :c");
      return "redirect:/addProject";
    }
  }
//deleter projectet ud fra dens ID
  public void deleteProject(int projectId) {
    projectRepository.deleteProject(projectId);
  }
  //deleter projectet ud fra dens SubID
  public void deleteSubproject(int subprjectid) {
    projectRepository.deleteSubproject(subprjectid);
  }

  public List<Project> showAll(int id) {
    return projectRepository.showAll(id);
  }

  public List<Subproject> showAllSubprojects(int id) {
    return projectRepository.showAllSubprojects(id);
  }
}
