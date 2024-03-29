package com.lms.api.actions;

import static io.restassured.RestAssured.given;

import com.lms.api.endpoints.Routes;

import files.User_Login_Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_Login {
	public static Response createUser()
	{
		
		Response response = given()
				.baseUri(Routes.BASE_URL)				
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(User_Login_Payload.userLoginRequest())
				.when()
				.post(Routes.USERLOGIN_ENDPOINT);
		return response;
		
	}

}
