package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.SubProjectErrorMessageException;
import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubprojectRepositoryImpl implements SubprojectRepository {

  //@Author: Silke + Jens (Exception)
  //TILFØJER ET SUBPROJEKT TIL BRUGERENS SUBPROJEKTLISTE
  public int createSubproject(Project project, Subproject subproject) throws SubProjectErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int createSubprojectSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManagerImpl.getInstanceConnection();
      //2. Prepare statement
      mySql = "INSERT INTO subprojects (project_id, subproject_name, subproject_description, subproject_seniordeveloper_hours, subproject_developer_hours, subproject_graphic_hours, subproject_price, subproject_total_hours) VALUES (?, ?, ?, ?, ?, ?,?,?)";

      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setInt(1, project.getProjectId());
      ps.setString(2, subproject.getSubprojectName());
      ps.setString(3, subproject.getSubprojectDescription());
      ps.setInt(4, subproject.getSubprojectSeniordeveloperHours());
      ps.setInt(5, subproject.getSubprojectDeveloperHours());
      ps.setInt(6, subproject.getSubprojectGraphicHours());
      ps.setInt(7, subproject.getSubprojectPrice());
      ps.setInt(8, subproject.getSubprojectTotalHours());

      //4. Execute SQL query
      createSubprojectSuccess = ps.executeUpdate();
      if (createSubprojectSuccess == 1) {
        System.out.println("Subproject succesfully added");
      } else {
        throw new SubProjectErrorMessageException("OBS cannot find subproject ID. Error occured in: SubprojectRepositoryImpl class. Method: createSubproject.");
      }
      //5. Display the result set
    } catch (SQLException err) {
      throw new SubProjectErrorMessageException(err.getMessage());
    }
    return createSubprojectSuccess; //returnerer brugeren til Service
  }

  //@Author: Jens
  public Subproject findSubprojectID(int subprojectId) throws SubProjectErrorMessageException {

    String mysql;
    PreparedStatement ps;
    Subproject findSubproject = null;
    try {
      //1. Get a connection to database
      Connection con = DBManagerImpl.getInstanceConnection();

      //2. Prepare statement
      mysql = "SELECT * FROM subprojects WHERE subproject_id = ?";


      ps = con.prepareStatement(mysql);

      //3. Set the parameters
      ps.setInt(1, subprojectId);

      //4. Execute SQL query
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        findSubproject = (new Subproject(
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
      if (subprojectId == findSubproject.getSubprojectId()) {
        System.out.println("Succesfully found subproject ID.");
        return findSubproject;
      } else {
        throw new SubProjectErrorMessageException("OBS cannot find subproject ID. Error occured in: SubprojectRepositoryImpl class. Method: findSubprojectID.");

      }
    } catch (SQLException err) {
      throw new SubProjectErrorMessageException(err.getMessage());
    }
  }


  //@Author: Jens
  public void updateSubproject(Subproject subproject) throws SubProjectErrorMessageException {

    String mysql;
    PreparedStatement ps;
    int upateSubprojectSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManagerImpl.getInstanceConnection();

      //2. Prepare statement


      mysql = "UPDATE subprojects SET\n" +
          " subproject_name = ?,\n" +
          " subproject_description = ?,\n" +
          "subproject_seniordeveloper_hours = ?\n," +
          "subproject_developer_hours = ?,\n" +
          "subproject_graphic_hours = ?,\n" +
          " subproject_price = ?,\n" +
          "subproject_total_hours = ?\n" +
          "WHERE subproject_id = ?;\n";

      //"WHERE subproject_id = " + subproject.getSubprojectId(); // 8*


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
      // 7
      ps.setInt(7, subproject.getSubprojectTotalHours());
      // 8 WHERE subproject_id = ?
      ps.setInt(8, subproject.getSubprojectId());


      //4. Execute SQL query
      upateSubprojectSuccess = ps.executeUpdate();


      if (upateSubprojectSuccess == 1) {

        System.out.println("Succesfully updated subproject.");
      } else {
        throw new SubProjectErrorMessageException("OBS cannot update subproject. Error occured in: SubprojectRepositoryImpl class. Method: updateProject.");
      }

      //5. Display the result set
    } catch (SQLException err) {
      throw new SubProjectErrorMessageException(err.getMessage());
    }

  }

  //@Author: Kristian + Alex
  public void deleteSubproject(int subprojectId) throws SubProjectErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int deleteSubprojectSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManagerImpl.getInstanceConnection();
      //2. Prepare statement
      mySql = "DELETE FROM subprojects where subproject_id=?";

      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setInt(1, subprojectId);

      //4. Execute SQL query
      deleteSubprojectSuccess = ps.executeUpdate();
      if (deleteSubprojectSuccess == 1) {

        System.out.println("Succesfully deleted subproject.");
      } else {
        throw new SubProjectErrorMessageException("OBS cannot delete subprojects. Error occured in: SubprojectRepositoryImpl class. Method: deleteSubprojects.");
      }

      //5. Display the result set
    } catch (SQLException err) {
      throw new SubProjectErrorMessageException(err.getMessage());
    }

  }

  //@Author: Silke
  //VISER ALLE SUBPROJEKTER DER HØRER TIL PROJEKT-ID'EN
  public List<Subproject> showAllSubprojects(int id) throws SubProjectErrorMessageException {
    PreparedStatement ps;
    ArrayList<Subproject> subprojects = new ArrayList<>();
    try {
      Connection con = DBManagerImpl.getInstanceConnection();
      String SQL = "SELECT * FROM subprojects WHERE project_id = ?";

      System.out.println("test i repo: + id =" + id);

      ps = con.prepareStatement(SQL);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        subprojects.add(new Subproject(
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8),
            rs.getInt(9)
        ));
      }

    } catch (SQLException err) {
      throw new SubProjectErrorMessageException("OBS cannot find subprojects. Error occured in: SubprojectRepositoryImpl class. Method: showAllSubprojects. " + err.getMessage());
    }
    return subprojects;

  }

  //@Author: Jens
  //VISER ALLE SUBPROJEKTER DER HØRER TIL PROJEKT-ID'EN
  public List<Subproject> gettingAllSubprojects() throws SubProjectErrorMessageException {
    PreparedStatement ps;
    ArrayList<Subproject> subprojects = new ArrayList<>();
    try {
      Connection con = DBManagerImpl.getInstanceConnection();
      String SQL = "SELECT * FROM subprojects";

      ps = con.prepareStatement(SQL);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        subprojects.add(new Subproject(
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8),
            rs.getInt(9)
        ));
      }

    } catch (SQLException err) {

      throw new SubProjectErrorMessageException("OBS cannot find subprojects. Error occured in: SubprojectRepositoryImpl class. Method: gettingAllSubprojects. " + err.getMessage());
    }
    return subprojects;

  }
}