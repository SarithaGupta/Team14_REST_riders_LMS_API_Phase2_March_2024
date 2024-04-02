package com.lms.api.endpoints;

public class Routes {
	public static String BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String USERLOGIN_ENDPOINT = "/login";
	public static String GET_ALL_PROGRAMS_ENDPOINT ="/allPrograms";
	public static String Gets_User_by_Program_Batches ="/users/programBatch/";
	public static String INVALID_ENDPOINT = "/users/lms/invalidEndPoint";
	
	// Batch Module URL
	
		 public static String post_url_EndPoint = "/batches";
		    
		public static String getBatch_url_EndPoint = "/batches";

		public static String getBatch_url_InvalidEndPoint = "/batchgft";
				
		public static String getBatch_batchId_url_EndPoint = "/batches/batchId/";

		public static String getBatch_batchName_url_EndPoint = "/batches/batchName/";

		public static String getBatch_programId_url_EndPoint = "/batches/program/";

		public static String put_url_EndPoint = "/batches/";

		public static String delete_url_EndPoint = "/batches/";
 
}
