package com.lms.api.actions;

import java.io.IOException;

import com.lms.api.endpoints.Routes;

import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;
import com.lms.api.utilities.ExcelReader1;

import files.Program_Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDelete_Program {
	static ConfigReaderAndWriter configReaderObj;
	static RequestSpecification request;
	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;
	static Program_Payload data=new Program_Payload();
	
	//with authorization1=url+basepoint
	public static void baseSetUp() {
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder()
		.setBaseUri(Routes.BASE_URL)
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + authToken);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	public static void baseSetUpWithNoAuth() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Routes.BASE_URL)
				.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	public static void baseSetUpWithInvalidUrl() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Routes.INVALID_BASE_URL)
				.setContentType(ContentType.JSON);
		request = RestAssured.given().spec(requestSpec.build()).log().all();
		
	}
	
	
	
	
	public static Response getresponse_validendpoint()
	{
			
			Response response = request
					.when().log().all()
					.get(Routes.GET_ALL_PROGRAMS_ENDPOINT);
			return response;
	}
	
	public static Response getresponse_invalidendpoint()
	{
			
			Response response = request
					.when().log().all()
					.get(Routes.GET_ALL_PROGRAMS_INVALID_ENDPOINT);
			return response;
	}
	public static Response getresponse_valid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		String programid=configReaderObj.loadConfig().getProperty("programId");
		Response response = request
				.when().log().all()
				.get(Routes.GET_PROGRAM_BY_PROGRAMID + programid);
		
		
		return response;		
	}
	public static Response getresponse_invalid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		Response response = request
				.when().log().all()
				.get(Routes.GET_PROGRAM_BY_PROGRAMID + excelreader.readRequestBodyDetailsForUserModule().get("InvalidId"));
		
		/*Response response = request
				.when().log().all()
				.get(Routes.GET_PROGRAM_BY_PROGRAMID+);*/
		return response;		
			
		
	}
	public static Response getresponse_invalidendpoint_programId()
	{
			
			Response response = request
					.when().log().all()
					.get(Routes.INVALID_GET_PROGRAM_BY_PROGRAMID);
			return response;
	}
	public static Response deleteresponse_valid_programName() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		String programName=configReaderObj.loadConfig().getProperty("programName");
		Response response = request
				.when().log().all()
				.delete(Routes.DELETE_PROGRAM_BY_PROGRAMNAME + programName);
		
		
		return response;		
	}
	public static Response deleteresponse_invalid_programName() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		Response response = request
				.when().log().all()
				.delete(Routes.DELETE_PROGRAM_BY_PROGRAMNAME + excelreader.readRequestBodyDetailsForUserModule().get("InvalidName"));
		
		/*Response response = request
				.when().log().all()
				.get(Routes.GET_PROGRAM_BY_PROGRAMID+);*/
		return response;		
	
	}
	public static Response deleteresponse_valid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		String programId=configReaderObj.loadConfig().getProperty("programId");
		Response response = request
				.when().log().all()
				.delete(Routes.DELETE_PROGRAM_BY_PROGRAMID + programId);
		
		
		return response;		
	}
	public static Response deleteresponse_invalid_programId() throws IOException
	{
		ExcelReader excelreader=new ExcelReader();
		Response response = request
				.when().log().all()
				.delete(Routes.DELETE_PROGRAM_BY_PROGRAMID + excelreader.readRequestBodyDetailsForUserModule().get("invalidProgramId"));
		
		/*Response response = request
				.when().log().all()
				.get(Routes.GET_PROGRAM_BY_PROGRAMID+);*/
		return response;		
	
	}
	
	

}
