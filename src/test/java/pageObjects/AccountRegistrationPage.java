package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Using PageFactory Annotation
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirst_Name;
	
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLast_Name;
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtE_Mail;
	
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txtPhone;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']") WebElement chkSubscribe;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement chkPrivacy;
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement conmessage;
	
	public	void setFirstName(String fname)
	{
		txtFirst_Name.sendKeys(fname);
	}
	
	public	void setLastName(String lname)
	{
		txtLast_Name.sendKeys(lname);
	}
	
	public	void setEMail(String email)
	{
		txtE_Mail.sendKeys(email);
	}
	
	public	void setPhone(String email)
	{
		txtPhone.sendKeys(email);
	}
	
	public	void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public	void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public	void clickSubscribeTBtn()
	{
		//sol1 
		chkSubscribe.click();
		
		//sol2
//		chkSubscribe.submit();
		
		//sol3
//		Actions act=new Actions(driver);
//		act.moveToElement(chkSubscribe).click().perform();
					
		//sol4
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", chkSubscribe);
		
		//Sol 5
//		chkSubscribe.sendKeys(Keys.RETURN);
		
		//Sol6  Explicit wait
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(chkSubscribe)).click();
//		chkSubscribe.click();
		
	}
	
	public	void clickPrivacyPolicyBtn()
	{
		
		chkPrivacy.click();
		
	}
	
	public	void clickContinueBtn()
	{
		btnContinue.click();
	}
	
	public String Confirmmessage()
	{
		return	conmessage.getText();
	}
	
}
