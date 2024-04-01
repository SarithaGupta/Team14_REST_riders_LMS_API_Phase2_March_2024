package com.lms.api.test;

import java.io.IOException;

import com.lms.api.actions.User;

import io.restassured.response.Response;

public class UserTests {
public void test_Get_User_By_ProgramBatches() {			
	Response response = User.getUserForValidBatchId();
	response.then().log().all();
		
	}
public void test_Get_User_By_ProgramBatches_With_Invalid_BatchId() throws IOException {
	
    Response response = User.getUserForInvalidBatchId();
	response.then().log().all();
	
}
public void test_Get_User_By_ProgramBatches_With_Invalid_Endpoint() throws IOException {
	
    Response response = User.getUserForValidBatchIdWithInvalidEndPoint();
	response.then().log().all();
}
	
}
