package com.example.eksamen2021.repositories;

import com.example.eksamen2021.domain.UserErrorMessageException;
import com.example.eksamen2021.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {
  UserRepositoryImpl userRepository;
  JDBCTestSetup jdbcTestSetup;

  @BeforeEach
  public void setUp() throws Exception {

    jdbcTestSetup = new JDBCTestSetup();
    jdbcTestSetup.setUpJDBCT();
    userRepository = new UserRepositoryImpl();
  }

  @Test
  public void createUser_GivenCorrectUserInfo() throws UserErrorMessageException {

    User user = new User("Tine", "1234", "Tine");
    //Act/DK:Handling
    User newUser = userRepository.createUser(user);
    //Assert/DK:Påstå
    assertTrue(user.getUserId() != 0);
    assertEquals("Tine", newUser.getUserEmail());
    assertEquals("1234", newUser.getUserPassword());

  }

/*
  @Test
  public void validateUser() {
  }

 */
}