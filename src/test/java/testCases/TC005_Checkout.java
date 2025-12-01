package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC005_Checkout  extends BaseClass
{

	@Test
	public void verifyCheckOutPage()
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
		
		//click checkout button
		hm.clickCheckout();
		
		CheckOutPage cop=new CheckOutPage(driver);
		if(cop.checkoutProduct().equals("Shopping Cart"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
			
		}
		
	}
}
