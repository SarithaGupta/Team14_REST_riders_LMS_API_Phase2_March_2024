package com.lms.api.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public String getJsonPath(Response response,String key)
	{
		 String rsp=response.asString();
		JsonPath js=new JsonPath(rsp);
		return js.get(key).toString();
	}
	

}
