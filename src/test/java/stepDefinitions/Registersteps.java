package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.registerPage;
import utils.commonutils;

public class Registersteps 

{
	WebDriver driver;
	@Given("user navigates to register pager")
	public void user_navigates_to_register_pager()
	{
		driver=Driverfactory.getDriver();
		homePage home = new homePage(driver);
		home.clickonmyaccount();
		home.clickonregister();
	
	}

	@When("user enters below fields")
	public void user_enters_below_fields(DataTable dataTable) 
	
	{
	 Map<String,String> datamap=  dataTable.asMap(String.class,String.class);
	 registerPage registerpage=new registerPage(driver);
	 registerpage.enterFirstName(datamap.get("firstName"));
	 registerpage.enterLastName(datamap.get("lastName"));
	 
//	 String email = datamap.get("email");
//
//	 if(email.equals("auto"))
//	 {
//	     email = getEmailTimeStamp();
//	 }
	 String email = datamap.get("email");

	 if(email.equals("auto"))
	 {
	     email = commonutils.getEmailWithTimeStamp();
	 }

	 driver.findElement(By.id("input-email")).sendKeys(email);
	 driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
	 driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
	 driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));
	 
	 
	}
	
	
	
	@When("user enters below fields with duplicate mail")
	public void user_enters_below_fields_with_duplicate_mail(DataTable dataTable) 
	
	{
	 Map<String,String> datamap=  dataTable.asMap(String.class,String.class);
	 driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstName"));
	 driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastName"));
	 driver.findElement(By.id("input-email")).sendKeys(datamap.get("email"));
	 driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
	 driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
	 driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));
	 
	 
	}
	

	@And("user selects privacy policy")
	public void user_selects_privacy_policy() 
	
	{
	    driver.findElement(By.name("agree")).click();
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
	   driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("user account should created successfully")
	public void user_account_should_created_successfully() 
	{
	   Assert.assertEquals("Your Account Has Been Created!",driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	}

	@And("user selects yes for news letter")
	public void user_selects_yes_for_news_letter()
	
	{
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	
	@Then("user account should get proper error")
	public void user_account_should_get_proper_error()
	
	{
	  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user not entered any fields")
	public void user_not_entered_any_fields()
	{
	    //intentionally kept blank
	}

	@Then("user should get proper warning messages for every mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields()
	
	{
		
		 Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		 Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
		 Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		 Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		 Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		 Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
		 
		 
	}
	
}
