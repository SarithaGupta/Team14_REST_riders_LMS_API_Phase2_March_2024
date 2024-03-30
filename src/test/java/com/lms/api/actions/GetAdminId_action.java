package com.lms.api.actions;

import java.io.IOException;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAdminId_action {
	
	static ConfigReaderAndWriter configReaderObj;
	static RequestSpecification request;
	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;
	
	
	public static void baseSetUp() {
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		requestSpec = new RequestSpecBuilder();
		
		System.out.println(authToken);
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
	
	public static Response getAdminByAdminId() throws IOException
	{
	excelReader = new ExcelReader();
	Response response = request
										.when().log().all()
										.get(Routes.Get_Admin_By_Id + "U50");

//										.get(Routes.Get_Admin_By_Id +excelReader.readRequestBodyDetailsForUserModule().get("userId"));
	return response;		
	}
}
