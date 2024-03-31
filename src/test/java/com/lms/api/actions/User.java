package com.lms.api.actions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.BeforeClass;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User {
	static ConfigReaderAndWriter configReaderObj;
	static RequestSpecification request;
	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;
	//Actions_User_Saritha action_user = new Actions_User_Saritha();
	
	
	public static void baseSetUpWithNoAuth() {
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	
	public static Response HttpRequest(String endpoint) {
		Response response = request.when().log().all().get(endpoint);
		
		return response;
	}
	public static Response getUserForInvalidBatchId() throws IOException
	{
		excelReader = new ExcelReader();
		
		Response response = request
				.when().log().all()
				.get(Routes.Gets_User_by_Program_Batches +excelReader.readRequestBodyDetailsForUserModule().get("invalidBatchId"));
		return response;		
	}
	public static Response getUserForValidBatchIdWithInvalidEndPoint()
	{		
		Response response = request
				.when().log().all()
				.get(Routes.INVALID_ENDPOINT +8455);
		return response;		
	}
//5.Scenario	
	public static Response getUserForValidProgramId()
	{		
		Response response = request
				.when().log().all()
				.get(Routes.Gets_Users_for_Program +16807);
		return response;		
	}
	public static Response getUserForInvalidProgramId() throws IOException
	{		
		Response response = request
				.when().log().all()
				.get(Routes.Gets_Users_for_Program +excelReader.readRequestBodyDetailsForUserModule().get("invalidProgramId"));
		return response;		
	}

}
