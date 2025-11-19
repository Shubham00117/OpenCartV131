package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver) 
	{
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']")WebElement txtemailL;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtpasswordL;
	
	@FindBy(xpath = "//input[@value='Login']") WebElement btnLogin;
	
	public void setEmailL(String emailL) 
	{
		txtemailL.sendKeys(emailL);
	}
	
	public void setPasswordL(String passwordL)
	{
		txtpasswordL.sendKeys(passwordL);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	

}
