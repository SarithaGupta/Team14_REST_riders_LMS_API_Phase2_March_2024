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
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Create_New_Batch_DS {
	
	RequestSpecification request;
	RequestSpecBuilder requestSpec;
	Response response;
	ConfigReaderAndWriter configReaderObj;
	//ValidatableResponse validatableResponse;
	//JsonString jsonString;
	
	@Given("Admin creates POST Request  with valid data in request body")
	
	public void admin_creates_post_request_with_valid_data_in_request_body() {
		
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		
		 
		request = RestAssured.given().spec(requestSpec.build());
		 request = given().spec(request);
		 
		 
	}

	@When("Admin sends POST HTTPS Request with endpoint")
	public void admin_sends_post_https_request_with_endpoint() throws IOException {
		 
	//	ConfigReaderAndWriter excelReaderAndWriter = new ExcelReaderAndWriter();
		
		ExcelReader excelReader = new ExcelReader();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        ConfigReaderAndWriter configReader = new ConfigReaderAndWriter();
        
		dataBody.put("batchDescription", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchDescription"));
        dataBody.put("batchName", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchName"));
        
        String noOfBatch = ExcelReader.readRequestBodyDetailsForBatchModule().get("batchNoOfClasses");
        double d = Double.parseDouble(noOfBatch);
        int noOfBatchInt = (int) d;
        
        dataBody.put("batchNoOfClasses", noOfBatchInt);
        dataBody.put("batchStatus", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchStatus"));
        
        String prgramIdStr = ExcelReader.readRequestBodyDetailsForBatchModule().get("programId");
        double d1= Double.parseDouble(prgramIdStr);
        int prgramIdStrInt = (int) d1;
        
        dataBody.put("programId", prgramIdStrInt);

        
        //dataBody.put("programId",configReader.loadConfig().getProperty("programId"));
        // dataBody.put("programId", configReader.loadConfig().getProperty("programId"));
        
        try {
        	System.out.println("DATA Body # " + dataBody);
      //  	System.out.println(" Routes.post_url_EndPoint # request " + request);
            response = request.when().body(dataBody).post(Routes.post_url_EndPoint);
            System.out.println(" Response Body # " + response.body());
            response.body().print();
          //  validatableResponse = response.then().log().all();
		} catch (Exception e) {
			e.printStackTrace();
		}
       // jsonString = response.asString();
	    
	}

	@Then("Admin receives \\{int} Created Status with response body of batch")
	public void admin_receives_created_status_with_response_body_of_batch() throws IOException {
		
		 response.then().log().all().assertThat().statusCode(201)
         .extract().response().asString();

		//Storing batchId and batchName in config properties file
    	 int batchId = response.then().extract().path("batchId");
    	 String batchName = response.then().extract().path("batchName");
    	
    		 ConfigReaderAndWriter.storeConfig("batchId", String.valueOf(batchId));
    		 ConfigReaderAndWriter.storeConfig("batchName", batchName);
    	 

    	 }
		
    	 @Given("Admin creates POST Request with invalid data in request body")
    	 public void admin_creates_post_request_with_invalid_data_in_request_body() {
    	     
    		 String authToken = configReaderObj.loadConfig().getProperty("Token");
    			requestSpec = new RequestSpecBuilder();
    			requestSpec.setBaseUri(Routes.BASE_URL);
    			requestSpec.setContentType(ContentType.JSON)
    			.addHeader("Authorization", "Bearer " + authToken);
    			
    			 
    			request = RestAssured.given().spec(requestSpec.build());
    			 request = given().spec(request);
    			 
    		  }

    	 @When("Sends HTTPS Request with endpoint")
    	 public void sends_https_request_with_endpoint() throws IOException {
    	     
    		 ExcelReader excelReader = new ExcelReader();
    	        HashMap<String, Object> dataBody = new HashMap<String, Object>();
    	        ConfigReaderAndWriter configReader = new ConfigReaderAndWriter();
    	        
    			dataBody.put("batchDescription", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchDescription"));
    	        dataBody.put("batchName", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchName"));
    	        
    	        String noOfBatch = ExcelReader.readRequestBodyDetailsForBatchModule().get("batchNoOfClasses");
    	        double d = Double.parseDouble(noOfBatch);
    	        int noOfBatchInt = (int) d;
    	        
    	        dataBody.put("batchNoOfClasses", noOfBatchInt);
    	        dataBody.put("batchStatus", ExcelReader.readRequestBodyDetailsForBatchModule().get("batchStatus"));
    	        
    	        String prgramIdStr = ExcelReader.readRequestBodyDetailsForBatchModule().get("programId");
    	        double d1= Double.parseDouble(prgramIdStr);
    	        int prgramIdStrInt = (int) d1;
    	        
    	        dataBody.put("programId", prgramIdStrInt); 
    	        
    	        System.out.println("DATA Body # " + dataBody);
            	//System.out.println(" Routes.post_url_EndPoint # request " + request);
                response = request.when().body(dataBody).post(Routes.post_url_EndPoint);
                System.out.println(" Response Body # " + response.body());
                response.body().print();
    		 
    	 }

    	 @Then("Admin receives {int} Bad Request Status with message and boolean success details")
    	 public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) throws IOException {
    		 
    		 response.then().log().all().assertThat().statusCode(400)
             .extract().response().asString();
    		 
    		 int batchId = response.then().extract().path("batchId");
        	 String batchName = response.then().extract().path("batchName");
        	
        		 try {
					ConfigReaderAndWriter.storeConfig("batchId", String.valueOf(batchId));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 ConfigReaderAndWriter.storeConfig("batchName", batchName);
        	
    		 
  }

     }



