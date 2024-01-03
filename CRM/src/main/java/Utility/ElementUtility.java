package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constants.Constant;

public class ElementUtility 
{
	
	WebDriver driver;
	public ElementUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public static String getPropertyValue(String key) 
	{

		File src=new File(Constant.propertyConfig_File);
		Properties pro=new Properties();
		try {
			FileInputStream fis = new FileInputStream (src);
			
			pro.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String value=pro.get(key).toString();
		return value;
	}
	public void scroll(WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void dropdownSelectByIndex(WebElement index,int a)
	{
		Select indexDpdwn=new Select(index);
		indexDpdwn.selectByIndex(a);
	}
	public void dropdownSelectByValue(WebElement value,String b)
	{
		Select valueDpdwn=new Select(value);
		valueDpdwn.selectByValue(b);
	}
	public void dropdownSelectByVisibleText(WebElement text,String c)
	{
		Select visibleDpdwn=new Select(text);
		visibleDpdwn.selectByVisibleText(c);
	}
	public void radioButton(List<WebElement> rbtn,int e)
	{
		rbtn.get(e).click();
	}
	public void checkbox (List<WebElement> chkboxlist,int f)
	{
		
	       chkboxlist.get(f).click();
	}
	public void clearAndSendKey(WebElement element,String text)
	{
		element.clear();
		element.sendKeys(text);
	}
	public int getTabledataRowCount(List<WebElement> tableRowData, String expectedValue)
	{
		
			int counter=0; 
			
		for(int i=0;i<tableRowData.size();i++) 
		{
		String value=tableRowData.get(i).getText(); 
		if(expectedValue.equalsIgnoreCase(value)) 
		{ 
			counter=i+1;
			break;
			} 
		} 
		return counter;


	}
	


}
