package com.lms.api.stepdefs;

import static io.restassured.RestAssured.given;
import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;*/

public class GetBatch_SD {
	
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	
	@Given("User creates a GET request for valid endpoints")
	public void user_creates_a_get_request_for_valid_endpoints() {
		
		
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
		 
	      
 }

	@When("User sends GET request")
	public void user_sends_get_request() {
		
		
	response = request.when().log().all().get(Routes.getBatch_url_EndPoint);
		
	}

	@Then("User recieves {int} OK Status")
	public void user_recieves_ok_status(Integer int1) {
		
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
		
		
	}
	
	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {
		
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		//request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
	}
// duplicate coming
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
	    
		response = request.when().log().all().get(Routes.getBatch_url_InvalidEndPoint);
	}

	@Then("Admin receives {int} status with error message Not Found .")
	public void admin_receives_status_with_error_message_not_found(Integer int1) {
	    
		response.then().log().all().assertThat().statusCode(404)
        .extract().response().asString();
	}
	
	@Given("Admin creates GET Request with search string")
	public void admin_creates_get_request_with_search_string() {
	   
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		//request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
	   
		response = request.when().log().all().get(Routes.getBatch_url_EndPoint);
	}

	@Then("Admin receives {int} Ok status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
	    
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
	}
	
	@Given("Admin creates GET Request with valid Batch ID")
	public void admin_creates_get_request_with_valid_batch_id() {
	    
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
		
		
	}

	@When("Admin sends HTTPS Request with endpoint with Batch ID")
	public void admin_sends_https_request_with_endpoint_with_batch_id() {
	   
		String batchId = ConfigReaderAndWriter.loadConfig().getProperty("batchId");
		response = request.when().log().all().get(Routes.getBatch_batchId_url_EndPoint+batchId);

	}

	@Then("Admin receives {int} OK Status.")
	public void admin_receives_ok_status(Integer int1) {
	   
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
		
	}
	
	@Given("Admin creates GET Request with valid Batch Name")
	public void admin_creates_get_request_with_valid_batch_name() {
	    
		  
				String authToken = configReaderObj.loadConfig().getProperty("Token");
				requestSpec = new RequestSpecBuilder();
				requestSpec.setBaseUri(Routes.BASE_URL);
				requestSpec.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer " + authToken);
				request = RestAssured.given().spec(requestSpec.build());
				 request = given().spec(request);
		
	}

	@When("Admin sends HTTPS Request with endpoint with Batch Name")
	public void admin_sends_https_request_with_endpoint_with_batch_name() {
	    
		String batchName = ConfigReaderAndWriter.loadConfig().getProperty("batchName");
		response = request.when().log().all().get(Routes.getBatch_batchName_url_EndPoint+batchName);
	}

	@Then("Admin receives {int} OK Status for this.")
	public void admin_receives_ok_status_for_this(Integer int1) {
	   
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
	}

	@Given("Admin creates GET Request with valid Program Id")
	public void admin_creates_get_request_with_valid_program_id() {
	  

		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
		
		
	}

	@When("Admin sends HTTPS Request with endpoint with Program Id")
	public void admin_sends_https_request_with_endpoint_with_program_id() {
		
		int programId = 16347;
		//String batchName = ConfigReaderAndWriter.loadConfig().getProperty("batchName");
		response = request.when().log().all().get(Routes.getBatch_programId_url_EndPoint+programId); 

	}
	
	@Then("Admin receives {int} OK Status for this code.")
	public void admin_receives_ok_status_for_this_code(Integer int1) {
	    
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();	
		
	}

	
		
}
