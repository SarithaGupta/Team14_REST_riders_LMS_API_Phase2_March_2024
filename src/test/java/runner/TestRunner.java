
package runner;
public class TestRunner {
	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
	        features = "src/test/resources/Features",
	        glue = {"com.lms.api.stepdefs"},
	       // tags = "@EndtoEnd",
	        monochrome = true,
	       plugin = {"pretty",
	                "html:target/cucumber-html-report", "json:target/cucumber.json",
	                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	                "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7"
	                        + "Jvm"}
	)
	        public class TestRunner {
	    		
	    	}
	}