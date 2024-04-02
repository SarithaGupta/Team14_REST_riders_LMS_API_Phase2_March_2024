package com.lms.api.stepdefs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Update_Batch_SD {
	
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	
	@Given("Admin creates PUT Request with valid BatchId and Data")
	public void admin_creates_put_request_with_valid_batch_id_and_data() {

		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		
		 
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
	    

	}

	@When("Admin sends PUT HTTPS Request  with endpoint")
	public void admin_sends_put_https_request_with_endpoint() throws IOException {
		
		String batchId = ConfigReaderAndWriter.loadConfig().getProperty("batchId");
	       //System.out.println(" Batch Id # " + batchId);
        //response = request.get("/batches/" + batchId);
		
		ExcelReader excelReader = new ExcelReader();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        ConfigReaderAndWriter configReader = new ConfigReaderAndWriter();
        
		dataBody.put("batchDescription", ExcelReader.readRequestBodyDetailsForBatchModule().get("Updated_batchDescription"));
        dataBody.put("batchName", ExcelReader.readRequestBodyDetailsForBatchModule().get("Updated_batchName"));
        
        String noOfBatch = ExcelReader.readRequestBodyDetailsForBatchModule().get("batchNoOfClasses");
        double d = Double.parseDouble(noOfBatch);
        int noOfBatchInt = (int) d;
        
        dataBody.put("batchNoOfClasses", noOfBatchInt);
        dataBody.put("batchStatus", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchStatus"));
        
        String prgramIdStr = ExcelReader.readRequestBodyDetailsForBatchModule()
        		.get("programId");
        double d1= Double.parseDouble(prgramIdStr);
        int prgramIdStrInt = (int) d1;
        
        dataBody.put("programId", prgramIdStrInt);
        
        System.out.println("DATA Body # " + dataBody);
        System.out.println(" Routes.post_url_EndPoint # request " + request);
        
              response = request.when().
            		  body(dataBody).put(Routes.put_url_EndPoint+batchId);
              
              System.out.println(" Response Body # " + response.body());
              response.body().print();
	    
	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		
		 response.then().log().all().assertThat().statusCode(200)
         .extract().response().asString();
	    
	}
}