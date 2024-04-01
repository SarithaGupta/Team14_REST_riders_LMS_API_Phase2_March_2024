package com.lms.api.test;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.api.actions.GetAdminId_action;
import io.restassured.response.Response;

public class GetAdminId {
	
	public  void test_Get_Admin_By_AdminId() throws IOException
	{			
		Response response =GetAdminId_action.getAdminByAdminIdAndvalidAdminId();
		response.then().log().body()
		.extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code:" + statusCode);
	}
	
	
//	public  void test_Upadte_User_By_UserId() throws IOException
//	{
//	Response response=GetAdminId_action.getAdminByAdminIdAndvalidAdminId();
//	response.then().log().body()
//	.extract().response();
//	}
//	
//	public  void test_Update_User_With_Invalid_Request_Body() throws IOException
//	{
//	Response response=GetAdminId_action.updateRoleIdofAdminWithInvalidRequestBody();
//	response.then().log().body()
//	.extract().response();
	
//}
}
