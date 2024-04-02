package com.lms.api.test;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;

import com.lms.api.actions.Actions_LMS;
import com.lms.api.actions.Actions_User;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import io.restassured.response.Response;

public class Tests_LMS {
	private Response response;
	private Actions_LMS act_User = new Actions_LMS();
	String programName;
	String batchName;
	int userPhoneNumber;
	String userLoginEmail;
	int batchId;
	int programId;
	String roleId;
	ExcelReader excelReader = new ExcelReader();

	public void test_Post_With_Mandatory_Fields(String scenario) throws IOException {
		if (scenario.equals(
				"Check if Admin able to create a program with valid endpoint and request body with Authorization")) {
			response = act_User.createProgram(scenario);
			extractAndStoreProgramDetails(response);
			//Data validation
			response.then().assertThat().body("programName", Matchers.is(programName));

		} else if (scenario.equals(
				"Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields")) {

			response = act_User.createUser(scenario);

			extractAndStoreUserDetails(response);
			//Data validation
			response.then().assertThat().body("userPhoneNumber", Matchers.is(userPhoneNumber));
			response.then().assertThat().body("userLoginEmail", Matchers.is(userLoginEmail));

		} else if (scenario.equals(
				"Check if admin able to create a Batch with valid endpoint and request body (non existing values)")) {
			response = act_User.createBatch(scenario);
			extractAndStoreBatchDetails(response);
			
			//Data validation
			response.then().assertThat().body("batchName", Matchers.is(batchName));
		}
		response.then().log().all().extract().response();
		validateResponse_For_201_Created(response);

	}

	private void extractAndStoreProgramDetails(Response response) throws IOException {
		System.out.println("Response body: " + response.getBody().asString());

		Integer programId = response.then().extract().path("programId");
		if (programId == null) {
			// If programId is null, handle the error or throw an exception
			String errorMessage = response.then().extract().path("message");
			throw new RuntimeException("Failed to create program: " + errorMessage);
		}

		// If programId is not null, proceed with storing the details
		programName = response.then().extract().path("programName");
		ConfigReaderAndWriter.storeConfig("programId", String.valueOf(programId));
		ConfigReaderAndWriter.storeConfig("programName", programName);
	}

	private void extractAndStoreBatchDetails(Response response) throws IOException {
		Integer batch_Id = response.then().extract().path("batchId");
		if (batch_Id != null) {
			batchName = response.then().extract().path("batchName");
			ConfigReaderAndWriter.storeConfig("batchId", String.valueOf(batch_Id));
		} else {

			throw new NullPointerException("Batch ID is null in the response.");
		}
	}

	private void extractAndStoreUserDetails(Response response) throws IOException {
		String userId = response.then().extract().path("userId");
		if (userId == null) {
			String errorMessage = response.then().extract().path("message");
			throw new RuntimeException("Failed to create user: " + errorMessage);
		}
		userPhoneNumber = response.then().extract().path("userPhoneNumber");
		userLoginEmail = response.then().extract().path("userLoginEmail");
		/*
		 * try { if (roleId.equals("R01")) {
		 * ConfigReaderAndWriter.storeConfig("AdminId", userId); } else if
		 * (roleId.equals("R02")) { ConfigReaderAndWriter.storeConfig("StaffId",
		 * userId); } else if (roleId.equals("R03")) {
		 * ConfigReaderAndWriter.storeConfig("StudentId", userId); }
		 * 
		 * } catch (IOException E) {
		 * 
		 * }
		 */

	}

