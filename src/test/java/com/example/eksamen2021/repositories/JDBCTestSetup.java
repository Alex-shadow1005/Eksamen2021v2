package com.example.eksamen2021.repositories;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCTestSetup {

  public void setUpJDBCT() {
    try {
      Connection connection = DBManager.getInstanceConnection();
      Statement SQLstatementTest = connection.createStatement();
      // start transaction
      connection.setAutoCommit(false);

      //NOTE UserRepositoryImplTest Start#
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');\n");
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'EmailAlreadyExisting@AlphaSolutions.dk');\n");
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'validateUser@AlphaSolutions.dk');\n");
      //NOTE is Use to Test: public void createUser_UserEmailAlreadyExisting_ShouldThrowUserErrorMessageException()
      SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('EmailAlreadyExisting@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE: Is use to Test: public void validateUser_EmailDoesNotExisting_ShouldThrowUserErrorMessageException()
      SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('validateUser@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE UserRepositoryImplTest Slut#

      SQLstatementTest.executeBatch();

      connection.commit();

    } catch (Exception e) {
      System.out.println("Fail in JDBCTestSetup - setup");
      System.out.println(e.getMessage());
    }
  }
}