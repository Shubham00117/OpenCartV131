package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"Datadriven","Master"})//getting DataProvider from different class
	public void verify_login(String email,String pwd,String exp)
	{
		logger.info("***** Starting TC002_LoginTest *****");
		
		
		try {
			
			//Home page
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin(); //Login link under MyAccount
					
				//Login page
				AccountLoginPage lp=new AccountLoginPage(driver);
				lp.setEmailL(email);
				lp.setPasswordL(pwd);
				lp.clickLogin(); //Login button
				
					
				//My Account Page
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageExist();
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
		
		
		
	}
}	



