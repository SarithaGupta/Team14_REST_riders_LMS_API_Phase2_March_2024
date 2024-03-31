package com.lms.api.test;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.lms.api.actions.Actions_User;
import com.lms.api.actions.User;

import io.restassured.response.Response;

public class UserTests {
	Response response;
	Actions_User act_User = new Actions_User();

	public void test_Get_User_By_Batch_ID() {
		int batchId = 8455;
		int programId = 0; // Program ID not needed for this scenario
		response = act_User.getRequestUser(
				"Check if admin is able to get the Admins by program batches for valid batch ID", batchId, programId);
		response.then().log().all();
		// Add assertions specific to this scenario
	}

	public void test_Get_User_By_Program_ID() {
		int batchId = 0; // Batch ID not needed for this scenario
		int programId = 16807;
		response = act_User.getRequestUser("Check if admin is able to get the Admins for valid program Id", batchId,
				programId);
		response.then().log().all();
		// Add assertions specific to this scenario
	}

	public void test_Get_User() {
		int batchId = 8455;
		int programId = 16807;
		response = act_User.getRequestUser(
				"Check if admin is able to get the Admins by program batches for valid batch ID", batchId, programId);
		response.then().log().all();
		// calculateResponseTime();
		// response.then().assertThat().body("error", Matchers.is("Unauthorized"));

	}

	public void calculateResponseTime() {
		response.then().time(Matchers.lessThan(1000L));
		//response.then().time(Matchers.both(Matchers.greaterThan(100L)).and(Matchers.lessThan(400L)));

	}

}
