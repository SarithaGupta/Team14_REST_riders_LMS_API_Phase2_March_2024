package com.lms.api.stepdefs;

import java.io.IOException;

import com.lms.api.actions.Actions_LMS;
import com.lms.api.actions.Actions_User;
import com.lms.api.endpoints.Routes;
import com.lms.api.test.Tests_LMS;
import com.lms.api.test.UserTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Stepdefs_LMS {

	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	int batchId = 0;
	int programId = 0;
	
	Actions_LMS act_User = new Actions_LMS();
	Tests_LMS userTest = new Tests_LMS();
	
//Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields	
	@Given("Admin creates POST request with request body with all mandatory fields for {string}")
	public void admin_creates_post_request_with_request_body_with_all_mandatory_fields_for(String string) {
		act_User.baseSetUp();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint for {string}")
	public void admin_sends_https_request_and_request_body_with_endpoint_for(String scenario) throws IOException {
	    //response = act_User.createProgram(scenario);
	   
	}
	
	@Then("Admin receives {int} Created Status with response body for {string}.")
	public void admin_receives_created_status_with_response_body_for(Integer statusCode, String scenario) throws IOException {
		
		userTest.test_Post_With_Mandatory_Fields(scenario);
		
	}
	/*@Then("Admin receives {int} Created Status with response body for roles {string}")
	public void admin_receives_created_status_with_response_body_for_roles(Integer int1, String roleId) throws IOException {
	    userTest.test_Post_With_Mandatory_Fields(roleId);
	}*/


	
	@When("Admin sends HTTPS Request with endpoint for {string}")
	public void admin_sends_https_request_with_endpoint_for(String scenario) throws IOException {
	   
		response = act_User.getRequestUser(scenario,batchId,programId,"roleId");
	}
	
	@Then("Admin receives {int} OK Status with response body for {string}.")
	public void admin_receives_ok_status_with_response_body_for(Integer int1, String scenario) throws IOException {
		
		if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID")) {
			userTest.test_Get_User_By_Batch_ID(scenario);									
		} else if (scenario.equals("Check if admin is able to get the Admins for valid program Id")) {
			userTest.test_Get_User_By_Program_ID(scenario);
			
		}else if (scenario.equals("Check if admin is able to retreive Admins by valid role ID")) {
			userTest.test_Get_User_By_Role_ID(scenario);
		}else if (scenario.equals("Check if admin is able to retrieve all Admins with filters")) {
	        userTest.Get_all_Users_with_Facets_Filters(); 
	    }	
		userTest.validateResponseFor_200_OK(response);
	}
		
//Check if admin is able to retreive Admins by valid role ID
	@Given("Admin creates GET Request with valid role ID for {string}")
	public void admin_creates_get_request_with_valid_role_id_for(String scenario) {
		if((scenario.equals("Check if admin is able to retreive Admins by valid role ID"))
		||(scenario.equals("Check if admin is able to retreive Admins by valid role ID with invalid endpoint"))){
			act_User.baseSetUp();
		}else if(scenario.equals("Check if admin is able to retreive Admins by valid role ID with no authorization")) {
			act_User.baseSetUpWithNoAuth();
		}
	}

//Check if admin is able to retrieve all Admins with filters	
	@Given("Admin creates GET Request to retrieve all users with filters")
	public void admin_creates_get_request_to_retrieve_all_users_with_filters() {
		act_User.baseSetUp();
	    
	}
	
//Check if admin is able to get the Admins by program batches for invalid batch ID
	@Given("Admin creates GET Request with invalid batchId")
	public void admin_creates_get_request_with_invalid_batch_id() {
		act_User.baseSetUp();
	}

	@Then("Admin receives status {int} with Not Found error message for {string}")
	public void admin_receives_status_with_not_found_error_message_for(Integer expectedStatusCode, String scenario) throws IOException {
		if(scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint")) {
			userTest.test_Get_User_By_Batch_ID(scenario);
			
		}else if(scenario.equals("Check if admin is able to get the Admins for valid program Id with invalid endpoint")) {
			userTest.test_Get_User_By_Program_ID(scenario);
		}else if(scenario.equals("Check if admin is able to retreive Admins by valid role ID with invalid endpoint")) {
			userTest.test_Get_User_By_Role_ID(scenario);
		}
		userTest.NotFoundErrorMessage(expectedStatusCode, scenario);
	    
	}
//No authorization
//Check if admin is able to get the Admins by program batches for valid batch ID with no authorization 
	@Given("Admin creates GET Request with valid batch Id for {string}")
	public void admin_creates_get_request_with_valid_batch_id_for(String scenario) {
		if(scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID")) {
			act_User.baseSetUp();
		}else if(scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with no authorization")) {
			act_User.baseSetUpWithNoAuth();
		}
	}

	@Then("Admin receives status {int} with Unauthorized message for {string}")
	public void admin_receives_status_with_unauthorized_message_for(Integer expectedStatusCode, String scenario) throws IOException {
		if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with no authorization")) {
			userTest.test_Get_User_By_Batch_ID(scenario);									
		}
		else if (scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization")) {
			userTest.test_Get_User_By_Program_ID(scenario);

		}
		else if (scenario.equals("Check if admin is able to retreive Admins by valid role ID with no authorization")) {
			userTest.test_Get_User_By_Role_ID(scenario);

		}
		userTest.UnAuthorized(expectedStatusCode, scenario);
	}
	
