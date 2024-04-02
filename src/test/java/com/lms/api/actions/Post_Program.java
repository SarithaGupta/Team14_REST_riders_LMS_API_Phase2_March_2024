package com.lms.api.actions;

import java.io.IOException;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import files.Program_Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Program {
	static ConfigReaderAndWriter configReaderObj;
	static RequestSpecification request;
	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;
	
	static Program_Payload data=new files.Program_Payload();
	public static void add_program_baseSetUp() throws IOException
	{
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder()
		.setBaseUri(Routes.BASE_URL)
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).body(data.add_Program()).log().all();
		
	}
	public static void baseSetUpWithNoAuth() throws IOException {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Routes.BASE_URL)
				.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).body(data.add_Program()).log().all();
		
	}
	public static void invalidbody_add_program_baseSetUp() throws IOException
	{
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder()
		.setBaseUri(Routes.BASE_URL)
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).body("\r\n"
				+ "\"programNam\": \"mtrain\",\r\n"
				+ "\"programDescription\": \"NewLarning\",\r\n"
				+ "\"programStatus\": \"Active\"").log().all();
		
	}
	
	public static Response getresponse_addProgram_endpoint()
	{
		Response response=request.when().log().all().post(Routes.ADD_PROGRAM_ENDPOINT);
		return response;
	}
	public static Response getresponse_addProgram_invalidendpoint()
	{
		Response response=request.when().log().all().post(Routes.INVALID_ADD_PROGRAM_ENDPOINT);
		return response;
	}
	
	

}
