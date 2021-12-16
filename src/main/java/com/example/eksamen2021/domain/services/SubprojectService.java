package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.util.List;
//@Author:Silke
public interface SubprojectService {

    public String createSubproject(Project project, Subproject subproject) throws SubProjectErrorMessageException;

    public Subproject findSubprojectID(int subprojectId) throws SubProjectErrorMessageException;

    public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException;

    public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException;

    public List<Subproject> showAllSubprojects(int projectid) throws SubProjectErrorMessageException;

    public void calsubhours(Subproject subproject) throws SubProjectErrorMessageException;

    public void calsubprice(Subproject subproject) throws SubProjectErrorMessageException;


}
