package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

	public class BaseClass {
	
		public static	WebDriver driver;
		public Logger logger;
		public	Properties p;
		
		@BeforeClass(groups = {"Sanity","Regression","Datadriven","Master"})
		@Parameters({"browser","os"})
		public	void SetUp(@Optional("chrome") String br,@Optional("mac")String os) throws IOException 
		{
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
		 logger=LogManager.getLogger(this.getClass());
		 
		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			//set os
			if(os.equalsIgnoreCase("Mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if (os.equals("Windows"))
			{
				cap.setPlatform(Platform.WIN11);
			} 
			else if (os.equalsIgnoreCase("linux")) 
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//set browser
			if(br.equalsIgnoreCase("Chrome"))
			{
				cap.setBrowserName("chrome");
			}
			else if (br.equalsIgnoreCase("edge"))
			{
				cap.setBrowserName("MicrosoftEdge");
			}
			else if(br.equals("firefox")){
				
				cap.setBrowserName("firefox");
				
			}
			else
			{
				System.out.println("no matching browser");
				return;
				
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(p.getProperty("execution_env").equals("local"))
		{
		 switch (br.toLowerCase()) {
		 case "chrome":

			    ChromeOptions options = new ChromeOptions();
			    
			    Map<String, Object> prefs = new HashMap<>();
			    prefs.put("profile.password_manager_leak_detection", false);
			    prefs.put("credentials_enable_service", false);

			    options.setExperimentalOption("prefs", prefs);

			    driver = new ChromeDriver(options);
			    break;
			
		case"edge":
			driver=new EdgeDriver();
			break;

		default:
			return;
		}
		 
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("Url"));//open site get Url link by using Properties class get property method.
		driver.manage().window().maximize();
		
		
		}
		
		@AfterClass
		public	void tearDown()
		{
//				driver.quit();//quite driver
		}
	
		public String randomString() {
	    RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('A', 'Z')   // alphabetic (uppercase)
	            .build();
	    return generator.generate(7);
		}
	
		public String randomNumber() {
	    RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('0', '9')   // numeric only
	            .build();
	    return generator.generate(10);
	    
		}
	
		public String randomAlphaNumeric() {

	    RandomStringGenerator alpha = new RandomStringGenerator.Builder()
	            .withinRange('A', 'Z')     // 3 alphabetic characters
	            .build();

	    RandomStringGenerator numeric = new RandomStringGenerator.Builder()
	            .withinRange('0', '9')     // 3 numeric characters
	            .build();

	    return alpha.generate(3) + "@" + numeric.generate(3);
	}
		
		public String captureScreen(String tname) throws IOException {

		    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
							
		    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		    // Updated macOS screenshot path
		    String targetFilePath = "/Users/shubham_infinity/Desktop/test1/OpenCartV131/screenshots/" 
		                             + tname + "_" + timeStamp + ".png";

		    File targetFile = new File(targetFilePath);
		    sourceFile.renameTo(targetFile);
						
		    return targetFilePath;
		}
	//this RandomStringUtils methods are deprecated instead of this class use RandomStringGenerator
//	public String randomString()
//	{
//		String generatedString=	RandomStringUtils.randomAlphabetic(7);
//		return generatedString;
//	}
//	
//	public String randomNumber()
//	{
//		String generateNumber=RandomStringUtils.randomNumeric(10);
//		return generateNumber;
//	}
	
//	public String randomAlphaNumeric()
//	{
//		String randomAlphabate = RandomStringUtils.randomAlphabetic(3);
//		String randomnumber= RandomStringUtils.randomNumeric(3);
//		
//		return randomAlphabate+"@"+randomnumber;
//	}

}
