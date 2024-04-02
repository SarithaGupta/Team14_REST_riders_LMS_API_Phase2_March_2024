package com.lms.api.endpoints;

public class Routes {
	public static String BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String INVALID_BASE_URL = "https://lms-marchapi-hackathonlms-a258d2bbd43b.herokuapp.com/lms";
	public static String USERLOGIN_ENDPOINT = "/login";
	public static String GET_ALL_PROGRAMS_ENDPOINT ="/allPrograms";
	public static String GET_ALL_PROGRAMS_INVALID_ENDPOINT ="/allallPrograms";
	public static String INVALID_ENDPOINT = "/users/lms/invalidEndPoint";
	public static String GET_PROGRAM_BY_PROGRAMID="/programs/";
	public static String INVALID_GET_PROGRAM_BY_PROGRAMID="/program/";
	public static String GET_PROGRAM_BY_PROGRAMNAME="/programs/";
	public static String ADD_PROGRAM_ENDPOINT="/saveprogram";
	public static String INVALID_ADD_PROGRAM_ENDPOINT="/saveprograms";
	public static String Gets_User_by_Program_Batches="/batches";
	public static String PUT_PROGRAM_BY_PROGRAMID="/putprogram/";
	public static String PUT_PROGRAM_BY_PROGRAMNAME="/program/";
	public static String INVALID_PUT_PROGRAM_BY_PROGRAMID="/putprograms/";
	public static String DELETE_PROGRAM_BY_PROGRAMNAME="/deletebyprogname/";
	public static String DELETE_PROGRAM_BY_PROGRAMID="/deletebyprogid/";
	


}