	public void test_Get_User_By_Batch_ID(String scenario) throws IOException {
		int batchId = Integer.parseInt(excelReader.readRequestBodyDetailsForUserModule().get("validBatchId_User"));
		System.out.println("Batch Id Value----------->" + batchId);
		// int programId = 0; // Program ID not needed for this scenario
		if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID")
				|| scenario.equals(
						"Check if admin is able to get the Admins by program batches for valid batch ID with no authorization")
				|| scenario.equals(
						"Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint")) {
			response = act_User.getRequestUser(scenario, batchId, programId, "roleId");
			response.then().log().all().extract().response();
			// validateResponseFor_200_OK(response);
		}
	}

	public void test_Get_User_By_Program_ID(String scenario) throws IOException {
		int programId = Integer.parseInt(excelReader.readRequestBodyDetailsForUserModule().get("validProgId_User"));
		System.out.println("Program id value for User--------->" + programId);
		if (scenario.equals("Check if admin is able to get the Admins for valid program Id")
				|| scenario
						.equals("Check if admin is able to get the Admins for valid program Id without authorization")
				|| scenario.equals("Check if admin is able to get the Admins for invalid program Id")
				|| scenario.equals(
						"Check if admin is able to get the Admins for valid program Id with invalid endpoint")) {
			response = act_User.getRequestUser(scenario, batchId, programId, "roleId");
			response.then().log().all().extract().response();

		}
	}

	public void test_Get_User_By_Role_ID(String scenario) throws IOException {
		String roleId = excelReader.readRequestBodyDetailsForUserModule().get("RoleId");
		if (scenario.equals("Check if admin is able to retreive Admins by valid role ID")
				|| scenario.equals("Check if admin is able to retreive Admins by invalid role ID")
				|| scenario.equals("Check if admin is able to retreive Admins by valid role ID with no authorization")
				|| scenario
						.equals("Check if admin is able to retreive Admins by valid role ID with invalid endpoint")) {
			response = act_User.getRequestUser(scenario, 0, 0, roleId);
			response.then().log().all().extract().response();

		}
	}

	public void Get_all_Users_with_Facets_Filters() {
		response = act_User.gatAllUsers("Check if admin is able to retrieve all Admins with filters");
		response.then().log().all();
		validateResponseFor_200_OK(response);
	}

	public void Delete_all_Batches() {
		response = act_User.deleteAllBatches("Check if admin able to delete a Batch with valid Batch ID");
		response.then().log().all();
		validateResponseFor_200_OK(response);
	}

	public void Delete_all_Programs() {
		response = act_User.deleteAllPrograms("Check if Admin able to delete a program with valid program ID");
		response.then().log().all();
		validateResponseFor_200_OK(response);
	}

	public void test_Get_User_By_Invalid_Batch_ID() throws IOException {

		response = act_User.getRequestUser(
				"Check if admin is able to get the Admins by program batches for invalid batch ID", batchId, programId,
				"roleId");
		response.then().log().all();
	}

	private void validateResponse_For_201_Created(Response response) {
		// Validate status code
		Assert.assertEquals(201, response.getStatusCode());

		// Validate status line
		System.out.println("Actual Status Line: " + response.getStatusLine());
		Assert.assertTrue(response.getStatusLine().contains("HTTP/1.1 201"));

		// Validate response time if needed
		Assert.assertTrue(response.getTime() < 2000);
		//Content type validation
        response.then().assertThat().contentType("application/json"); 

	}

	public void validateResponseFor_200_OK(Response response) {
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("HTTP/1.1 200 ", response.getStatusLine());
		// Assert.assertTrue(response.getStatusLine().contains("200 OK"));
		response.then().time(Matchers.lessThan(1000L));
		// Content type validation
		response.then().assertThat().contentType("application/json");
	}

	public void NotFoundErrorMessage(int expectedStatusCode, String scenario) {
		expectedStatusCode = 404;
		Assert.assertEquals(expectedStatusCode, response.getStatusCode());

		// Validate error message
		Assert.assertTrue(response.getBody().asString().contains("Not Found"));
		response.then().time(Matchers.lessThan(1000L));
		// Content type validation
		response.then().assertThat().contentType("application/json");
	}
	public void NotFoundBooleanSuccessMessage(int expectedStatusCode, String scenario) {
		// Validate status code 404 Not Found
		expectedStatusCode = 404;
		Assert.assertEquals(expectedStatusCode, response.getStatusCode());

		response.then().assertThat().body("success", Matchers.is(false));
		response.then().time(Matchers.lessThan(1000L));
		// Content type validation
		response.then().assertThat().contentType("application/json");
	}

	public void UnAuthorized(int expectedStatusCode, String scenario) {
		expectedStatusCode = 401;
		Assert.assertEquals(expectedStatusCode, response.getStatusCode());

		// Validate error message
		Assert.assertTrue(response.getBody().asString().contains("Unauthorized"));
		response.then().time(Matchers.lessThan(1000L));

		// Content type validation
		response.then().assertThat().contentType("application/json");
	}
}
