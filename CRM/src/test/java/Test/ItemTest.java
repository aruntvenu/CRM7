package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.ItemPage;
import Page.LoginPage;

public class ItemTest extends BaseTest
{
  @Test(priority=1,groups={"smoke"},retryAnalyzer = generaltests.Retry.class)
  public void verifyAddItem() 
  {
	  LoginPage lp=new LoginPage(driver);
  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ItemPage ip=new ItemPage(driver);
	  ip.clickItem();
	  String actualItem=ip.addItem("TitleTest","Desc","Kg","10");
	  String expectedItem="TitleTest";
	  Assert.assertEquals(actualItem, expectedItem);
	  
  }
  @Test(priority=2,groups={"regression"})
  public void verifyEditItem() 
  {
	  LoginPage lp=new LoginPage(driver);
  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ItemPage ip=new ItemPage(driver);
	  ip.clickItem();
	  String actualEditName=ip.searchAndEditItem("TitleTest", "EditedTitle");
	  String expectedEditName="EditedTitle";
	  Assert.assertEquals(actualEditName, expectedEditName);
	  
  }
  @Test(priority=3,groups={"smoke","regression"})
  public void verifyDeleteItem() 
  {
	  LoginPage lp=new LoginPage(driver);
  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ItemPage ip=new ItemPage(driver);
	  ip.clickItem();
	  String actualDelete=ip.searchAndDelete("EditedTitle");
	  String expectedDelete="No record found.";
	  Assert.assertEquals(actualDelete, expectedDelete);
	  
	  
  }
  @Test(priority=4,groups={"smoke","regression"})
  public void verifySearch() 
  {
	  LoginPage lp=new LoginPage(driver);
  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ItemPage ip=new ItemPage(driver);
	  
	  String actualSearch=ip.searchItem("BBBB");
	  String expectedSearch="BBBB";
	  Assert.assertEquals(actualSearch, expectedSearch);
	  
	  
  }
}
