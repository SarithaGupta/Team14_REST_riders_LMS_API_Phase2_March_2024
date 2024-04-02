package com.lms.api.endpoints;

public class Routes {
	public static String BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String USERLOGIN_ENDPOINT = "/login";
	public static String Add_New_Program ="/saveprogram";
	public static String Create_New_Batch ="/batches";
	public static String GET_ALL_PROGRAMS ="/allPrograms";
	public static String Delete_Batch ="/batches/";
	public static String Delete_Program ="/deletebyprogid/";
	public static String Creating_User_with_Role   ="/users/roleStatus";
	public static String Gets_User_by_Program_Batches ="/users/programBatch/";
	public static String Invalid_Endpoint_for_Program = "/users/program/";
	public static String Invalid_Endpoint_for_ProgramBatch = "/users/programBatc/";
	public static String Invalid_Endpoint_for_Role= "/users/rols/";
	public static String Gets_Users_for_Program ="/users/programs/";
	public static String Gets_Users_by_roleId ="/users/roles/";
	public static String Get_all_Users_with_Facets_Filters ="/v2/users";
	


}
