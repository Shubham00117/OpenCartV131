package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList extends BasePage {
	
	
	public WishList(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Wish List']")WebElement titleWishList;
	
	
	public String wishListProduct() {
		
		String titlecheck= titleWishList.getText();
		return titlecheck;
		
	}
	
	

}
