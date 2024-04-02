package com.lms.api.stepdefs;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.lms.api.actions.Post_Program;
import com.lms.api.actions.Put_Program;
import com.lms.api.actions.GetDelete_Program;
import com.lms.api.test.ProgramTest;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ReusableMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class Program_Module_stepdefs {
	Response response;
	ProgramTest programtest = new ProgramTest();
	ReusableMethods rs = new ReusableMethods();
	String programId;
	String programName;

	// Scenario1
	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws IOException {
		Post_Program.add_program_baseSetUp();

	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		// Write code here that turns the phrase above into concrete actions
		response = Post_Program.getresponse_addProgram_endpoint();

	}

	@Then("Admin receives {int} Created Status with response")
	public void admin_receives_created_status_with_response(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		{
			response.then().log().all();
			assertEquals(response.getStatusCode(), 201);
			// Storing batchId and batchName in config properties file
			programId = rs.getJsonPath(response, "programId");

			programName = rs.getJsonPath(response, "programName");
			try {
				ConfigReaderAndWriter.storeConfig("programId", programId);
				ConfigReaderAndWriter.storeConfig("programName", programName);
			} catch (IOException E) {
			}
		}

	}

	// Scenario2
	@Given("Admin creates POST Request for the LMS with request body with no authorization")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_no_authorization() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Post_Program.baseSetUpWithNoAuth();
	}

	@Then("Admin receives {int} Unauthorized status")
	public void admin_receives_unauthorized_status(Integer int1) {
		response = Post_Program.getresponse_addProgram_endpoint();
		assertEquals(response.getStatusCode(), 401);
	}

//scenario3
	@When("Admin sends HTTPS Request and  request Body with invalid endpoint")
	public void admin_sends_https_request_and_request_body_with_invalid_endpoint() {
		// Write code here that turns the phrase above into concrete actions
		response = Post_Program.getresponse_addProgram_invalidendpoint();
	}

	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(response.getStatusCode(), 404);

	}
	// scenario4

	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {

		response = Post_Program.getresponse_addProgram_endpoint();
		assertEquals(response.getStatusCode(), 400);

	}

	// scenario5

	@Given("Admin creates POST Request for the LMS with invalid request body")
	public void admin_creates_post_request_for_the_lms_with_invalid_request_body() throws IOException {

		Post_Program.invalidbody_add_program_baseSetUp();
	}

	@When("Admin send HTTPS Request and request Body with endpoint")
	public void admin_send_https_request_and_request_body_with_endpoint() {
		response = Post_Program.getresponse_addProgram_endpoint();
	}

	@Then("Admin receives {int} Bad Request Status")
	public void admin_receives_bad_request_status(Integer int1) {

		// response.then().log().all();
		assertEquals(response.getStatusCode(), 400);
	}

