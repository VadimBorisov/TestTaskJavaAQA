package com.API.apitests;

import com.API.model.UserDTO;
import com.API.specification.Specifications;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PatchUserTest {
  final String TEST_URL = "/api/users/2";
  public UserDTO testUser;

  @BeforeEach
  void setUp() {
    testUser = new UserDTO();
  }

  @Test
  @DisplayName("Тестирование PATCH запроса с прверкой правильной даты обновления")
  public void patchRequestCheckUpdateDate() {
    testUser.setFirstName("morpheus");
    testUser.setJob("zion resident");
    String updatedAt = RestAssured.given()
            .spec(Specifications.requestSpecification())
            .log().all()
            .body(testUser)
            .patch(TEST_URL)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .path("updatedAt");

    String[] splitUpdatedAt = updatedAt.split("T");
    Assertions.assertEquals(splitUpdatedAt[0], LocalDate.now().toString());
  }
}
