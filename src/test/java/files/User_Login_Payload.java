package files;

import com.lms.api.utilities.ConfigReaderAndWriter;

public class User_Login_Payload {
	static ConfigReaderAndWriter configReaderObj;
	
	public static String userLoginRequest() {
		configReaderObj = new ConfigReaderAndWriter();
		String loginEmail = configReaderObj.loadConfig().getProperty("userLoginEmailId");
		String loginPassword = configReaderObj.loadConfig().getProperty("password");
		
		return "{\r\n"
				+ "  \"password\":\""+ loginPassword +"\",\r\n"
				+ "  \"userLoginEmailId\": \""+loginEmail+"\"\r\n"
				+ "}";
		
	}

}
