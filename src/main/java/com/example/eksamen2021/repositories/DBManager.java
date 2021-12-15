package com.example.eksamen2021.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

  //variabler
  private static String user;
  private static String password;
  private static String url;


  private static Connection connection = null;

  public static Connection getInstanceConnection() {

    if (connection != null) {
      return connection;
    }

                                                                                                      //Via dette læser den fra run->edit config->environment variables i stedet for fra application.properties
    url = System.getenv("url"); //properties.getProperty("url");
    user = System.getenv("tsa_user"); //properties.getProperty("user");
    password = System.getenv("tsa_password"); //properties.getProperty("password");

    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}
