package Test;

import org.testng.annotations.Test;

import Constants.Constant;
import Utility.ElementUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	WebDriver driver;
	
 
@Parameters({"browser"})
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(@Optional ("chrome")String browser) 
  {
	
	 if(browser.equals("chrome"))
	  {
		  driver=new ChromeDriver();
		  
			
	  }
	  else if(browser.equals("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("Please enter corrcet browser");
	  }
	 
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(260));
		//driver.get("https://qalegend.com/crm/index.php/signin"); 
		  driver.get(ElementUtility.getPropertyValue("baseurl"));
	  
  }

@AfterMethod
public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
	if (iTestResult.getStatus() == ITestResult.FAILURE) {
		takeScreenShotOnFailure(iTestResult.getName());

	}
	//driver.quit();
}
public String takeScreenShotOnFailure(String name) throws IOException {
	String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot

	String destination =Constant.screenShot_path+ name + dateName + ".png";


	File finalDestination = new File(destination);

	FileUtils.copyFile(source, finalDestination);
	return destination;
}


}
