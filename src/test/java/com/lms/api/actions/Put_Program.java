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

public class Put_Program {
	static ConfigReaderAndWriter configReaderObj;
	static RequestSpecification request;
	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;
	static Program_Payload data=new Program_Payload();
	public static void put_program_baseSetUp() throws IOException
	{
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder()
		.setBaseUri(Routes.BASE_URL)
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).body(data.put_program()).log().all();
		
	}
	public static void baseSetUpWithinvalidURI() throws IOException
	{
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder()
		.setBaseUri(Routes.INVALID_BASE_URL)
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).body(data.put_program()).log().all();
		
	}
	public static void baseSetUpWithNoAuth() throws IOException {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Routes.BASE_URL)
				.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).body(data.put_program()).log().all();
		
	}
	
	public static void baseSetUpWithNoBody() throws IOException {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Routes.BASE_URL)
				.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	public static Response putResponse_valid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		String programid=configReaderObj.loadConfig().getProperty("programId");
		Response response = request
				.when().log().all()
				.put(Routes.PUT_PROGRAM_BY_PROGRAMID + programid);
		return response;		
	}
	
	public static Response putResponse_invalid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		String programid=configReaderObj.loadConfig().getProperty("programId");
		Response response = request
				.when().log().all()
				.put(Routes.PUT_PROGRAM_BY_PROGRAMID +  excelreader.readRequestBodyDetailsForUserModule().get("invalidProgramId"));
		return response;		
	}
	
	public static Response putResponse_valid_programName() throws IOException
	{
		//ExcelReader excelreader=new ExcelReader();
		String programName=configReaderObj.loadConfig().getProperty("programName");
		Response response = request
				.when().log().all()
				.put(Routes.PUT_PROGRAM_BY_PROGRAMNAME + programName);
		return response;		
	}
	
	public static Response putResponse_invalid_programName() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		//String programName=configReaderObj.loadConfig().getProperty("programName");
		Response response = request
				.when().log().all()
				.put(Routes.PUT_PROGRAM_BY_PROGRAMNAME+  excelreader.readRequestBodyDetailsForUserModule().get("InvalidName"));
		return response;		
	}
}
