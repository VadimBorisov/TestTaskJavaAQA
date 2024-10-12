package com.API.apitests;

import com.API.specification.Specifications;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteUserTest {
  final String TEST_URL = "/api/users/2";

  @Test
  @DisplayName("Тестирование DELETE запроса, проверка кода 204")
  public void deleteRequestCheckStatusCode() {
    RestAssured.given()
            .spec(Specifications.requestSpecification())
            .log().all()
            .delete(TEST_URL)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_NO_CONTENT);
  }
}
