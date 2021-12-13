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

    User user = new User("someone@AlphaSolutions.dk", "1234", "Yes");
    //Act/DK:Handling
    User newUser = userRepository.createUser(user);
    //Assert/DK:Påstå
    assertTrue(user.getUserId() != 0);
    assertEquals("someone@AlphaSolutions.dk", newUser.getUserEmail());
    assertEquals("1234", newUser.getUserPassword());
    assertEquals("Yes", newUser.getUserUsername());

  }

  @Test
  public void createUser_UserEmailAlreadyExisting_ShouldThrowUserErrorMessageException() throws UserErrorMessageException {

    //Arrange
    User user = new User("EmailAlreadyExisting@AlphaSolutions.dk", "1234", "Yes");
    //Act/DK:Handling
    // userRepository.createUser(user);
    //Assert/DK:Påstå
    assertThrows(UserErrorMessageException.class, () -> userRepository.createUser(user), "OBS cant not create User  vedr.UserRepositoryImpl i metode = public User createUser(User user)");

  }

  @Test
  public void validateUser_GivenCorrectUserInfo() throws UserErrorMessageException {
    User user = new User("validateUser@AlphaSolutions.dk", "1234", "Yes Test");
    User newUser = userRepository.validateUser(user);
    assertNotNull(user);
    assertEquals("validateUser@AlphaSolutions.dk", newUser.getUserEmail());
    assertEquals("1234", newUser.getUserPassword());
  }

  @Test
  public void validateUser_EmailDoesNotExisting_ShouldThrowUserErrorMessageException() throws UserErrorMessageException {
    User user = new User("validateUser@EmailDoesNotExisting.dk", "1234", "Yes Test");

    assertThrows(UserErrorMessageException.class, () -> userRepository.validateUser(user), "UserEmail & UserPassword is Not validate login OBS  vedr. UserRepositoryImpl i metode = public User validateUser(User user) ");
  }





/*
  @Test
  public void validateUser() {
  }

 */
}