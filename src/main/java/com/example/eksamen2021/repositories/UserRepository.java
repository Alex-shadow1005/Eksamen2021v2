package com.example.eksamen2021.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    //TJEKKER I DATABASE AT EMAIL OG PASSWORD MATCHER, NÅR BRUGEREN LOGGER IND
    public User validateUser(User user) { //modtager user fra PostService -> loginpage hvis failed, wishlist hvis successfuldt login
        String sqlStr;
        PreparedStatement ps;
        ResultSet rs;
        User tempUser = null;
        try {
            Connection con = DBManager.getConnection();
            sqlStr = "SELECT * FROM user WHERE email = ? AND password = ?"; //leder efter en user med den email og password de har tastet ind

            ps = con.prepareStatement(sqlStr);
            ps.setString(1, user.getEmail()); //sætter email ind i ?-pladsen
            ps.setString(2, user.getPassword()); //sætter password ind i ?-pladsen

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
