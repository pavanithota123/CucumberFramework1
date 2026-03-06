package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResults 

{
	WebDriver driver;
	   
	   public searchResults(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver,this);
	   }
	   
	  

	   @FindBy(linkText="HP LP3065")
	   private WebElement validproduct;
	   
	   public boolean displaystatusofvalidproduct()
	   {
		  return validproduct.isDisplayed();
	   }
	   
	 @FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	   private WebElement messagetext;
	   
	   public String MessageText()
	   {
		  return messagetext.getText();
	   }
	   
	 
}



