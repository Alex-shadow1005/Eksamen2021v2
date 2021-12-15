package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.models.Project;
import com.example.eksamen2021.domain.models.Subproject;

import java.sql.Connection;
import java.sql.Statement;


public class JDBCTestSetup {


  // min ide lave en test brfor sete OBS til Tine@BeforeEach
  //DELETE FROM `heroku_dd9ca97e9e588ce`.`users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');
  public void setUpJDBCT() {
    try {
      Connection connection = DBManager.getInstanceConnection();
      Statement SQLstatementTest = connection.createStatement();
      // start transaction
      connection.setAutoCommit(false);
      // create table of Test User
      // SQLstatementTest.addBatch("DELETE FROM heroku_dd9ca97e9e588ce.users WHERE(user_email = 'someone@AlphaSolutions.dk'");//SQLstatementTest.addBatch("DELETE FROM users WHERE user_email='Tine'");

      Subproject subproject = new Subproject(4, "subprojectName", "createSubproject", 10, 20, 2);
      Project project = new Project("projectName", "createSubproject", 20, 200);
      // delete from tableB where last_update_Dtm = sysdate-30;
      // SQLstatementTest.addBatch("DELETE FROM `subprojects` WHERE (`subproject_name_Dtm` = 'subprojectName');\n");

      //NOTE UserRepositoryImplTest Start#
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');\n");
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'EmailAlreadyExisting@AlphaSolutions.dk');\n");
      SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'validateUser@AlphaSolutions.dk');\n");
      //NOTE is Use to Test: public void createUser_UserEmailAlreadyExisting_ShouldThrowUserErrorMessageException()
      SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('EmailAlreadyExisting@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE: Is use to Test: public void validateUser_EmailDoesNotExisting_ShouldThrowUserErrorMessageException()
      SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('validateUser@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE UserRepositoryImplTest Slut#
/*
      SQLstatementTest.addBatch("DROP TABLE `users`;\n");
      SQLstatementTest.addBatch("CREATE TABLE `users`(\n" +
          " `user_id` INT NOT NULL AUTO_INCREMENT,\n" +
          " `user_email` VARCHAR(100) NOT NULL,\n" +
          " `user_password` VARCHAR(100) NOT NULL,\n" +
          " `user_name` VARCHAR(100) NOT NULL,\n" +
          " PRIMARY KEY (`user_id`),\n" +
          " UNIQUE INDEX `user_id_UNIQUE`(`user_id` ASC),\n" +
          " UNIQUE INDEX `user_email_UNIQUE`(`user_email` ASC));\n");
      */
      // SQLstatementTest.addBatch("DROP TABLE `heroku_dd9ca97e9e588ce`.`users`;\n");
      // SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');\n");


      // insert
      // SQLstatementTest.addBatch("DELETE FROM users WHERE (user_email = 'someone@AlphaSolutions.dk'");
      //NOTE: line 37 is use to Test: public void createUser_UserEmailAlreadyExisting_ShouldThrowUserErrorMessageException()
      //  SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('EmailAlreadyExisting@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //  SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('validateUser@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'someone@AlphaSolutions.dk');\n");
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

