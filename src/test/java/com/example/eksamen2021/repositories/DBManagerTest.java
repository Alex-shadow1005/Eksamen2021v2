package com.example.eksamen2021.repositories;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

  @Test
  public void test_getConnectionToDatebase() {
    Connection connection_test = DBManager.getInstanceConnection();
    assertNotNull(connection_test);
  }
  @Test
  public void test_getConnectionToDatebaseIsSingleton() {
    Connection test_SingletonConnection1 = DBManager.getInstanceConnection();
    Connection test_SingletonConnection2 = DBManager.getInstanceConnection();
    assertEquals(test_SingletonConnection1, test_SingletonConnection2);
  }
}
