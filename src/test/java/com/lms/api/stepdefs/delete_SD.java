package com.lms.api.stepdefs;

import static io.restassured.RestAssured.given;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class delete_SD {
	
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	
	@Given("Admin creates DELETE Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {
	    

		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
	}

	@When("Admin sends DELETE HTTPS Request  with endpoint")
	public void admin_sends_delete_https_request_with_endpoint() {
		//static Class method
        String batchId = ConfigReaderAndWriter.loadConfig().getProperty("batchId");
       
       
		
	 // 	 int batchId = response.then().extract().path("batchId");
		response = request.when().log().all().delete(Routes.delete_url_EndPoint+batchId);
		
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
	    
		response.then().log().all().assertThat().statusCode(200)
        .extract().response().asString();	
		
	}


}
