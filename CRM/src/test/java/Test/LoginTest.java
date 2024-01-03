package Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Constants.Constant;
import Page.LoginPage;
import Utility.ExcelRead;

public class LoginTest extends BaseTest
{
  @Test (priority=1,dataProvider="dp",groups={"smoke","regression"})
  public void verifyLogin(String username,String password) 
  {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin(username,password);
	  String expected="Dashboard";
	  Assert.assertEquals(actual, expected);		  
  }
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException
  {
	  Object[][]data=ExcelRead.getDataFromExcel(Constant.test_data,"Sheet1");
			  return data;
  }
}
