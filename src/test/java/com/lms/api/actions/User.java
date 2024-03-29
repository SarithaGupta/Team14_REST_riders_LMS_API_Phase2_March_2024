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
	
	
	public static void baseSetUp() {
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	public static void baseSetUpWithNoAuth() {
		requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri(Routes.BASE_URL);
		requestSpec.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	public static Response getUserForValidBatchId()
	{
		
		Response response = request
				.when().log().all()
				.get(Routes.Gets_User_by_Program_Batches +8455);
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

}
