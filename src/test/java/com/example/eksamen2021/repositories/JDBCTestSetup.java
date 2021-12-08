package com.example.eksamen2021.repositories;

import java.sql.Connection;
import java.sql.Statement;


public class JDBCTestSetup {


  // min ide lave en test brfor sete OBS til Tine@BeforeEach
  //DELETE FROM `heroku_dd9ca97e9e588ce`.`users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');
  public void setUpJDBCT() {
    try {
      Connection connection = DBManager.getConnection();
      Statement SQLstatementTest = connection.createStatement();
      // start transaction
      connection.setAutoCommit(false);
      // create table of Test User
      // SQLstatementTest.addBatch("DELETE FROM heroku_dd9ca97e9e588ce.users WHERE(user_id = 'someone@AlphaSolutions.dk'");
      SQLstatementTest.addBatch("DELETE FROM users WHERE user_email='Tine'");
  /*    SQLstatementTest.addBatch("CREATE TABLE users(" +
          " user_id INT NOT NULL AUTO_INCREMENT," +
          " user_email VARCHAR(100) NOT NULL," +
          " user_password VARCHAR(100) NOT NULL," +
          " user_name VARCHAR(100) NOT NULL," +
          " PRIMARY KEY (user_id)," +
          " UNIQUE INDEX user_id_UNIQUE(user_id ASC)," +
          " UNIQUE INDEX user_email_UNIQUE(user_email ASC)");

   */

      // insert
      // SQLstatementTest.addBatch("DELETE FROM users WHERE (user_email = 'someone@AlphaSolutions.dk'");
     // SQLstatementTest.addBatch("insert into users (user_email, user_password, user_username) values (Tine,1234,Tine)");
      //SQLstatementTest.addBatch("insert into users (email, password name ) values ('someone@TeamSuperAwesome.com','OneTwoThreeFire','Team')");

      SQLstatementTest.executeBatch();
      // end transaction

      connection.commit();

    } catch (Exception e) {
      System.out.println("Fail in JDBCTestSetup - setup");
      System.out.println(e.getMessage());
    }
  }

}