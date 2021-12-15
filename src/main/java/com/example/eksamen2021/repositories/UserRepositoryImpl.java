package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository{

  //OBS! Ænder id workbasse til createUser 04-12-2021 kl.20:53
  public User createUser(User user) throws UserErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int createUserSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManager.getInstanceConnection();
      //2. Prepare statement
      mySql = "INSERT INTO users (user_username, user_email, user_password) VALUES (?, ?, ?)"; //Opretter streng i SQL

      ps = con.prepareStatement(mySql, Statement.RETURN_GENERATED_KEYS);
      //3. Set the parameters
      ps.setString(1, user.getUserUsername()); //sætter brugerens username ind i det næste ?
      ps.setString(2, user.getUserEmail()); //sætter brugerens email ind i det første ?
      ps.setString(3, user.getUserPassword()); //sætter brugerens password ind i det næste ?
      //4. Execute SQL query
      createUserSuccess = ps.executeUpdate();
      if (createUserSuccess == 1) {
        ResultSet userID = ps.getGeneratedKeys();
        userID.next();
        int id = userID.getInt(1);
        user.setUserId(id);
        //5. Display the result set
        return user; //returnerer brugeren til Service
      } else {
        throw new UserErrorMessageException("OBS cant not create User  vedr.UserRepositoryImpl i metode = public User createUser(User user) ");
      }
    } catch (SQLException err) {
      throw new UserErrorMessageException(err.getMessage());
    }

  }

 /*
  //OPRETTER NY BRUGER
  //OBS! Ænder newUser til createUser 23-11-2021 kl.10:26
  public int createUser(User user)throws ErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int createUserSuccess = 0;

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
      createUserSuccess = ps.executeUpdate();
      if(createUserSuccess == 1) {
        System.out.println("User added");
      }else {
        throw new ErrorMessageException("Fejl i count createUser  err=");
      }
      //5. Display the result set
    } catch (SQLException err) {
      System.out.println(err.getMessage());
    }
    return createUserSuccess; //returnerer brugeren til Service
  }

*/


  //TJEKKER I DATABASE AT EMAIL OG PASSWORD MATCHER, NÅR BRUGEREN LOGGER IND
  public User validateUser(User user) throws UserErrorMessageException { //modtager user fra PostService -> loginpage hvis failed, wishlist hvis successfuldt login
    String sqlStr;
    PreparedStatement ps;
    ResultSet rs;
    User tempUser = null;
    try {
      Connection con = DBManager.getInstanceConnection();
      sqlStr = "SELECT * FROM users WHERE user_email = ? AND user_password = ?"; //leder efter en user med den email og password de har tastet ind

      ps = con.prepareStatement(sqlStr);
      ps.setString(1, user.getUserEmail()); //sætter email ind i ?-pladsen
      ps.setString(2, user.getUserPassword()); //sætter password ind i ?-pladsen

      rs = ps.executeQuery();

      if (rs.next()) { //kører resultaterne igennem (så længe der er flere resultatsæt)
        tempUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3)); //sætter String ind i resultSet


      } else {
        throw new UserErrorMessageException("UserEmail & UserPassword is Not a valid login OBS  vedr. UserRepositoryImpl i metode = public User validateUser(User user)  ");
      }

      //Hvis den email og password matcher -> wishlist (forside for brugere der er logget ind). Ellers: prøv igen (på login-siden)
    } catch (SQLException err) {
      throw new UserErrorMessageException(err.getMessage());

      // System.out.println("Fejl i count err=" + err.getMessage()); //-> gå til login-side på forkert login-besked

    }
    return tempUser;
  }



  //SELECT * FROM projects
  //JOIN users ON projects.userId = users.userId
}
