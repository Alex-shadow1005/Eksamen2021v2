package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.util.List;

public interface SubprojectRepository {
  public int createSubproject(Project project, Subproject subproject) throws ErrorMessageException;

  public Subproject findSubprojectID(int subprojectId) throws ErrorMessageException;

  public void updateSubproject(Subproject subproject) throws ErrorMessageException;

  public void deleteSubproject(int subprojectId) throws ErrorMessageException;

  public List<Subproject> showAllSubprojects(int id) throws ErrorMessageException;


}