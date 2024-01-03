package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public String doLogin(String userName,String password)
	{
		WebElement emailField=driver.findElement(By.xpath("//input[@name='email']"));
		  emailField.sendKeys(userName);
		  WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
		  passwordField.sendKeys(password);
		  WebElement signIn=driver.findElement(By.xpath("//button[text()='Sign in']"));
		  signIn.click();
		  WebElement dashboard=driver.findElement(By.xpath("//span[text()='Dashboard']"));
		  String actualDashboardText=dashboard.getText();
		  return actualDashboardText;
		  
		  
	}

}
