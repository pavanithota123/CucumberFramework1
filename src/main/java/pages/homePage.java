package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePage

{
   WebDriver driver;
   
   public homePage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy(xpath="//span[text()='My Account']")
   private WebElement myAccountDropMenu;
   
   @FindBy(linkText="Login")
   private WebElement loginoption;
   
   public void clickonmyaccount()
   {
	   myAccountDropMenu.click();
   }
   public void clickonlogin()
   {
	   loginoption.click();
   }
   
   
   @FindBy(linkText="Register")
   private WebElement registerbutton;
   
   public void clickonregister()
   {
	 registerbutton.click();
   }
  @FindBy(name="search")
   private WebElement searchbox;
  
  public void enterproduct(String producttext) {
	  searchbox.sendKeys(producttext);
  }
  
  @FindBy(xpath="//button[contains(@class,'btn-default')]")
  private WebElement searchbutton;
 
 public void clickonsearchbutton()
 {
	  searchbutton.click();
 }
   
}
  
//  
//	@Then("User should get valid product displayed in search results")
//	public void user_should_get_valid_product_displayed_in_search_results() 
//	{
//	    Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
//	}
//
//	@When("User enters invalid product {string} into Search box field")
//	public void user_enters_invalid_product_into_search_box_field(String invalidproduct)
//	{
//	    
//		 driver.findElement(By.name("search")).sendKeys(invalidproduct);
//	}
//
//}


//page factory is a selenium webdriver class - support page object model , initialising the objects when instances created for 
//page object is a design pattern