package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

  //TILFØJER ET ØNSKE TIL BRUGERENS ØNSKELISTE
  public int addProject(Project project, User user) {
    String mySql;
    PreparedStatement ps;
    int h = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManager.getConnection();
      //2. Prepare statement
      mySql = "INSERT INTO wishwishwish.wishes (user_id, project_name, project_description) VALUES (?, ?, ?)";

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

  //VISER ALLE ØNSKERNE PÅ BRUGERENS ØNSKELISTE
  public List<Project> showAll(int id) {
    ArrayList<Project> projects = new ArrayList<>();
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM wishwishwish.wishes WHERE user_id = ?"; // Do this line when we know database name and stuff

      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        projects.add(new Project(
            rs.getInt(2),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6)
        ));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return projects;
  }
}
