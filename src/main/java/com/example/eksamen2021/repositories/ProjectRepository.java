package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private Project project;

    //TILFØJER ET PROJEKT TIL BRUGERENS PROJEKTLISTE
    public int addProject(Project project, User user) {
        String mySql;
        PreparedStatement ps;
        int h = 0;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();
            //2. Prepare statement
            mySql = "INSERT INTO projects (user_id, project_name, project_description) VALUES (?, ?, ?)";

            ps = con.prepareStatement(mySql);
            //3. Set the parameters
            ps.setInt(1, user.getUser_id());
            ps.setString(2, project.getProject_name());
            ps.setString(3, project.getProject_description());
            //4. Execute SQL query
            h = ps.executeUpdate();
            System.out.println("Project added");
            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
        return h; //returnerer brugeren til Service
    }

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
            ps.setInt(1, project.getProject_id());
            ps.setString(2, subproject.getSubproject_name());
            ps.setString(3, subproject.getSubproject_description());
            //4. Execute SQL query
            h = ps.executeUpdate();
            System.out.println("Subproject added");
            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
        return h; //returnerer brugeren til Service
    }

    public void deleteProject(int projectId) throws SQLException {

        String mySql;
        PreparedStatement ps;
        // int h = 0;
        try {

            //1. Get a connection to database
            Connection con = DBManager.getConnection();

            //2. Prepare statement
            mySql = "DELETE FROM projects WHERE project_id=?";


            ps = con.prepareStatement(mySql);
            //3. Set the parameters
            ps.setInt(1, projectId);
            //4. Execute SQL query
            ps.executeUpdate();
            //5. Display the result set
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage());
        }
    }


    //Sletter et subProject
    public void deleteSubproject(int subprojectId) {
        String mySql;
        PreparedStatement ps;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();
            //2. Prepare statement
            mySql = "DELETE FROM subproject where subproject_id=?";

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

    public void updateSubproject(Subproject subproject) {
        String mysql;
        PreparedStatement ps;

        try {
            //1. Get a connection to database
            Connection con = DBManager.getConnection();

            //2. Prepare statement
            mysql = "UPDATE FROM subproject SET" + "subproject_name=?," +
                    "subproject_description=?," + "subproject_seniordeveloper_hours=?"
                    + "subproject_developer_hours=?" + "subproject_graphic_hours=?" + "WHERE subproject_id=?";


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


    //VISER ALLE PROJEKTERNE PÅ BRUGERENS PROJEKTLISTE
    public List<Project> showAll(int id) {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM projects WHERE user_id = ?"; // Do this line when we know database name and stuff

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                projects.add(new Project(
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return projects;
    }

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
}
