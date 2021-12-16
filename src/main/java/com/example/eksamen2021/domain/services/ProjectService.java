package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;

import java.util.List;
//@Author: Kristian
public interface ProjectService {
    public int createProject(Project project, User user) throws ProjectErrorMessageException;

    public Project findProjectID(int projectId) throws ProjectErrorMessageException;

    public void updateProject(Project project) throws ProjectErrorMessageException;

    public void deleteProject(int projectId) throws ProjectErrorMessageException;

    public List<Project> showAllProjects(int id) throws ProjectErrorMessageException;

    public void calprojecthours(List<Subproject> subprojects, List<Project> projects) throws ProjectErrorMessageException;

    public void calprojectprices(List<Subproject> subprojects, List<Project> projects) throws ProjectErrorMessageException;

}
