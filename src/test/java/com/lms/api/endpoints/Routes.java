package com.lms.api.endpoints;

public class Routes {
	public static String BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String USERLOGIN_ENDPOINT = "/login";
	public static String GET_ALL_PROGRAMS_ENDPOINT ="/allPrograms";
	public static String Gets_User_by_Program_Batches ="/users/programBatch/";
	public static String INVALID_ENDPOINT = "/users/lms/invalidEndPoint";
	public static String Get_Admin_By_Id ="/users/";
	public static String Put_Admin_RoleId_ByAdminId = "/users/U51";
	public static String Put_Admin_RoleId_ByAdminId_Invalid_Endpoint ="/userss/U51";
	public static String Put_Admin_Role_Status_ByUserId ="/users/roleStatus/U555";
	public static String Put_Admin_Role_Status_ByInValidUserId ="/users/roleStatus/U55590";
	public static String Put_Admin_RoleId_ByUserId = "/users/roleId/U555";
	public static String Put_Admin_RoleProgramBatch_Status_ByUserId="/users/roleProgramBatchStatus/U555";
	public static String Put_Admin_Login_Status_With_Valid_UserId="/users/userLogin/U555";
	public static String Delete_User_With_Valid_UserId ="/users/U555";

}
