package com.lms.api.stepdefs;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;

import files.User_Login_Payload;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User_Login_StepDefs {
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	Properties prop;
	String reqBody;
	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.setBody(User_Login_Payload.userLoginRequest());
		request = RestAssured.given().spec(requestSpec.build()).log().all();
	    
	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {		
		response = request.when().log().all()
				.post(Routes.USERLOGIN_ENDPOINT);
	    
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer expectedstatusCode) {
		
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
				
		 String token  = response.then().extract().path("token");
		 try{
	            ConfigReaderAndWriter.storeConfig("Token",token );
	            
	        } catch (IOException E){

	        }
		
		
	}


}
