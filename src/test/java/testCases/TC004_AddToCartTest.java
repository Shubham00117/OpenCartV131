package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_AddToCartTest extends BaseClass 
{
	
	@Test
		public void verifyAddToCart() 
		{
		logger.info(" Starting TC_005_AddToCartPageTest ");
			HomePage hp=new HomePage(driver);
			
			hp.searchProduct();
			hp.ClickSearch();
			
			SearchPage sp=new SearchPage(driver);
			
			sp.clickAddToCart();
			sp.clickCart();
			sp.CartProduct();
			
			
			
			if(sp.CartProduct().equals("iPhone"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
				
				
			}
			logger.info(" Finished TC_005_AddToCartPageTest ");
			
		}
}