//Get
	// scenario 1
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {

		GetDelete_Program.baseSetUp();

	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {

		response = GetDelete_Program.getresponse_validendpoint();
	}

	@Then("Admin receives {int} ok")
	public void admin_receives_ok(Integer int1) {

		assertEquals(response.getStatusCode(), 200);

	}

	// Scenario 2
	@Then("Admin receives {int} not found  Status with error message")
	public void admin_receives_not_found_status_with_error_message(Integer int1) {

		response = GetDelete_Program.getresponse_invalidendpoint();
		assertEquals(response.getStatusCode(), 404);
	}

	// scenario 3
	@Given("Admin creates GET Request for the LMS API without authorization")
	public void admin_creates_get_request_for_the_lms_api_without_authorization() {

		GetDelete_Program.baseSetUpWithNoAuth();
	}

	@Then("Admin receives {int} Status with response body as Unauthorized")
	public void admin_receives_status_with_response_body_as_unauthorized(Integer int1) {

		response = GetDelete_Program.getresponse_validendpoint();
		assertEquals(response.getStatusCode(), 401);

	}

	// scenario 4
	@When("Admin sends HTTPS Request with endpoint with programId")
	public void admin_sends_https_request_with_endpoint_with_program_id() throws IOException {
		response = GetDelete_Program.getresponse_valid_programId();
		System.out.println(response);
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}
	// scenario 5

	@When("Admin sends HTTPS Request with endpoint with invalid programId")
	public void admin_sends_https_request_with_endpoint_with_invalid_program_id() throws IOException {

		response = GetDelete_Program.getresponse_invalid_programId();

	}

	@Then("Admin receives {int} Not Found Status with message and boolean success detail")
	public void admin_receives_not_found_status_with_message_and_boolean_success_detail(Integer int1)
			throws IOException {
		assertEquals(response.getStatusCode(), 404);

	}

	// Scenario 6
	@Given("Admin creates GET Request for the LMS API with invalid url")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_url() {
		// Write code here that turns the phrase above into concrete actions
		GetDelete_Program.baseSetUpWithInvalidUrl();
	}

	// Scenario 8

	@When("Admin sends HTTPS Request with a invalid endpoint")
	public void admin_sends_https_request_with_a_invalid_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = GetDelete_Program.getresponse_invalid_programId();
		assertEquals(response.getStatusCode(), 404);
	}

	// put

	// Scenario1
	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields()
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Put_Program.put_program_baseSetUp();
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = Put_Program.putResponse_valid_programId();
	}

	@Then("Admin receives {int} OK Status with updated value in response body")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	// Scenario2

	@When("Admin sends HTTPS Request with invalid endpoints")
	public void admin_sends_https_request_with_invalid_endpoints() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = Put_Program.putResponse_invalid_programId();
	}

	@Then("Admin receive {int} Not Found Status with message and boolean success details")
	public void admin_receive_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		response.then().log().all();
		assertEquals(response.getStatusCode(), 404);
	}

	// Scenario3

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields,invalid URI")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_invalid_uri()
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Put_Program.baseSetUpWithinvalidURI();

	}

	// Scenario4
	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields without auth")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_without_auth()
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Put_Program.baseSetUpWithNoAuth();
	}

	@Then("Admin receives {int} Unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 401);
	}

	// Scenario5
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields()
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Put_Program.put_program_baseSetUp();
	}

	@When("Admin sends HTTPS Requests with valid endpoint")
	public void admin_sends_https_requests_with_valid_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = Put_Program.putResponse_valid_programName();
	}

	// Scenario6
	@When("Admin sends HTTPS Requests with invalid endpoint")
	public void admin_sends_https_requests_with_invalid_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = Put_Program.putResponse_invalid_programName();

	}

	// Delete
	// Scenario1
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		// Write code here that turns the phrase above into concrete actions
		GetDelete_Program.baseSetUp();
	}

	@When("Admin sends HTTPS Requests with endpoint")
	public void admin_sends_https_requests_with_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response = GetDelete_Program.deleteresponse_valid_programName();
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		assertEquals(response.getStatusCode(), 200);

	}

//Scenario2
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_name() {
		// Write code here that turns the phrase above into concrete actions
		GetDelete_Program.baseSetUp();
	}

	@When("Admin send HTTPS Requests with invalid endpoint")
	public void admin_send_https_requests_with_invalid_endpoint() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		response=GetDelete_Program.deleteresponse_invalid_programName();
	}

	// Scenario3
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() {
		
		GetDelete_Program.baseSetUp();
	}

	@When("Admin sends HTTPS Request with endpoint with ID")
	public void admin_sends_https_request_with_endpoint_with_id() throws IOException {
		
		response=GetDelete_Program.deleteresponse_valid_programId();
	}

//Scenario4
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_id() {
		
		GetDelete_Program.baseSetUp();
	}

	@When("Admin sends HTTPS Request with endpoint with invalid ID")
	public void admin_sends_https_request_with_endpoint_with_invalid_id() throws IOException {
		response=GetDelete_Program.deleteresponse_invalid_programId();
		
	}
	//Scenario5

@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programId without Auth")
public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id_without_auth() {
    // Write code here that turns the phrase above into concrete actions
    GetDelete_Program.baseSetUpWithNoAuth();
}


}
