package com.example.eksamen2021.repositories;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
//@Author: Jens
class DBManagerTest {

  //@Author: Jens
  @Test
  public void test_getConnectionToDatebase() {
    Connection connection_test = DBManagerImpl.getInstanceConnection();
    assertNotNull(connection_test);
  }
  //@Author: Jens
  @Test
  public void test_getConnectionToDatebaseIsSingleton() {
    Connection test_SingletonConnection1 = DBManagerImpl.getInstanceConnection();
    Connection test_SingletonConnection2 = DBManagerImpl.getInstanceConnection();
    assertEquals(test_SingletonConnection1, test_SingletonConnection2);
  }
}
