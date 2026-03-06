package stepDefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accountPage;
import pages.homePage;
import pages.loginPage;
import utils.commonutils;

public class Loginsteps

{
	WebDriver driver;
	 loginPage loginpg ;
	@Given("when user navigate to login page")
	public void when_user_navigate_to_login_page() {
		driver = Driverfactory.getDriver();

		homePage home = new homePage(driver);
		home.clickonmyaccount();
		home.clickonlogin();
		loginpg = new loginPage(driver); 

	}

	@When("user enters valid email {string}")
	public void user_enters_valid_email(String emailText) {

		loginpg.enteremail(emailText);

	}

	@And("user enters valid password {string}")
	public void user_enters_valid_password(String passwordText) {
		loginpg.pwdfield(passwordText);

	}

	@And("user has to click on login button")
	public void user_has_to_click_on_login_button() {
		loginpg.clicklginbutton();
	}

	@Then("user should get successfully loggedin")
	public void user_should_get_successfully_loggedin()
	{   
	   accountPage accntpg=new accountPage(driver);

		Assert.assertTrue(accntpg.verifyeditmsg());
		
	}

	@When("user enters invalid email address into mail address")
	public void user_enters_invalid_email_address_into_mail_address() 
	
	{
		
		loginpg.enteremail(commonutils.getEmailWithTimeStamp());
		
	}

	@When("user enters invalid password {string} in password field")
	public void user_enters_invalid_password_in_password_field(String invalidpassword)

	{
		loginpg.pwdfield(invalidpassword);
		
	}

	@Then("user should get proper warning message about credentials")
	public void user_should_get_proper_warning_message_about_credentials()

	{
		

		Assert.assertTrue(loginpg.getwarningmsgtxt().
				contains("No match for E-Mail Address and/or Password."));

	}

	@When("user dont enter any email address")
	public void user_dont_enter_any_email_address()

	{

	}

	@And("user dont enter any password")
	public void user_dont_enter_any_password() {

	}


}
