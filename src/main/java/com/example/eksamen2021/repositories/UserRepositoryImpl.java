package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository{

  //@Author: Jens, Kristian
  public User createUser(User user) throws UserErrorMessageException {
    String mySql;
    PreparedStatement ps;
    int createUserSuccess = 0;

    try {
      //1. Get a connection to database
      Connection con = DBManagerImpl.getInstanceConnection();
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
        throw new UserErrorMessageException("OBS cannot create user. User might already exist. Error occured in: UserRepositoryImpl class. Method: createUser");
      }
    } catch (SQLException err) {
      throw new UserErrorMessageException(err.getMessage());
    }

  }

  //@Author: Silke og Jens
  //TJEKKER I DATABASE AT EMAIL OG PASSWORD MATCHER, NÅR BRUGEREN LOGGER IND
  public User validateUser(User user) throws UserErrorMessageException { //modtager user fra PostService -> loginpage hvis failed, wishlist hvis successfuldt login
    String sqlStr;
    PreparedStatement ps;
    ResultSet rs;
    User tempUser = null;
    try {
      Connection con = DBManagerImpl.getInstanceConnection();
      sqlStr = "SELECT * FROM users WHERE user_email = ? AND user_password = ?"; //leder efter en user med den email og password de har tastet ind

      ps = con.prepareStatement(sqlStr);
      ps.setString(1, user.getUserEmail()); //sætter email ind i ?-pladsen
      ps.setString(2, user.getUserPassword()); //sætter password ind i ?-pladsen

      rs = ps.executeQuery();

      if (rs.next()) { //kører resultaterne igennem (så længe der er flere resultatsæt)
        tempUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3)); //sætter String ind i resultSet

      } else {
        throw new UserErrorMessageException("OBS cannot verify user. User might not exist or the passwords might not match. Error occured in: UserRepositoryImpl class. Method: validateUser");
      }

    } catch (SQLException err) {
      throw new UserErrorMessageException(err.getMessage());

    }
    return tempUser;
  }
}
