package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;

import java.util.List;

public interface ProjectRepository {

  public int createProject(Project project, User user) throws ErrorMessageException;

  public Project findProjectID(int projectId) throws ErrorMessageException;

  public void updateProject(Project project) throws ErrorMessageException;

  public void deleteProject(int projectId) throws ErrorMessageException;

  public List<Project> showAllProjects(int id) throws ErrorMessageException;
}
