package com.studentapp.basic;

import com.studentapp.basic.config.Configuration;
import com.studentapp.basic.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.config.JsonPathConfig;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.config;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class TestBase {

    protected static Configuration configuration;

   /* @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/student";
        System.out.println("Passou na Test Base");
    }
*/
    @BeforeAll
    public static void beforeAllTests() {
        configuration = ConfigurationManager.getConfiguration();

        baseURI = configuration.baseURI();
        basePath = configuration.basePath();
        port = configuration.port();

        // solve the problem with big decimal assertions
        config = newConfig().
                jsonConfig(jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL)).
                sslConfig(new SSLConfig().allowAllHostnames());

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
