package runcucumberfeature;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/"
		,glue= {"stepDefinitions"}
//		,plugin = { "pretty","html:target/cucumber-reports" }
		,plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		,monochrome = true)

public class Testfeature  {
	@AfterClass
	public static void writeExtentReport() {
		com.vimalselvam.cucumber.listener.Reporter.loadXMLConfig(new File("./extent-config.xml"));
	}
	
}