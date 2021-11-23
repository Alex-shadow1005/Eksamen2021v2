package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
  //OPRETTER NY BRUGER
  //OBS! Ænder newUser til createUser 23-11-2021 kl.10:26
  public int createUser(User user) {
    String mySql;
    PreparedStatement ps;
    int h = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManager.getConnection();
      //2. Prepare statement
      mySql = "INSERT INTO user (email, password) VALUES (?, ?)"; //Opretter streng i SQL

      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setString(1, user.getEmail()); //sætter brugerens email ind i det første ?
      ps.setString(2, user.getPassword()); //sætter brugerens password ind i det næste ?
      //4. Execute SQL query
      h = ps.executeUpdate();
      System.out.println("User added");
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println("Fejl i count err=" + err.getMessage());
    }
    return h; //returnerer brugeren til Service
  }
}
