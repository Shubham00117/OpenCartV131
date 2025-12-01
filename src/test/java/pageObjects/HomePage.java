package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnkmyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement lnkregister;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement lnklogin;
	
	//product search add to cart
	
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement txtSerarch ;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']") WebElement btnSearch;
	@FindBy(xpath = "//span[normalize-space()='Checkout']") WebElement btnCheckout;
	@FindBy(xpath = "//span[normalize-space()='Wish List (0)']") WebElement btnWishList;
	
	
	
	public	void clickMyAccount()
	{
		lnkmyaccount.click();
	}
	
	public	void clickregister()
	{
		lnkregister.click();
	}
	
	public void clickLogin()
	{
		lnklogin.click();
	}
	
	//search product method add to cart
	
	public void searchProduct()
	{
		txtSerarch.sendKeys("iPhone");
	}	
	
	public void ClickSearch() {
		
		btnSearch.click();
		
	}
	
	//Checkout Product Method
	public void clickCheckout() 
	{
		btnCheckout.click();
		
	}
	
	//WishList Product
	public void ClickWishList()
	{
		
		btnWishList.click();
		
	}
	
	

}
