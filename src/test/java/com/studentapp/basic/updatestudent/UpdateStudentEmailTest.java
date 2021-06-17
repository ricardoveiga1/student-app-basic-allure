package com.studentapp.basic.updatestudent;

import com.github.javafaker.Faker;
import com.studentapp.basic.TestBase;
import com.studentapp.basic.model.StudentPojo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateStudentEmailTest extends TestBase {

	@DisplayName("Update student email")
	@Test
	void updateStudentEmail() {
		
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();

		student.setEmail(fake.internet().emailAddress());

		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/101")
		.then()
		.statusCode(200);
	}
}
