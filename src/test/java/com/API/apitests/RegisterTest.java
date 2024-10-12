package com.API.apitests;

import com.API.specification.Specifications;
import com.API.model.UserDTO;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterTest {
  final String TEST_URL = "/api/register";
  UserDTO testUser;

  @BeforeEach
  void setUp() {
    testUser = UserDTO.builder()
            .email("eve.holt@reqres.in")
            .password("pistol")
            .build();
  }


  @Test
  @DisplayName("Тестирование POST запроса регистрации с правильными данными")
  public void postRequestSuccessRegister() {

    RestAssured.given()
            .spec(Specifications.requestSpecification())
            .log().all()
            .body(testUser)
            .post(TEST_URL)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK);
  }

  @Test
  @DisplayName("Тестирование POST запрос регистрации с ошибкой отсутствия пароля")
  public void postRequestFailedPasswordRegister() {
    testUser.setPassword("");

    RestAssured.given()
            .spec(Specifications.requestSpecification())
            .log().all()
            .body(testUser)
            .post(TEST_URL)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
  }
}
