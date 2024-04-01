package com.lms.api.stepdefs;

	import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.api.actions.GetAdminId_action;
import com.lms.api.actions.User;
import com.lms.api.endpoints.Routes;
import com.lms.api.test.GetAdminId;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import com.lms.api.endpoints.Routes;

public class GetByAdminId_Stepdefs {
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	GetAdminId_action adminId=new GetAdminId_action();
	GetAdminId getTest=new GetAdminId();
	Routes route=new Routes();
	
	
		@Given("Admin creates GET Request with valid AdminId")
		public void admin_creates_get_request_with_valid_admin_id() throws IOException {
			User.baseSetUp();	
		}

		@When("Admin sends HTTPS Request with valid endpoint")
		public void admin_sends_https_request_with_valid_endpoint() throws IOException {
			//
			GetAdminId_action.getAdminByAdminIdAndvalidAdminId();
		}

		@Then("Admin receives {int} OK Status with response body")
		public void admin_receives_ok_status_with_response_body(Integer int1) throws IOException {
			getTest.test_Get_Admin_By_AdminId();
		}
		
		@Given("Admin creates GET Request with invalid AdminId")
		public void admin_creates_get_request_with_invalid_admin_id() throws IOException {
			User.baseSetUp();	
		}

		@When("Admin sends HTTPS Request with valid endpoint for invalid AdminId")
		public void admin_sends_https_request_with_valid_endpoint_for_invalid_admin_id () throws IOException {
			GetAdminId_action.getAdminByAdminIdAndInvalidAdminId();
		}
//		@Then("Admin receives {int} OK Status with response body")
//		public void admin_receives_oK_status_with_response_body(Integer int1) throws IOException {
//			getTest.test_Get_Admin_By_AdminId();
//			
//		}
		
//		@Given("Admin creates GET Request with valid AdminId and no auth")
//		public void admin_creates_get_request_with_valid_admin_id_and_no_auth() {
		  
			
		@Given("Admin creates PUT Request with valid request body")
		public void admin_creates_put_request_with_valid_request_body() throws JsonProcessingException {
			
			User.baseSetUp();	
		}

		@When("Admin sends HTTPS Put Request with endpoint")
		public void admin_sends_https_put_request_with_endpoint() throws JsonProcessingException {
		
			GetAdminId_action.UserUpdateByUserId() ;
		}
		
		@Given("Admin creates PUT Request with invalid request body")
		public void admin_creates_put_request_with_invalid_request_body() throws JsonProcessingException {
			GetAdminId_action.updateRoleIdofAdminWithInvalidRequestBody();
		}

		@Then("Admin receives {int} Bad Request Status with message and boolean success details")
		public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) throws IOException {
			
			getTest.test_Get_Admin_By_AdminId();
		}
		@When("Admin sends HTTPS put Request with invalid endpoint")
		public void admin_sends_https_put_request_with_invalid_endpoint() throws JsonProcessingException {
			    
				GetAdminId_action.updateRoleIdofAdminWithInvalidEndPoint();	
		}

		@Then("Admin receives {int} Not Found Status with message and boolean success details")
		public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) throws IOException {
			  
				getTest.test_Get_Admin_By_AdminId();
		}
		@When("Admin sends HTTPS put Request with endpoint with userId")
		public void admin_sends_https_put_request_with_endpoint_with_userId() throws JsonProcessingException {
			
			GetAdminId_action.updateRoleStatusOfAdminWithValidAdminId();
		
		}
		@Then("Admin receives {int} Ok Status with response message")
		public void admin_receives_ok_status_with_response_message(Integer int1) throws IOException {
			
			getTest.test_Get_Admin_By_AdminId();
		}
		
		@When("Admin sends HTTPS put Request with endpoint with Invalid userId")
		public void admin_sends_https_put_request_with_endpoint_with_invalid_user_id() throws JsonProcessingException {
			GetAdminId_action.updateRoleStatusOfAdminWithInValidAdminId();
		 }
		
		@Then("Admin receives {int} Not Found Status with response message")
		public void admin_receives_not_found_status_with_response_message(Integer int1) throws IOException {

			getTest.test_Get_Admin_By_AdminId();
		}
		
		@When("Admin sends HTTPS put Request with endpoint and valid Admin Id")
		public void admin_sends_https_put_request_with_endpoint_and_valid_admin_id() throws JsonProcessingException {
			GetAdminId_action.updateRoleIdByUserId();
			
		}
		@When("Admin sends HTTPS put Request with endpoint with userId to update role program batch")
		public void admin_sends_https_put_request_with_endpoint_with_user_id_to_update_role_program_batch() throws JsonProcessingException {
			GetAdminId_action.updateUserRoleProgramBatchByUserId();
			
		}
		
		@Given("Admin creates DELETE Request to delete Admin details")
		public void admin_creates_delete_request_to_delete_admin_details() {
			GetAdminId_action.deleteUser();
		}

		@When("Admin sends HTTPS request with endpoint to delete user with user Id")
		public void admin_sends_https_request_with_endpoint_to_delete_user_with_user_id() throws IOException {
	
			getTest.test_Get_Admin_By_AdminId();
		}
}

