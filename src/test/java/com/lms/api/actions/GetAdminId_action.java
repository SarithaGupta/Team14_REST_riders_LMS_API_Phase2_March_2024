package com.lms.api.actions;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.api.endpoints.Routes;
import com.lms.api.pojoPayloads.PutAdminWithRoleId_pojo;
import com.lms.api.pojoPayloads.PutRoleProgramBatchByUserId_pojo;
import com.lms.api.pojoPayloads.PutRoleProgramBatchByUserId_pojo.UserRoleProgramBatch;
import com.lms.api.pojoPayloads.PutUserRoleIdWithUserId_pojo;
import com.lms.api.pojoPayloads.PutUserRoleStatusWithUserId_pojo;
import com.lms.api.utilities.ConfigReaderAndWriter;
import com.lms.api.utilities.ExcelReader;
import io.restassured.response.Response;

public class GetAdminId_action {
	
	static ConfigReaderAndWriter configReaderObj;
//static RequestSpecification request;
//	static RequestSpecBuilder requestSpec;
	static ExcelReader excelReader ;

	
	
//	public static void baseSetUp() {
//		User.baseSetUp(); 	
//	}
//	public static void baseSetUpWithNoAuth() {
//		User.baseSetUpWithNoAuth(); 	
//	}
	
	
	public static Response getAdminByAdminIdAndvalidAdminId() throws IOException
	{
	excelReader = new ExcelReader();
	String  id = excelReader.readRequestBodyDetailsForUserAPIModule("Sheet1").get("userId");
	System.out.println("Id values is" +id);
	
	Response response = User.request
										.when().log().all()
										.get(Routes.Get_Admin_By_Id + id);
	return response;		
	}
	
	
	public static Response getAdminByAdminIdAndInvalidAdminId() throws IOException
	{
	excelReader = new ExcelReader();
	String  id = excelReader.readRequestBodyDetailsForUserAPIModule("Sheet2").get("userId");
	
	Response response = User.request
										.when().log().all()
										.get(Routes.Get_Admin_By_Id + id);
	return response;		
	}
	


	public static Response UserUpdateByUserId() throws JsonProcessingException 
	{
	
	PutAdminWithRoleId_pojo Userpayload = new PutAdminWithRoleId_pojo(); 
		Userpayload.setUserComments("testData");
		Userpayload.setUserEduPg("MCA"); 
	    Userpayload.setUserEduUg("BA");
		Userpayload.setUserFirstName("Nisha");
		Userpayload.setUserLastName("Sharma");
		Userpayload.setUserMiddleName("Gr");
		Userpayload.setUserLinkedinUrl("https://www.linkedin.com/in/sample");
		Userpayload.setUserLocation("Delhi");
	    Userpayload.setUserPhoneNumber(1983493434);
	    Userpayload.setUserTimeZone("EST");
	    Userpayload.setUserVisaStatus("H4-EAD");

	    ObjectMapper objmapper = new ObjectMapper();
	    String payload = objmapper.writeValueAsString(Userpayload);
  
	    Response response = User.request
	    									.given() 
	    									.body(payload)
	    									.when()
	    									.put(Routes.Put_Admin_RoleId_ByAdminId);
	    return response;		
	}
	
	
	public static Response updateRoleIdofAdminWithInvalidRequestBody() throws JsonProcessingException
	{
		PutAdminWithRoleId_pojo Userpayload = new PutAdminWithRoleId_pojo(); 
		Userpayload.setUserComments("testData");
		Userpayload.setUserEduPg("MCA"); 
	    Userpayload.setUserEduUg("BA");
		Userpayload.setUserFirstName("Nisha");
		Userpayload.setUserLastName("6484");
		Userpayload.setUserMiddleName("Gr");
		Userpayload.setUserLinkedinUrl("https://www.linkedin.com/in/sample");
		Userpayload.setUserLocation("Delhi");
	    Userpayload.setUserPhoneNumber(1983493434);
	    Userpayload.setUserTimeZone("ESTHD");
	    Userpayload.setUserVisaStatus("H4-EAD");

	    ObjectMapper objmapper = new ObjectMapper();
	    String payload = objmapper.writeValueAsString(Userpayload);
  
	    Response response = User.request
	    									.given() 
	    									.body(payload)
	    									.when()
	    									.put(Routes.Put_Admin_RoleId_ByAdminId);
	    return response;		
	}
	
