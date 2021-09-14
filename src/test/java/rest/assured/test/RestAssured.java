package rest.assured.test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import logger.Log;

public class RestAssured {

	@BeforeMethod
	public void setup() {
		
	}
	
	@Test
	public void getListUser() {
		
		File schema = new File(System.getProperty("user.dir")+"/resource/payload.json");
		
		Response response = io.restassured.RestAssured.get("https://reqres.in/api/users?page=2");
		Log.info("Verify the Status Code");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		Log.info("Verify First Name of ID 10 is Byron");
		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).
		body("data.id[3]", equalTo(10)).
		body("data.first_name", hasItems("Byron"));
		
		
		Log.info("Change the Request Body");
		JSONObject request = new JSONObject();
		request.put("name", "Byron");
		request.put("job", "BA");
		
		Log.info("Verify status code");
		given().
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201);
		 
		Log.info("Verify Response Json scheme");
		ValidatableResponse resp = io.restassured.RestAssured.get("https://reqres.in/api/users?page=2").then().
        body(matchesJsonSchema(schema));
	}
}