//Check if admin is able to get the Admins for valid program Id	
	@Given("Admin creates GET Request with valid program Id for {string}")
	public void admin_creates_get_request_with_valid_program_id_for(String scenario) {
		if ((scenario.equals("Check if admin is able to get the Admins for valid program Id"))
		||(scenario.equals("Check if admin is able to get the Admins for valid program Id with invalid endpoint"))){
			act_User.baseSetUp();									
		} else if (scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization")) {
			act_User.baseSetUpWithNoAuth();

		}
	}
//Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint		
	@When("Admin sends HTTPS Request with invalid endpoint for {string}")
	public void admin_sends_https_request_with_invalid_endpoint_for(String scenario) throws IOException {
		response = act_User.getRequestUser(scenario,batchId,programId,"roleId");
	}
//Check if admin is able to get the Admins for invalid program Id	
	@Given("Admin creates GET Request with invalid program Id")
	public void admin_creates_get_request_with_invalid_program_id() {
	    act_User.baseSetUp();
	}
//Check if admin is able to retreive Admins by invalid role ID	
	@Given("Admin creates GET Request for GET with invalid role ID")
	public void admin_creates_get_request_for_get_with_invalid_role_id() {
		act_User.baseSetUp();
	    
	}
	@Then("Admin receives {int} Not Found Status with message and boolean success details for {string}")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details_for(Integer expectedStatusCode, String scenario) throws IOException {
		if (scenario.equals("Check if admin is able to get the Admins by program batches for invalid batch ID")) {
			userTest.test_Get_User_By_Invalid_Batch_ID();									
		}else if (scenario.equals("Check if admin is able to get the Admins for invalid program Id")) {
			userTest.test_Get_User_By_Program_ID(scenario);;									
		}else if(scenario.equals("Check if admin is able to retreive Admins by invalid role ID")) {
			userTest.test_Get_User_By_Role_ID(scenario);
		}
		userTest.NotFoundBooleanSuccessMessage(expectedStatusCode, scenario);
	}
	
	@Given("Admin creates DELETE Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {
		act_User.baseSetUp();
	}
	

	
	@When("Admin send HTTPS Request with endpoint for {string}")
	public void admin_send_https_request_with_endpoint_for(String scenario) {
		if (scenario.equals("Check if admin able to delete a Batch with valid Batch ID")) {
			act_User.deleteAllBatches(scenario);
												
		}else if (scenario.equals("Check if Admin able to delete a program with valid program ID")) {
			act_User.deleteAllPrograms(scenario);									
		}
	}

	
	@Then("Admin receives {int} Ok status with message for {string}")
	public void admin_receives_ok_status_with_message_for(Integer int1, String scenario) {
		if (scenario.equals("Check if admin able to delete a Batch with valid Batch ID")) {
			userTest.Delete_all_Batches();
												
		}else if (scenario.equals("Check if Admin able to delete a program with valid program ID")) {
			userTest.Delete_all_Programs();									
		}
	}

	@Given("Admin creates DELETE Request with valid ProgramId")
	public void admin_creates_delete_request_with_valid_program_id() {
	    act_User.baseSetUp();
	}



}
