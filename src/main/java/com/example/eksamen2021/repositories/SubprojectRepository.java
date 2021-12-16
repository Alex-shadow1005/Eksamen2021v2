package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.util.List;
//@Author: Jens
public interface SubprojectRepository {

  public int createSubproject(Project project, Subproject subproject) throws  SubProjectErrorMessageException;

  public Subproject findSubprojectID(int subprojectId) throws  SubProjectErrorMessageException;

  public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException;

  public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException;

  public List<Subproject> showAllSubprojects(int id) throws SubProjectErrorMessageException;
}