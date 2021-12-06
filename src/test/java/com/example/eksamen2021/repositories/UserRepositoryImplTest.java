package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.ErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
  UserRepositoryImpl userRepository;
  JDBCTestSetup jdbcTestSetup;

  @BeforeEach
  public void setUp() throws Exception {

    jdbcTestSetup = new JDBCTestSetup();
    jdbcTestSetup.setUpJDBCT();
    userRepository = new UserRepositoryImpl();
  }

  @Test
  public void createUser_GivenCorrectUserInfo() throws ErrorMessageException {
/*
    User user = new User("someone@AlphaSolutions.dk","1234","Alpha");
    //Act/DK:Handling
   int newUser = userRepository.createUser(user);
    //Assert/DK:Påstå
    assertTrue(newUser > 0);
    assertEquals("someone@AlphaSolutions.dk",newUser.getUserEmail());
    assertEquals("1234",newUser.getUserPassword());

*/
  }

  @Test
  public void validateUser() {
  }
}