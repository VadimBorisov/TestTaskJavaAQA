package com.API.apitests;

import com.API.model.UserDTO;
import com.API.specification.Specifications;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetUsersTest {
  final String TEST_URL = "/api/users?page=2";
  final String EMAIL_DOMAIN = "@reqres.in";

  List<String> usersEmails = new ArrayList<>();

  @Test
  @DisplayName("Get запрос на получение пользователей проверка статус кода 200")
  public void getUsersRe() {
    usersEmails = RestAssured.given()
            .spec(Specifications.requestSpecification())
            .log().all()
            .get(TEST_URL)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .extract()
            .path("data.email");

    for (String email : usersEmails) {
      Assertions.assertTrue(email.endsWith(EMAIL_DOMAIN));
    }
  }
}
