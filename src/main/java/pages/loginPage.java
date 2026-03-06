package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	   
	   public loginPage(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver,this);
	   }
	   @FindBy(id="input-email")
	   private WebElement emailfield;
	   
	   public void enteremail(String emailText)
	   {
		   emailfield.sendKeys(emailText);
	   }
	   
	   @FindBy(id="input-password")
	   private WebElement pwdfield;
	   
	   public void pwdfield(String passwordText)
	   {
		   pwdfield.sendKeys(passwordText);
	   }
	   
	   @FindBy(xpath="//input[@value='Login']")
	   private WebElement loginbutton;
	   
	   public void clicklginbutton()
	   {
		   loginbutton.click();
	   }
	  
	   @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	   private WebElement warningmsg;
	   
	   public String getwarningmsgtxt()
	   {
		  return warningmsg.getText();
	   }
	  
	   
	
}
