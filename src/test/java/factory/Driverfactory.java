package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.configReader;


public class Driverfactory

{
	
	
//	static WebDriver driver=null;
//  public static WebDriver initializebrowser(String browserName)
//  {
//	 
//	  
//	  if(browserName.equals("chrome"))
//	  {
//		   driver=new ChromeDriver();
//	  }
//	  
//	  else if (browserName.equals("firefox"))
//		  {
//			   driver=new FirefoxDriver();
//		  }
//	  else if (browserName.equals("edgedriver"))
//	  {
//		  driver=new EdgeDriver();
//	  }
//	  
//	  driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		return driver;
//	
//}
// 
//  public static WebDriver getDriver()
//  {
//	  return driver; 
//  }
//  
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializebrowser(String browserName) {

        if (browserName.equals("chrome")) {

            driver.set(new ChromeDriver());

        } 
        else if (browserName.equals("edge")) {

            driver.set(new EdgeDriver());

        } 
        else if (browserName.equals("firefox")) {

            driver.set(new FirefoxDriver());

        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static WebDriver getDriver() {

        return driver.get();

    }
}

