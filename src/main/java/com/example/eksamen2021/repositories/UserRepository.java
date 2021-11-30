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
      mySql = "INSERT INTO users (user_username, user_email, user_password) VALUES (?, ?, ?)"; //Opretter streng i SQL

      ps = con.prepareStatement(mySql);
      //3. Set the parameters
      ps.setString(1, user.getUserUsername()); //sætter brugerens username ind i det næste ?
      ps.setString(2, user.getUserEmail()); //sætter brugerens email ind i det første ?
      ps.setString(3, user.getUserPassword()); //sætter brugerens password ind i det næste ?
      //4. Execute SQL query
      h = ps.executeUpdate();
      System.out.println("User added");
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println("Fejl i count createUser  err=" + err.getMessage());
    }
    return h; //returnerer brugeren til Service
  }


    //TJEKKER I DATABASE AT EMAIL OG PASSWORD MATCHER, NÅR BRUGEREN LOGGER IND
    public User validateUser(User user) { //modtager user fra PostService -> loginpage hvis failed, wishlist hvis successfuldt login
        String sqlStr;
        PreparedStatement ps;
        ResultSet rs;
        User tempUser = null;
        try {
            Connection con = DBManager.getConnection();
            sqlStr = "SELECT * FROM users WHERE user_email = ? AND user_password = ?"; //leder efter en user med den email og password de har tastet ind

            ps = con.prepareStatement(sqlStr);
            ps.setString(1, user.getUserEmail()); //sætter email ind i ?-pladsen
            ps.setString(2, user.getUserPassword()); //sætter password ind i ?-pladsen

            rs = ps.executeQuery();

            if (rs.next()) { //kører resultaterne igennem (så længe der er flere resultatsæt)
                tempUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3)); //sætter String ind i resultSet
            }

            //Hvis den email og password matcher -> wishlist (forside for brugere der er logget ind). Ellers: prøv igen (på login-siden)
        } catch (SQLException err) {
            System.out.println("Fejl i count err=" + err.getMessage()); //-> gå til login-side på forkert login-besked

        }
        return tempUser;
    }
}
