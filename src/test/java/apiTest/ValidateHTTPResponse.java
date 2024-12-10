package apiTest;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateHTTPResponse {
    @Test(description = "RestAssured Basic - Get user by ID - reqres.in")
    public void validateGetUserBasics(){
        System.out.println("validateGetUserBasics");
        int statusCode = given()
                .when()
                .get("https://reqres.in/api/users/2")
                .statusCode();
        System.out.println("Http response status code is "+ statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
