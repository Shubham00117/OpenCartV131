package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups = {"Regression","Master"})
	public	void verify_Account_Registration()
	{
		
		logger.info("***** Starting TC001_AccountRegistrationTest*****");
		
		try 
		{
		//Page-HomePage
		HomePage hp=new HomePage(driver);
		
		logger.info("Clicked on MyAccount");
		hp.clickMyAccount();
		
		logger.info("Clicked on Register");
		hp.clickregister();
		
		//Page-AccountRegistrationPaged
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing Costomer details");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEMail(randomString()+"@gmail.com");
		regpage.setPhone(randomNumber());
		
		String pwd=randomAlphaNumeric();//created password variable pwd and assign randomAlphaNumeric Method that provide random password with special character
		
		regpage.setPassword(pwd);//pass String pwd in both password and ConfirmPassword
		regpage.setConfirmPassword(pwd);//pass pwd 
		regpage.clickSubscribeTBtn();
		regpage.clickPrivacyPolicyBtn();
		regpage.clickContinueBtn();
		
		if(regpage.Confirmmessage().equals("Your Account Has Been Created!")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test faild");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		}catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("***** finished TC001_AccountRegistrationTest *****");
		
		
		
		
		
		
		
		
		
	}
	
//	
	

	
	
	

	

}
