package com.studentapp.basic.getstudent;

import com.studentapp.basic.TestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class getAllStudentsTest extends TestBase {

    @DisplayName("Buscar todos alunos")
    @Tag("functional")
    @Test
    void getAllStudent() {
        Response response =
                given()
                        .when()

                        .contentType(ContentType.JSON)
                        .when()
                        .get("/list");
        response.prettyPrint();
        response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getStudents.json"));
    }

    @DisplayName("pathParam GET a first student from the list")
    @Tag("all")
    @Test
    void getTheFirstStudent() {
        Response response =
                given()
                        .pathParam("id", 6)
                        .when()
                        .get("/{id}");
        response.prettyPrint();
        response
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getOneStudent.json"));
    }


}
