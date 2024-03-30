package com.lms.api.stepdefs;
import java.io.IOException;
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
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	UserTests userTest = new UserTests();
	
	@Given("Admin creates GET Request with valid batch Id")
	public void admin_creates_get_request_with_valid_batch_id() {
		User.baseSetUp();
		User.getUserForValidBatchId();			    
	}
//2. scenario	
	@Given("Admin creates GET Request  with invalid batchId")
	public void admin_creates_get_request_with_invalid_batch_id() throws IOException {
		User.baseSetUp();
		User.getUserForInvalidBatchId();
	    
	}
	@Then("Admin receives status {int} with Not Found error message {string}")
	public void admin_receives_status_with_not_found_error_message(Integer int1, String string) throws IOException {
		userTest.test_Get_User_By_ProgramBatches_With_Invalid_BatchId();
	}

	
	
//3.Scenario	
	@Given("Admin creates GET Request with valid batch Id with no Auth")
	public void admin_creates_get_request_with_valid_batch_id_with_no_auth() {
	    User.baseSetUpWithNoAuth();
	}
	
	@Then("Admin receives status {int} with Unauthorized message")
	public void admin_receives_status_with_unauthorized_message(Integer int1) {		
		userTest.test_Get_User_By_ProgramBatches();
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


}
