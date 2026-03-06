package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {

    WebDriver driver;

    public registerPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Locators
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.name("agree");
    By continueButton = By.xpath("//input[@value='Continue']");
    By newsletterYes = By.xpath("//input[@name='newsletter'][@value='1']");

    By successMessage = By.xpath("//div[@id='content']/h1");
    By duplicateWarning = By.xpath("//div[contains(@class,'alert-dismissible')]");

    By firstNameWarning = By.xpath("//input[@id='input-firstname']/following-sibling::div");
    By lastNameWarning = By.xpath("//input[@id='input-lastname']/following-sibling::div");
    By emailWarning = By.xpath("//input[@id='input-email']/following-sibling::div");
    By telephoneWarning = By.xpath("//input[@id='input-telephone']/following-sibling::div");
    By passwordWarning = By.xpath("//input[@id='input-password']/following-sibling::div");


    // Actions

    public void enterFirstName(String fname)
    {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname)
    {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail)
    {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterTelephone(String phone)
    {
        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass)
    {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickPrivacyPolicy()
    {
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue()
    {
        driver.findElement(continueButton).click();
    }

    public void selectNewsletter()
    {
        driver.findElement(newsletterYes).click();
    }

    // Validation methods

    public String getSuccessMessage()
    {
        return driver.findElement(successMessage).getText();
    }

    public String getDuplicateWarning()
    {
        return driver.findElement(duplicateWarning).getText();
    }

    public String getFirstNameWarning()
    {
        return driver.findElement(firstNameWarning).getText();
    }

    public String getLastNameWarning()
    {
        return driver.findElement(lastNameWarning).getText();
    }

    public String getEmailWarning()
    {
        return driver.findElement(emailWarning).getText();
    }

    public String getTelephoneWarning()
    {
        return driver.findElement(telephoneWarning).getText();
    }

    public String getPasswordWarning()
    {
        return driver.findElement(passwordWarning).getText();
    }
}