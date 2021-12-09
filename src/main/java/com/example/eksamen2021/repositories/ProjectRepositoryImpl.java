package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
  private Project project;

  //TILFØJER ET PROJEKT TIL BRUGERENS PROJEKTLISTE
  public int createProject(Project project, User user) throws ProjectErrorMessageException {
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
      if (createProjectSuccess == 1) {
        System.out.println("Project add");
      } else {
        throw new ProjectErrorMessageException("Fejl i count addProject  err=");
      }
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println(err.getMessage());
    }
    return createProjectSuccess; //returnerer brugeren til Service
  }

  @Override
  public Project findProjectID(int projectId) throws ProjectErrorMessageException {

    String mysql;
    PreparedStatement ps;
    Project findProject = null;
    try {
      //1. Get a connection to database
      Connection con = DBManager.getConnection();

      //2. Prepare statement
      mysql = "SELECT * FROM projects WHERE project_id = ?";


      ps = con.prepareStatement(mysql);

      //3. Set the parameters
      ps.setInt(1, projectId);

      //4. Execute SQL query
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        findProject = (new Project(
            // Workbench columns
            //user_id
            rs.getInt(1),
            //project_id
            rs.getInt(2),
            //project_name
            rs.getString(3),
            //project_description
            rs.getString(4),
            //project_hours
            rs.getInt(5),
            //project_price = ?
            rs.getInt(6)
        ));
      }

      System.out.println("finder ID YESSS");
    } catch (SQLException err) {
      System.out.println("Post con " + err.getMessage());
    }
    return findProject;
  }




  @Override
  public void updateProject(Project project) throws ProjectErrorMessageException {
    String mysql;
    PreparedStatement ps;

    try {
      //1. Get a connection to database
      Connection con = DBManager.getConnection();

      //2. Prepare statement


      mysql = "UPDATE projects SET\n" +
          " project_name = ?,\n" +
          " project_description = ?,\n" +
          " project_hours = ?\n," +
          " project_price = ?\n" +
          "WHERE project_id = ?;\n";

      //"WHERE subproject_id = " + subproject.getSubprojectId(); // 8*


      ps = con.prepareStatement(mysql);

      //3. Set the parameters
      // 1 project_name = ?
      ps.setString(1, project.getProjectName());
      // 2 project_description = ?
      ps.setString(2, project.getProjectDescription());
      // 3 project_hours = ?
      ps.setInt(3, project.getProjectHours());
      // 4 project_price = ?
      ps.setInt(4, project.getProjectPrice());
      // 5 WHERE project_id = ?
      ps.setInt(5, project.getProjectId());

      //4. Execute SQL query
      int rows = ps.executeUpdate();


      if (rows > 0) {

        System.out.println("A new user has been inserted Successfully.");
      }

      //5. Display the result set
    } catch (SQLException err) {
      System.out.println("Fejl user has NOT! been inserted Successfully=" + err.getMessage());
    }
    System.out.println("Du har udatert");
  }


  public void deleteProject(int projectId) throws ProjectErrorMessageException {

    String mySql;
    PreparedStatement ps;
    // int h = 0;
    try {

      //1. Get a connection to database
      Connection con = DBManager.getConnection();

      //2. Prepare statement
      mySql = "DELETE FROM projects WHERE project_id=?"; //Vent slut


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
  public List<Project> showAllProjects(int id) throws ProjectErrorMessageException {
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
