package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")WebElement msgHeading;
	@FindBy(xpath = "//span[@class='caret']") WebElement lnkcaret;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement lnkLogout;
	
	public boolean isMyAccountPageExist() 
	{	
		try 
		{
			return (msgHeading.isDisplayed());
		}
		catch (Exception e) 
		{
			return false;
		}
		
		
	}
	
	public void clickLogout()
	{
		lnkcaret.click();
		lnkLogout.click();
	}
	

}
