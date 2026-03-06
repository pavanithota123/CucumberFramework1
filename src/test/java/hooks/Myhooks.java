package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class Myhooks

{
	WebDriver driver;

	@Before()
	public void setup() {
		Properties prop = configReader.initializeproperties();
		driver = Driverfactory.initializebrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	

	    @After
	    public void tearDown(Scenario scenario) {

	        if (scenario.isFailed()) {

	            byte[] screenshot = ((TakesScreenshot) Driverfactory.getDriver())
	                    .getScreenshotAs(OutputType.BYTES);

	            scenario.attach(screenshot, "image/png", "Failure Screenshot");

	        }

	      
	   
	}
}
