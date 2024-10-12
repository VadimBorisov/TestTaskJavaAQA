package com.API.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Specifications {

  public static RequestSpecification requestSpecification() {
    return new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();
  }

  public static ResponseSpecification responseSpecification() {
    return new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .expectContentType(ContentType.JSON)
            .expectStatusCode(HttpStatus.SC_OK)
            .expectResponseTime(lessThanOrEqualTo(2L), TimeUnit.SECONDS)
            .build();
  }

}
