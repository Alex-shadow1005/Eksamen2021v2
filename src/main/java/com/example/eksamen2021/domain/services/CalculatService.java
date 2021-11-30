package com.example.eksamen2021.domain.services;

import com.example.eksamen2021.domain.models.CalculateHourlyRate;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.repositories.SubprojectRepository;

public class CalculatService {

    CalculateHourlyRate calculateHourlyRate = new CalculateHourlyRate();
    SubprojectRepository subprojectRepository = new SubprojectRepository();
    Subproject subproject = new Subproject();

/*
    public void calcualte(int projectId) throws SQLException {
        CalculatRepositories.calculateProjectSum(projectId);
    }

 */

    public double calsubprice(double seniorDeveloperhours, double developerhours, double graphicDesignerhours){



        double cal1 = seniorDeveloperhours * calculateHourlyRate.getSeniorDeveloper();
        double cal2 = developerhours * calculateHourlyRate.getDeveloper();
        double cal3 = graphicDesignerhours * calculateHourlyRate.getGraphicDesigner();
        double subprojectPrice = cal1 + cal2 + cal3;

        subprojectRepository.addSubprojectPrice(subproject);

        return subprojectPrice;
    }

    public double calsubhours(double seniorDeveloperhours, double developerhours, double graphicDesignerhours){
        subprojectRepository.addSubprojectHours(subproject);


        double subprojecttotalhours = seniorDeveloperhours + developerhours + graphicDesignerhours;


        return subprojecttotalhours;
    }




}
