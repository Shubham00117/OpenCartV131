package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage
{
	
	public CheckOutPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Shopping Cart']") WebElement titleCheckout;
	
	public String checkoutProduct() 
	{
		String checkouttitle=titleCheckout.getText();
		return checkouttitle;
		
	}
	
}
