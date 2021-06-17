package com.studentapp.basic.createstudent;

import com.github.javafaker.Faker;
import com.studentapp.basic.TestBase;
import com.studentapp.basic.model.StudentPojo;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.basic.data.suite.TestTags.FUNCTIONAL;
import static io.restassured.RestAssured.given;


public class CreateStudentPojoPayloadTest extends TestBase {

	@DisplayName("Create a new student by sending payload as an object")
	@Tag(FUNCTIONAL)
	@Test
	void createNewStudent() {
		
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		student.setFirstName(fake.name().firstName());  //student.setFirstName("Ricardo");
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201)
		.log().all()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/createStudent.json"));
	}
}
