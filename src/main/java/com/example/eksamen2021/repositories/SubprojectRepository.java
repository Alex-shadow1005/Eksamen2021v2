package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubprojectRepository {

    //TILFØJER ET SUBPROJEKT TIL BRUGERENS SUBPROJEKTLISTE
    public int addSubproject(Project project, Subproject subproject) {
        String mySql;
        PreparedStatement ps;
        int h = 0;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();
            //2. Prepare statement
            mySql = "INSERT INTO subprojects (project_id, subproject_name, subproject_description) VALUES (?, ?, ?)";

            ps = con.prepareStatement(mySql);
            //3. Set the parameters
            ps.setInt(1, project.getProjectId());
            ps.setString(2, subproject.getSubprojectName());
            ps.setString(3, subproject.getSubprojectDescription());
            //4. Execute SQL query
            h = ps.executeUpdate();
            System.out.println("Subproject added");
            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
        return h; //returnerer brugeren til Service
    }

    //Sletter et subProject
    public void deleteSubproject(int subprojectId) {
        String mySql;
        PreparedStatement ps;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();
            //2. Prepare statement
            mySql = "DELETE FROM subprojects where subproject_id=?";

            ps = con.prepareStatement(mySql);
            //3. Set the parameters
            ps.setInt(1, subprojectId);

            //4. Execute SQL query
            ps.executeUpdate();
            System.out.println("Subproject Deleted");

            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }

    }
/*
    public void updateSubproject(int subproject_id, Subproject subEdt) {
        String mysql;
        PreparedStatement ps;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();

            //2. Prepare statement
            mysql = "UPDATE su";


            ps = con.prepareStatement(mysql);

            //3. Set the parameters
            ps.setString(1, subproject.getSubproject_name());
            ps.setString(2, subproject.getSubproject_description());
            ps.setInt(3, subproject.getSubproject_seniordeveloper_hours());
            ps.setInt(4, subproject.getSubproject_developer_hours());
            ps.setInt(5, subproject.getSubproject_graphic_hours());
            ps.setInt(6, subproject.getSubproject_id());

            //4. Execute SQL query
            ps.executeUpdate();

            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
    }

 */

    //VISER ALLE SUBPROJEKTER DER HØRER TIL PROJEKT-ID'EN
    public List<Subproject> showAllSubprojects(int id) {
        ArrayList<Subproject> subprojects = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subprojects WHERE project_id = ?"; // Do this line when we know database name and stuff

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                subprojects.add(new Subproject(
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return subprojects;
    }
    public Subproject findSubprojectID(int subprojectId) {
        String mysql;
        PreparedStatement ps;
        Subproject findSubproject = null;
        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();

            //2. Prepare statement
            mysql = "SELECT * FROM subproject WHERE subproject_id = ?";


            ps = con.prepareStatement(mysql);

            //3. Set the parameters
            ps.setInt(1, subprojectId);

            //4. Execute SQL query
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                findSubproject =(new Subproject(
                    // WorkBase colonder
                    //subproject_id
                    rs.getInt(1),
                    //subproject_name
                    rs.getString(3),
                    //subproject_description
                    rs.getString(4),
                    //subproject_seniordeveloper_hours
                    rs.getInt(5),
                    //subproject_developer_hours
                    rs.getInt(6),
                    //subproject_graphic_hours
                    rs.getInt(7),
                    //subproject_price = ?
                    rs.getInt(8)
                ));
            }
            System.out.println("finder ID YESSS");
        } catch (SQLException err) {
            System.out.println("Post con "+err.getMessage());
        }
        return findSubproject;
    }
    public void updateSubproject(Subproject subproject) {
        String mysql;
        PreparedStatement ps;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();

            //2. Prepare statement
            mysql = "UPDATE subprojects SET" +
                // 1
                "subproject_name = ?," + // 1
                // 2
                "subproject_description = ?," + // 2
                // 3
                "subproject_seniordeveloper_hours = ?," + // 3
                // 4
                "subproject_developer_hours = ?," + // 4
                // 5
                "subproject_graphic_hours = ?," + // 5
                // 6
                "subproject_price = ?" + // 6
                //7
                "WHERE subproject_id = ?"; // 7


            ps = con.prepareStatement(mysql);

            //3. Set the parameters
            // 1
            ps.setString(1, subproject.getSubprojectName());
            // 2
            ps.setString(2, subproject.getSubprojectDescription());
            // 3
            ps.setInt(3, subproject.getSubprojectSeniordeveloperHours());
            // 4
            ps.setInt(4, subproject.getSubprojectDeveloperHours());
            // 5
            ps.setInt(5, subproject.getSubprojectGraphicHours());
            // 6
            ps.setInt(6, subproject.getSubprojectPrice());
            // 7 WHERE subproject_id = ?
            ps.setInt(7, subproject.getSubprojectId());


            //4. Execute SQL query
            ps.executeUpdate();

            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
        System.out.println("Du har udatert");
    }
}
