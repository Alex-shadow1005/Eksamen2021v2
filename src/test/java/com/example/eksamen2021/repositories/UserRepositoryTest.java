package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

  Connection con = null;
  @BeforeEach
  void setUp() {
  }

  @Test
  void createUser()  {

    // Junit test for saveUser

    // Arrange
    String sqlStr;
    PreparedStatement ps;
    ResultSet rs;
    User tempUser = null;
    User user = new User("UserTest@test.dk", "1234TEST");
    try {
      Connection con = DBManager.getConnection();
      // Act

      sqlStr = "SELECT * FROM users WHERE user_email = ? AND user_password = ?"; //leder efter en user med den email og password de har tastet ind

      ps = con.prepareStatement(sqlStr);
      ps.setString(1, user.getUserEmail()); //sætter email ind i ?-pladsen
      ps.setString(2, user.getUserPassword()); //sætter password ind i ?-pladsen

      rs = ps.executeQuery();

      if (rs.next()) { //kører resultaterne igennem (så længe der er flere resultatsæt)
        tempUser = new User(rs.getString(2), rs.getString(3)); //sætter String ind i resultSet
      }
      User result = tempUser;
      assertEquals(user, result);


    } catch (SQLException err) {
      System.out.println("Fejl i count err="); //-> gå til login-side på forkert login-besked

    }
    User result = tempUser;
    assertEquals(user, result);

  }
}