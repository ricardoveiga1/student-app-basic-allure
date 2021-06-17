package com.studentapp.basic.getstudent;

import com.studentapp.basic.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StudentGetResquestTest extends TestBase {

    @Test
    @Disabled
    @DisplayName("Get no google")
    public void styles(){
        RestAssured.given()
                .queryParam("","")
                .when()
                .get("https://www.google.com/")
                .then();

        RestAssured.given()
                .expect()
                .then();
    }

    @DisplayName("Getting all students from database")
    @Test
    void getAllStudents(){

        RestAssured.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
        ;

        RestAssured.given()
                .expect()
                .statusCode(200)
                .when()
                .get("/list")
        ;

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
        ;
    }

    @Disabled // desabilitando teste
    @DisplayName("Get a single CS student from the list")
    @Test
    void getSingleCSStudent(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("programme", "Computer Science");
        params.put("limit", 1);

        Response response =
                given()
                        //.queryParam("programme", "Computer Science")
                        //.queryParam("limit", 1)
                        //.queryParams("programme", "Computer Science", "limit", 1)
                        .queryParams(params)
                        .when()
                        .get("/list")
                ;
        //response.prettyPrint();
    }

    @DisplayName("pathParam GET a first student from the list")
    @Tag("fast")
    @Test
    void getTheFirstStudent(){
        Response response =
                given()
                        .pathParam("id", 2)
                        .when()
                        .get("/{id}")
                ;
        //response.prettyPrint();

        //		RestAssured.reset();  reseta todas cofig da TestBase
//
//		Response response2 =
//				given()
//				.pathParam("id", 2)
//				.when()
//				.get("/{id}");
//
//		response.prettyPrint();
    }

    @Test
    void getAllStudent(){
        Response response =
                given()
                        .when()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/list")
                ;
        //response.prettyPrint();
    }
}
