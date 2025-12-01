package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.WishList;
import testBase.BaseClass;

public class TC006_WishList extends BaseClass
{
	@Test
	public void verifyWishList() 
	{
		HomePage hm=new HomePage(driver);
		
		//navigate to login page
		hm.clickMyAccount();
		hm.clickLogin();
		
		
		//fill the details and click login btn
		AccountLoginPage alp=new AccountLoginPage(driver);
		alp.setEmailL(p.getProperty("email"));
		alp.setPasswordL(p.getProperty("password"));
		alp.clickLogin();
		
		//click Wish list Btn
		hm.ClickWishList();
		
		//Wish List btn
		WishList wl=new WishList(driver);
		if(wl.wishListProduct().equals("My Wish List"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
	}

}
