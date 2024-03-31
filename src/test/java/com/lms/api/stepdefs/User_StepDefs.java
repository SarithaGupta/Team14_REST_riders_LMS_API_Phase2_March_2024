package com.lms.api.stepdefs;

import java.io.IOException;

import com.lms.api.actions.Actions_User;
import com.lms.api.actions.User;
import com.lms.api.endpoints.Routes;
import com.lms.api.test.UserTests;

import files.User_Login_Payload;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User_StepDefs {
	
	/*RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	
	Actions_User_Saritha act_User = new Actions_User_Saritha();
	UserTests userTest = new UserTests();
	



//2. scenario	
	@Given("Admin creates GET Request  with invalid batchId")
	public void admin_creates_get_request_with_invalid_batch_id() throws IOException {
		//User.baseSetUp();
		User.getUserForInvalidBatchId();
	    
	}
	@Then("Admin receives status {int} with Not Found error message {string}")
	public void admin_receives_status_with_not_found_error_message(Integer int1, String string) throws IOException {
		userTest.test_Get_User_By_ProgramBatches_With_Invalid_BatchId(345678);
	}
	
//3.Scenario	
	@Given("Admin creates GET Request with valid batch Id with no Auth")
	public void admin_creates_get_request_with_valid_batch_id_with_no_auth() {
	    User.baseSetUpWithNoAuth();
	    
	}
		
	@Then("Admin receives status {int} with Unauthorized message {string}")
	public void admin_receives_status_with_unauthorized_message(Integer int1, String Scenario) {
		if(Scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with no authorization")) {
			userTest.test_Get_User();
		}else if(Scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization")){
			userTest.test_Get_User_By_ValidProgramId();
		}
	}

	
//4.Scenario
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		User.getUserForValidBatchIdWithInvalidEndPoint();
	}
	@Then("Admin receives status {int} with Not Found error message")
	public void admin_receives_status_with_not_found_error_message(Integer int1) throws IOException {
		userTest.test_Get_User_By_ProgramBatches_With_Invalid_Endpoint();
	  
	}
	
//5.Scenario for valid Program Id
	/*@Given("Admin creates GET Request with valid program Id")
	public void admin_creates_get_request_with_valid_program_id() {
		User.baseSetUp();
		User.getUserForValidProgramId();
	    
	}*/
//6.Scenario
	/*@Given("Admin creates GET Request with invalid program Id")
	public void admin_creates_get_request_with_invalid_program_id() throws IOException {
		//User.baseSetUp();
		User.getUserForInvalidProgramId();
	    
	}
	
	// Check if admin is able to get the Admins for valid program Id without authorization
	@Given("Admin creates GET Request with valid program Id {string}")
	public void admin_creates_get_request_with_valid_program_id(String Scenario) {
		if(Scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization")) {
			System.out.println("Basesetup Without Auth**********");
			User.baseSetUpWithNoAuth();
			
			User.getUserForValidProgramId();
		}else if(Scenario.equals("Check if admin is able to get the Admins for valid program Id")) {
			//User.baseSetUp();
			
			User.getUserForValidProgramId();
			System.out.println("Basesetup With Auth**********");
		}
	    
	}*/



}
