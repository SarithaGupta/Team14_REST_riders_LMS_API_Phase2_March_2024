package com.lms.api.stepdefs;

import com.lms.api.actions.Actions_User;
import com.lms.api.endpoints.Routes;
import com.lms.api.test.UserTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Positive_User_Stepdefs {

	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	int batchId = 0;
	int programId = 0;
	Actions_User act_User = new Actions_User();
	UserTests userTest = new UserTests();
	
//Check if admin is able to get the Admins by program batches for valid batch ID		
	@Given("Admin creates GET Request with valid batch Id")
	public void admin_creates_get_request_with_valid_batch_id() {
		act_User.baseSetUp();					    
	}
	
	@When("Admin sends HTTPS Request with endpoint for {string}")
	public void admin_sends_https_request_with_endpoint_for(String scenario) {
	   
		response = act_User.getRequestUser(scenario,batchId,programId);
	}
	
	@Then("Admin receives {int} OK Status with response body for {string}.")
	public void admin_receives_ok_status_with_response_body_for(Integer int1, String scenario) {
		
		if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID")) {
			userTest.test_Get_User_By_Batch_ID();									
		} else if (scenario.equals("Check if admin is able to get the Admins for valid program Id")) {
			userTest.test_Get_User_By_Program_ID();
		}
	    
	}
	
//Check if admin is able to get the Admins for valid program Id	
	@Given("Admin creates GET Request with valid program Id {string}")
	public void admin_creates_get_request_with_valid_program_id(String scenario) {
		if (scenario.equals("Check if admin is able to get the Admins for valid program Id")) {
			act_User.baseSetUp();									
		} else if (scenario.equals("")) {

		}
	}

}
