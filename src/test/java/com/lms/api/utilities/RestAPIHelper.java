package com.lms.api.utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAPIHelper {
	public static RequestSpecification getBasicAuth() {
		return RestAssured.given().auth().basic("numpyninja@gmail.com", "lmsHackathon@2024");
	}

}
