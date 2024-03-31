package com.lms.api.actions;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Actions_User {

	private static RequestSpecification request;

	static Response response;
	static ConfigReaderAndWriter configReaderObj;

	public static void baseSetUp() {
		String authToken = configReaderObj.loadConfig().getProperty("Token");
		request = RestAssured.given().baseUri(Routes.BASE_URL).contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + authToken).log().all();
	}
	public Response getRequestUser(String scenario, int batchId, int programId) {
	    String endpoint = "";
	    if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID")) {
	        endpoint = Routes.Gets_User_by_Program_Batches + batchId;
	    } else if (scenario.equals("Check if admin is able to get the Admins for valid program Id")) {
	        endpoint = Routes.Gets_Users_for_Program  + programId;
	    }
	    return sendGetRequest(endpoint);
	}
	
	private static Response sendGetRequest(String endpoint) {

		Response response = request.when().log().all().get(endpoint);
		return response;
	}

}
