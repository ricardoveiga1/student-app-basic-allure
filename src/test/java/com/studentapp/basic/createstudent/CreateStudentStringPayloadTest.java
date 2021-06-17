package com.studentapp.basic.createstudent;

import com.studentapp.basic.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateStudentStringPayloadTest extends TestBase {

	@DisplayName("Create a new student by sending payload as String")
	@Test
	void createNewStudent() {
		
		String payload = "{\"firstName\":\"test2\"," +
				"\"lastName\":\"User\"," +
				"\"email\":\"test5@gmail.com\"," +
				"\"programme\":\"ComputerScience\"," +
				"\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then()
		.statusCode(201);
	}
}
