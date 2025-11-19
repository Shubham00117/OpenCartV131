package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest *****");
		
		try {
		//Home Page
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		//AccountLoginPage
		
		AccountLoginPage alp=new AccountLoginPage(driver);
		
		alp.setEmailL(p.getProperty("email"));
		alp.setPasswordL(p.getProperty("password"));
		alp.clickLogin();
		
		//MyAccount
		MyAccountPage map=new MyAccountPage(driver);
		
		
		boolean targetpage=	map.isMyAccountPageExist();
		Assert.assertEquals(targetpage, true);
		}
		catch (Exception e) 
		{
			Assert.fail();
			
		}
	}

}