	public static Response updateRoleIdofAdminWithInvalidEndPoint() throws JsonProcessingException
	{
		PutAdminWithRoleId_pojo Userpayload = new PutAdminWithRoleId_pojo(); 
		Userpayload.setUserComments("testData");
		Userpayload.setUserEduPg("MCA"); 
	    Userpayload.setUserEduUg("BA");
		Userpayload.setUserFirstName("Nisha");
		Userpayload.setUserLastName("6484");
		Userpayload.setUserMiddleName("Gr");
		Userpayload.setUserLinkedinUrl("https://www.linkedin.com/in/sample");
		Userpayload.setUserLocation("Delhi");
	    Userpayload.setUserPhoneNumber(1983493434);
	    Userpayload.setUserTimeZone("ESTHD");
	    Userpayload.setUserVisaStatus("H4-EAD");

	    ObjectMapper objmapper = new ObjectMapper();
	    String payload = objmapper.writeValueAsString(Userpayload);
  
	    Response response = User.request
	    									.given() 
	    									.body(payload)
	    									.when()
	    									.put(Routes.Put_Admin_RoleId_ByAdminId_Invalid_Endpoint);
	    return response;		
	}
	
	
	public static Response updateRoleStatusOfAdminWithValidAdminId() throws JsonProcessingException
	{
	PutUserRoleStatusWithUserId_pojo payload= new PutUserRoleStatusWithUserId_pojo(); 
	payload.setRoleId("R02");
	payload.setUserRoleStatus("Active");
		
	    ObjectMapper objmapper = new ObjectMapper();
	    String payloadUser = objmapper.writeValueAsString(payload);
  
	    Response response = User.request
	    									.given() 
	    									.body(payloadUser)
	    									.when()
	    									.put(Routes.Put_Admin_Role_Status_ByUserId);
	    return response;
		
	}
	
	public static Response updateRoleStatusOfAdminWithInValidAdminId() throws JsonProcessingException
	{
	PutUserRoleStatusWithUserId_pojo payload= new PutUserRoleStatusWithUserId_pojo(); 
	payload.setRoleId("R02");
	payload.setUserRoleStatus("Active");
		
	    ObjectMapper objmapper = new ObjectMapper();
	    String payloadUser = objmapper.writeValueAsString(payload);
  
	    Response response = User.request
	    									.given() 
	    									.body(payloadUser)
	    									.when()
	    									.put(Routes.Put_Admin_Role_Status_ByInValidUserId);
	    return response;
		
	}
	
	public static Response updateRoleIdByUserId() throws JsonProcessingException
	{
		PutUserRoleIdWithUserId_pojo rolepayload= new PutUserRoleIdWithUserId_pojo(); 
		ArrayList<String> str = new ArrayList<String>();
	       str.add("R01");
	       
		rolepayload.setUserRoleList(str);
		
	    ObjectMapper objmapper = new ObjectMapper();
	    String payloadUser = objmapper.writeValueAsString(str );
  
	    Response response = User.request
	    									.given() 
	    									.body(payloadUser)
	    									.when()
	    									.put(Routes.Put_Admin_RoleId_ByUserId);
	    return response;
		
	}
	
	public static Response updateUserRoleProgramBatchByUserId() throws JsonProcessingException
	{
		PutRoleProgramBatchByUserId_pojo payloadPB = new PutRoleProgramBatchByUserId_pojo();
		payloadPB.setProgramId(16858);
		payloadPB.setRoleId("R01");
		
		UserRoleProgramBatch batch1 = new UserRoleProgramBatch();
		batch1.batchId = 9221;
		batch1.userRoleProgramBatchStatus = "Active";
		
		payloadPB.userRoleProgramBatches = new ArrayList<>();
		payloadPB.userRoleProgramBatches.add(batch1);
		
	    ObjectMapper objmapper = new ObjectMapper();
	    String payloadUser = objmapper.writeValueAsString(payloadPB);
  
	    Response response = User.request
	    									.given() 
	    									.body(payloadUser)
	    									.when()
	    									.put(Routes.Put_Admin_RoleProgramBatch_Status_ByUserId);
	    return response;
	}
	
	public static Response deleteUser() {
		
		Response response = User.request
												.when().log().all()
												.get(Routes.Delete_User_With_Valid_UserId);
		return response;	
		
	}
	
}