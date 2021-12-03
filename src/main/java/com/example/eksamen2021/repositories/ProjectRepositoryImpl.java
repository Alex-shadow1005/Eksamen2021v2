package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;
import com.example.eksamen2021.domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl  implements ProjectRepository{
  private Project project;

  //TILFØJER ET PROJEKT TIL BRUGERENS PROJEKTLISTE
  public int createProject(Project project, User user) throws ErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int createProjectSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManager.getConnection();
      //2. Prepare statement
      mySql = "INSERT INTO projects (user_id, project_name, project_description) VALUES (?, ?, ?)";

      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setInt(1, user.getUserId());
      ps.setString(2, project.getProjectName());
      ps.setString(3, project.getProjectDescription());

      //4. Execute SQL query
      createProjectSuccess = ps.executeUpdate();
      if(createProjectSuccess == 1) {
        System.out.println("Project add");
      }else {
        throw new ErrorMessageException("Fejl i count addProject  err=");
      }
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println(err.getMessage());
    }
    return createProjectSuccess; //returnerer brugeren til Service
  }

  @Override
  public Subproject findProjectID(int ProjectId) throws ErrorMessageException {
    return null;
  }

  @Override
  public void updateProject(Project project) throws ErrorMessageException {

  }


  public void deleteProject(int projectId) throws ErrorMessageException {

    String mySql;
    PreparedStatement ps;
    // int h = 0;
    try {

      //1. Get a connection to database
      Connection con = DBManager.getConnection();

      //2. Prepare statement
      mySql = "DELETE FROM projects WHERE project_id=? AND subproject_id=?"; //Vent slut


      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setInt(1, projectId);
      //4. Execute SQL query
      ps.executeUpdate();

      System.out.println("successfully deleted project");
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println("Cannot delete project with subproject. Please delete any subprojects before deleting project." + err.getMessage());
    }
  }

  //VISER ALLE PROJEKTERNE PÅ BRUGERENS PROJEKTLISTE
  public List<Project> showAllProjects(int id) throws ErrorMessageException {
    ArrayList<Project> projects = new ArrayList<>();
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM projects WHERE user_id = ?"; // Do this line when we know database name and stuff

      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        projects.add(new Project(
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getInt(6)
        ));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return projects;
  }
}
