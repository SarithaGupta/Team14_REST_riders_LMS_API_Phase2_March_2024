package com.lms.api.stepdefs;


import com.lms.api.endpoints.Routes;
import com.lms.api.test.UserTests;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program_StepDefs {
	
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build());
	   
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		
		/*response = request.when().log().all()
				.get(Routes.GET_ALL_PROGRAMS_ENDPOINT);*/
	    
	}

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		UserTests userTest = new UserTests();
		userTest.test_Get_User_By_ProgramBatches();
	}

}
