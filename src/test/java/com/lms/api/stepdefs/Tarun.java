package com.lms.api.stepdefs;

	import java.io.IOException;
	import com.lms.api.actions.GetAdminId_action;
	import com.lms.api.actions.User;
	import com.lms.api.endpoints.Routes;
	import com.lms.api.test.GetAdminId;
	import com.lms.api.test.UserTests;
	import files.User_Login_Payload;
	import io.cucumber.java.en.*;
	import io.restassured.RestAssured;
	import io.restassured.builder.RequestSpecBuilder;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

		

	  

public class Tarun {
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	GetAdminId_action adminId=new GetAdminId_action();
	GetAdminId getTest=new GetAdminId();
	
		@Given("Admin creates GET Request with valid AdminId")
		public void admin_creates_get_request_with_valid_admin_id() throws IOException {
			
   GetAdminId_action.baseSetUp();;	
   System.out.println("Test It");
		}

		@When("Admin sends HTTPS Request with valid endpoint")
		public void admin_sends_https_request_with_valid_endpoint() throws IOException {
	GetAdminId_action.getAdminByAdminId();
			System.out.println("Test It1");
		}

		@Then("Admin receives {int} OK Status with response body")
		public void admin_receives_ok_status_with_response_body(Integer int1) throws IOException {
			getTest.test_Get_Admin_By_AdminId();
			System.out.println("Test It2");
		}
		
		@Given("Admin creates GET Request with valid AdminId nad no auth")
		public void admin_creates_get_request_with_valid_admin_id_nad_no_auth() {
		  
			System.out.println("Test It3");
		}
	}

