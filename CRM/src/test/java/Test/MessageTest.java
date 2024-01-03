package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.ClientPage;
import Page.LoginPage;
import Page.MessagePage;

public class MessageTest extends BaseTest
{
  @Test
  public void verifyAddMessage() 
  {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");
	  MessagePage mp=new MessagePage(driver);
	  String actualMessage=mp.addMessage("AR", "AR", "AR");
	  String expectedMessage="Subject: AR";
	 SoftAssert obj=new SoftAssert();
	 obj.assertEquals(actualMessage, expectedMessage);
	 obj.assertAll();
  }
  @Test
  public void verifyMessageSearch() 
  {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");
	  MessagePage mp=new MessagePage(driver);
	  String actualMessage=mp.searchMessage("AR");
	  String expectedMessage="Subject: AR";
	 SoftAssert obj=new SoftAssert();
	 obj.assertEquals(actualMessage, expectedMessage);
	 obj.assertAll();
  }
}
