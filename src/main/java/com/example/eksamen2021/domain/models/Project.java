package com.example.eksamen2021.domain.models;

import com.example.eksamen2021.domain.ProjectErrorMessageException;


import java.util.ArrayList;
import java.util.List;
//@Author: Silke, Kristian, Alexander, Jens
public class Project {
  private int userId;
  private int projectId;
  private String projectName;
  private String projectDescription;
  private int projectHours;
  private int projectPrice;

  public Project(String projectName, String projectDescription, int projectHours, int projectPrice) {
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectHours = projectHours;
    this.projectPrice = projectPrice;
  }

  //DENNE KONSTRUKTØR BRUGES I findId i repo
  public Project(int userId, int projectId, String projectName, String projectDescription, int projectHours, int projectPrice) {
    this.userId = userId;
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectHours = projectHours;
    this.projectPrice = projectPrice;
  }

  //DENNE KONSTRUKTØR BRUGES I SHOW-PROJECTS.HTML
  public Project(int projectId, String projectName, String projectDescription, int projectHours, int projectPrice) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectHours = projectHours;
    this.projectPrice = projectPrice;
  }

  public Project() {
  }

  //information expert jens
  //@Author: Alex + jens
  public void calprojecthours(List<Subproject> gettingAllSubprojects, List<Project> projects) {

    for (Project project : projects) {
      int projectID = project.getProjectId();
      int projecttotalhours = 0;
      for (Subproject sp : gettingAllSubprojects) {
        int ProjectIdFromSubproject = sp.getProjectId();
        if (projectID == ProjectIdFromSubproject) {
          projecttotalhours += sp.getSubprojectTotalHours();
        }
        project.setProjectHours(projecttotalhours);
      }
    }
  }
  //@Author: Alex + jens
  public void calprojectprice(List<Subproject> gettingAllSubprojects, List<Project> projects) {
    for (Project project : projects) {
      int projectID = project.getProjectId();
      int projectotalprice = 0;
      for (Subproject subproject : gettingAllSubprojects) {
        int ProjectIdFromSubproject = subproject.getProjectId();

        if (projectID == ProjectIdFromSubproject) {
          projectotalprice += subproject.getSubprojectPrice();
        }
        project.setProjectPrice(projectotalprice);

      }

    }

  }


  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public int getProjectPrice() {
    return projectPrice;
  }

  public void setProjectPrice(int projectPrice) {
    this.projectPrice = projectPrice;
  }

  public int getProjectHours() {
    return projectHours;
  }

  public void setProjectHours(int projectHours) {
    this.projectHours = projectHours;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Project: " +
        "project id = " + projectId +
        ", project name = " + projectName +
        ", project description = " + projectDescription +
        ", project price = " + projectPrice;
  }

}
