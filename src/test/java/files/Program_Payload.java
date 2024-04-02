package files;

import java.io.IOException;

import com.lms.api.pojoPayloads.Post_Program;
import com.lms.api.utilities.ExcelReader;

public class Program_Payload {
	ExcelReader excelreader=new ExcelReader();
	public Post_Program add_Program() throws IOException
	{
		//ExcelReader excelreader=new ExcelReader();
		Post_Program a=new Post_Program();
			a.setProgramName(excelreader.readRequestBodyDetailsForUserModule().get("programName"));	
		a.setProgramDescription(excelreader.readRequestBodyDetailsForUserModule().get("programDescription"));
		a.setProgramStatus(excelreader.readRequestBodyDetailsForUserModule().get("programStatus"));
		return a;
	}
	
	public Post_Program put_program() throws IOException
	{
		Post_Program c=new Post_Program();
		c.setProgramName(excelreader.readRequestBodyDetailsForUserModule().get("programName"));	
	c.setProgramDescription(excelreader.readRequestBodyDetailsForUserModule().get("updatedDescription"));
	c.setProgramStatus(excelreader.readRequestBodyDetailsForUserModule().get("programStatus"));
	return c;
	}

}
