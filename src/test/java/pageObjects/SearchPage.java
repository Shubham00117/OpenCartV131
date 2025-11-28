package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub\
		super(driver);
		
		
	}
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']") WebElement btnCart;
	@FindBy(xpath = "//span[@id='cart-total']") WebElement btncartproduct;
	@FindBy(xpath = "//td[@class='text-left']//a[contains(text(),'iPhone')]") WebElement cartProduct;
	
	
	
	
	
	public void clickAddToCart() 
	{
		btnCart.click();
		
	}
	
	public void clickCart() 
	{
		btncartproduct.click();
		
	}
	
	public String CartProduct() 
	{
	String cartproductvalue=cartProduct.getText();
	return cartproductvalue;
		
	}

}
