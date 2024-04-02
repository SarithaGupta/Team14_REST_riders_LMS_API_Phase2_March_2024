package com.lms.api.test;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;

import com.lms.api.actions.Actions_LMS;
import com.lms.api.actions.Actions_User;
import com.lms.api.utilities.ConfigReaderAndWriter;

import io.restassured.response.Response;

public class Tests_LMS {
	private Response response;
    private Actions_LMS act_User = new Actions_LMS();
    String programName;
    String batchName;
    String batchId;

    public void test_Post_With_Mandatory_Fields(String scenario) throws IOException {
        if (scenario.equals("Check if Admin able to create a program with valid endpoint and request body with Authorization")) {
            response = act_User.createProgram(scenario);
            extractAndStoreProgramDetails(response);
            response.then().assertThat().body("programName", Matchers.is(programName));
        } else if (scenario.equals("Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields")) {
            response = act_User.createUser(scenario);
        } else if (scenario.equals("Check if admin able to create a Batch with valid endpoint and request body (non existing values)")) {
            response = act_User.createBatch(scenario);
            extractAndStoreBatchDetails(response);
           
			response.then().assertThat().body("batchName", Matchers.is(batchName));
        }
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    private void extractAndStoreProgramDetails(Response response) throws IOException {
        int programId = response.then().extract().path("programId");
        programName = response.then().extract().path("programName");
        ConfigReaderAndWriter.storeConfig("programId", String.valueOf(programId));
        ConfigReaderAndWriter.storeConfig("programName", programName);
    }
    private void extractAndStoreBatchDetails(Response response) throws IOException {
        int batch_Id = response.then().extract().path("batchId");
        batchName = response.then().extract().path("batchName");
        ConfigReaderAndWriter.storeConfig("batchId", String.valueOf(batch_Id));       
    }

    public void test_Get_User_By_Batch_ID(String scenario) throws IOException {
        String batchId = ConfigReaderAndWriter.loadConfig().getProperty("validBatchId");
        System.out.println("Batch Id Value----------->" +batchId);
        int programId = 0; // Program ID not needed for this scenario
        if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID") || 
            scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with no authorization") || 
            scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint")) {
            response = act_User.getRequestUser(scenario, batchId, programId, "roleId");
            response.then().log().all();
            validateResponse(response);
        }
    }

    public void test_Get_User_By_Program_ID(String scenario) throws IOException {
        int programId = 17240;
        if (scenario.equals("Check if admin is able to get the Admins for valid program Id") || 
            scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization") || 
            scenario.equals("Check if admin is able to get the Admins for invalid program Id") || 
            scenario.equals("Check if admin is able to get the Admins for valid program Id with invalid endpoint")) {
            response = act_User.getRequestUser(scenario, "", programId, "roleId");
            validateResponse(response);
        }
    }

    public void test_Get_User_By_Role_ID(String scenario) throws IOException {
        String roleId = "R02";
        if (scenario.equals("Check if admin is able to retreive Admins by valid role ID") || 
            scenario.equals("Check if admin is able to retreive Admins by invalid role ID") || 
            scenario.equals("Check if admin is able to retreive Admins by valid role ID with no authorization") || 
            scenario.equals("Check if admin is able to retreive Admins by valid role ID with invalid endpoint")) {
            response = act_User.getRequestUser(scenario, "", 0, roleId);
            validateResponse(response);
        }
    }

    public void Get_all_Users_with_Facets_Filters() {
        response = act_User.gatAllUsers("Check if admin is able to retrieve all Admins with filters");
        response.then().log().all();
        validateResponse(response);
    }

    public void test_Get_User_By_Invalid_Batch_ID() throws IOException {
       // int batchId = 0;
        int programId = 0; // Program ID not needed for this scenario
        response = act_User.getRequestUser("Check if admin is able to get the Admins by program batches for invalid batch ID", batchId, programId, "roleId");
        response.then().log().all();
    }

    private void validateResponse(Response response) {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 ", response.getStatusLine());
        response.then().time(Matchers.lessThan(1000L));
    }
}


