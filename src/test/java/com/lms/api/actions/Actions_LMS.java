package com.lms.api.actions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import com.lms.api.endpoints.Routes;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Actions_LMS {
	private static RequestSpecification request;
    private static ConfigReaderAndWriter configReaderObj;
    private static String endpoint;
    private final ExcelReader excelReader = new ExcelReader();
    private HashMap<String, Object> userData;
    private HashMap<String, Object> programData;
    private HashMap<String, Object> batchData;
    

    public static void baseSetUp() {
        String authToken = getConfigReader().loadConfig().getProperty("Token");
        request = RestAssured.given().baseUri(Routes.BASE_URL).contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken);
    }

    public static void baseSetUpWithNoAuth() {
        request = RestAssured.given().baseUri(Routes.BASE_URL).contentType(ContentType.JSON).log().all();
    }

    public static Response createProgram(String scenario) throws IOException {
        HashMap<String, Object> programData = prepareProgramData();
        return createPostRequest(Routes.Add_New_Program, programData);
    }

    public static Response createBatch(String scenario) throws IOException {
        HashMap<String, Object> batchData = prepareBatchData();
        return createPostRequest(Routes.Create_New_Batch, batchData);
    }

    public static Response createUser(String scenario) throws IOException {
        HashMap<String, Object> userData = prepareUserData();
        return createPostRequest(Routes.Creating_User_with_Role, userData);
    }

    public Response getRequestUser(String scenario, String batchId, int programId, String roleId) throws IOException {
        String endpoint = prepareEndpointForGetRequest(scenario, batchId, programId, roleId);
        return sendGetRequest(endpoint);
    }

    public Response gatAllUsers(String scenario) {
        String endpoint = prepareEndpointForGetAllUsers(scenario);
        return sendGetRequest(endpoint);
    }

    private static Response createPostRequest(String endpoint, HashMap<String, Object> data) {
        return request.when().body(data).post(endpoint);
    }

    private static Response sendGetRequest(String endpoint) {
        return request.when().get(endpoint);
    }

    private static ConfigReaderAndWriter getConfigReader() {
        if (configReaderObj == null) {
            configReaderObj = new ConfigReaderAndWriter();
        }
        return configReaderObj;
    }

    private static HashMap<String, Object> prepareProgramData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        HashMap<String, Object> programData = new HashMap();
        programData.put("programName", excelReader.readRequestBodyDetailsForUserModule().get("programName"));
        programData.put("programDescription",
                excelReader.readRequestBodyDetailsForUserModule().get("programDescription"));
        programData.put("programStatus", excelReader.readRequestBodyDetailsForUserModule().get("programStatus"));
        return programData;
    }

    private static HashMap<String, Object> prepareBatchData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        ConfigReaderAndWriter configReader = new ConfigReaderAndWriter();
        HashMap<String, Object> batchData = new HashMap();
        batchData.put("batchDescription", excelReader.readRequestBodyDetailsForUserModule().get("batchDesc"));
        batchData.put("batchName", excelReader.readRequestBodyDetailsForUserModule().get("batchName"));
        batchData.put("batchNoOfClasses", excelReader.readRequestBodyDetailsForUserModule().get("batchNoOfClasses"));
        batchData.put("batchStatus", excelReader.readRequestBodyDetailsForUserModule().get("batchStatus"));
        batchData.put("programId", configReader.loadConfig().getProperty("programId"));
        return batchData;
    }

    private static HashMap<String, Object> prepareUserData() throws IOException {
        final ExcelReader excelReader = new ExcelReader();
        HashMap<String, Object> userData = new HashMap();
        userData.put("userComments", excelReader.readRequestBodyDetailsForUserModule().get("Comments"));
        userData.put("userEduPg", excelReader.readRequestBodyDetailsForUserModule().get("EDUPG"));
        userData.put("userEduUg", excelReader.readRequestBodyDetailsForUserModule().get("EDUUG"));
        userData.put("userFirstName", excelReader.readRequestBodyDetailsForUserModule().get("firstName"));
        userData.put("userLastName", excelReader.readRequestBodyDetailsForUserModule().get("lastName"));
        userData.put("userLinkedinUrl", excelReader.readRequestBodyDetailsForUserModule().get("LinkedinUrl"));
        userData.put("userLocation", "Mumbai");
        HashMap<String, Object> userLoginData = new HashMap();
        userLoginData.put("loginStatus", "active");
        userLoginData.put("password", "abc");
        userLoginData.put("roleIds", Arrays.asList("string"));
        userLoginData.put("status", "active");
        userLoginData.put("userLoginEmail", excelReader.readRequestBodyDetailsForUserModule().get("LoginEmail"));
        userData.put("userLogin", userLoginData);
        userData.put("userMiddleName", excelReader.readRequestBodyDetailsForUserModule().get("MiddleName"));
        userData.put("userPhoneNumber", excelReader.readRequestBodyDetailsForUserModule().get("PhoneNumber"));
        userData.put("userRoleMaps", Collections.singletonList(new HashMap<String, Object>() {{
            put("roleId", "R02");
            put("userRoleStatus", excelReader.readRequestBodyDetailsForUserModule().get("RoleStatus"));
        }}));
        userData.put("userTimeZone", excelReader.readRequestBodyDetailsForUserModule().get("TimeZone"));
        userData.put("userVisaStatus", excelReader.readRequestBodyDetailsForUserModule().get("visaStatus"));
        return userData;
    }

    private static String prepareEndpointForGetRequest(String scenario, String batchId, int programId, String roleId) throws IOException {
        ExcelReader excelReader = new ExcelReader();
        String invalid_Batch_Id = excelReader.readRequestBodyDetailsForUserModule().get("invalidBatchId");
        String invalid_Program_Id = excelReader.readRequestBodyDetailsForUserModule().get("invalidProgramId");
        String invalid_Role_Id = excelReader.readRequestBodyDetailsForUserModule().get("invalidRoleId");
        String endpoint = "";
        if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID") ||
                scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with no authorization")) {
            endpoint = Routes.Gets_User_by_Program_Batches + batchId;
        } else if (scenario.equals("Check if admin is able to get the Admins for valid program Id") ||
                scenario.equals("Check if admin is able to get the Admins for valid program Id without authorization")) {
            endpoint = Routes.Gets_Users_for_Program + programId;
        } else if (scenario.equals("Check if admin is able to retreive Admins by valid role ID") ||
                scenario.equals("Check if admin is able to retreive Admins by valid role ID with no authorization")) {
            endpoint = Routes.Gets_Users_by_roleId + roleId;
        } else if (scenario.equals("Check if admin is able to get the Admins by program batches for invalid batch ID")) {
            endpoint = Routes.Gets_User_by_Program_Batches + invalid_Batch_Id;
        } else if (scenario.equals("Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint")) {
            endpoint = Routes.Invalid_Endpoint_for_ProgramBatch + batchId;
        } else if (scenario.equals("Check if admin is able to get the Admins for invalid program Id")) {
            endpoint = Routes.Gets_Users_for_Program + invalid_Program_Id;
        } else if (scenario.equals("Check if admin is able to get the Admins for valid program Id with invalid endpoint")) {
            endpoint = Routes.Invalid_Endpoint_for_Program + programId;
        } else if (scenario.equals("Check if admin is able to retreive Admins by invalid role ID")) {
            endpoint = Routes.Gets_Users_by_roleId + invalid_Role_Id;
        } else if (scenario.equals("Check if admin is able to retreive Admins by valid role ID with invalid endpoint")) {
            endpoint = Routes.Invalid_Endpoint_for_Role + roleId;
        }
        return endpoint;
    }

    private static String prepareEndpointForGetAllUsers(String scenario) {
        String endpoint = "";
        if (scenario.equals("Check if admin is able to retrieve all Admins with filters")) {
            endpoint = Routes.Get_all_Users_with_Facets_Filters;
        }
        return endpoint;
    }
	

}
