package com.studentapp.basic.deletestudent;

import com.studentapp.basic.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudentTest extends TestBase {

	@DisplayName("Delete Student from the system")
	@Test
	void deleteStudent() {
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.delete("/101")
		.then()
		.statusCode(204);
		
	}
}
