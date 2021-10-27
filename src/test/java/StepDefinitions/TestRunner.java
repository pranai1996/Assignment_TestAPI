package StepDefinitions;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.test.base.BaseSetup;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * This class main configuration for cucumber BDD setup
 * Unique tag name to run cases can be given here
 * Also, reports to be generated along with other cucumber project options are given here
 * 
 * @return null
 */
@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features",glue = {"StepDefinitions"},
monochrome = true,strict = true,
plugin = {"pretty" , "html:target/HtmlReports",
		"json:target/JsonReports/report.json",
		"junit:target/JunitReports/report.xml",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags="@APIAssignment")
public class TestRunner extends BaseSetup{

	@BeforeClass
	public static void setup() throws IOException, InterruptedException
	{
		BaseSetup.baseConfigurationSetup();
	}

	@AfterClass
	public static void SetupEnd() throws IOException
	{
		// commenting out for execution/debugging purpose
	    System.out.println("End of the API suite");
	}

}
