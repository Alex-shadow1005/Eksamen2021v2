package com.example.eksamen2021.repositories;

import java.sql.Connection;
import java.sql.Statement;


public class JDBCTestSetup {
  public void setUpJDBCT() {
    try {
      Connection connection = DBManager.getConnection();
      Statement  SQLstatementTest = connection.createStatement();
      // start transaction
      connection.setAutoCommit(false);
      // create table of Test User
      SQLstatementTest.addBatch(" DROP TABLE heroku_dd9ca97e9e588ce.test_users");
      SQLstatementTest.addBatch("CREATE TABLE heroku_dd9ca97e9e588ce.test_users(" +

          " users_id_test INT NOT NULL AUTO_INCREMENT," +
          " users_email_test`VARCHAR(100) NOT NULL," +
          " users_password_test`VARCHAR(100) NOT NULL," +
          " users_name_test`VARCHAR(100) NOT NULL," +
          "PRIMARY KEY (`users_id_test`)," +
          "UNIQUE INDEX `users_id_test_UNIQUE`(`users_id_test`ASC), " +
          "UNIQUE INDEX `users_email_test_UNIQUE`(`users_email_test`ASC) ");


      // insert
      SQLstatementTest.addBatch("insert into users (email, password,name) values ('someone@AlphaSolutions.dk','1234','Alpha')");
      SQLstatementTest.addBatch("insert into users (email, password) values ('someone@TeamSuperAwesome.com','OneTwoThreeFire','Team')");

      int[] updateCounts = SQLstatementTest.executeBatch();
      // end transaction

      connection.commit();

    } catch (Exception e) {
      System.out.println("Fail in JDBCTestFixture - setup");
      System.out.println(e.getMessage());
    }
  }

}