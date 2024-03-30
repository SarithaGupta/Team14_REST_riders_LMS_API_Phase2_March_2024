package com.lms.api.test;


import java.io.IOException;
import com.lms.api.actions.GetAdminId_action;
import io.restassured.response.Response;

public class GetAdminId {
	
	public  void test_Get_Admin_By_AdminId() throws IOException {			
		Response response =GetAdminId_action.getAdminByAdminId();
		response.then().log().all();
	}
}
