package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.SubprojectRepositoryImpl;

import java.util.List;

public class SubprojectServiceImpl implements SubprojectService {


    private SubprojectRepositoryImpl subprojectRepositoryImpl = new SubprojectRepositoryImpl();
    //@Author:Jens
    public String createSubproject(Project project, Subproject subproject) throws SubProjectErrorMessageException {
        int addSubprojectSuccess = subprojectRepositoryImpl.createSubproject(project, subproject);
        if (addSubprojectSuccess == 1) {
            return "redirect:/subprojects/";
        } else {
            System.out.println("sut :c");
            return "redirect:/add-subprojects";
        }
    }
    //@Author: Silke, Kristian, Alexander, Jens
    public Subproject findSubprojectID(int subprojectId) throws SubProjectErrorMessageException {
        return subprojectRepositoryImpl.findSubprojectID(subprojectId);
    }

    //opdaterer subprojecter ud fra subId
    //@Author: Silke, Kristian, Alexander, Jens
    public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException {
        subprojectRepositoryImpl.updateSubproject(subproject);
    }

    //sletter projectet ud fra dens subId
    //@Author: Silke, Kristian, Alexander, Jens
    public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException {
        System.out.println("!!!!!!!!!!!!ServiceDelete!!!!!!!!!!" + subprojectId);
        subprojectRepositoryImpl.deleteSubproject(subprojectId);
    }
    //@Author: Silke, Kristian, Alexander, Jens
    public List<Subproject> showAllSubprojects(int projectid) throws SubProjectErrorMessageException {
        System.out.println("projectid in service here: " + projectid);
        return subprojectRepositoryImpl.showAllSubprojects(projectid);
    }
    //@Author: Silke, Kristian, Alexander, Jens
    public List<Subproject> gettingAllSubprojects() throws SubProjectErrorMessageException {
        return subprojectRepositoryImpl.gettingAllSubprojects();
    }
    //@Author: Alexander og Jens
    public void calsubhours(Subproject subproject) throws SubProjectErrorMessageException {
        subproject.calsubhours();

    }
    //@Author:  Alexander og Jens
    public void calsubprice(Subproject subproject) throws SubProjectErrorMessageException {
        subproject.calsubprice();
    }

}