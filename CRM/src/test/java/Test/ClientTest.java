package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.ClientPage;
import Page.LoginPage;

public class ClientTest extends BaseTest
{
  @Test(priority=1,groups={"smoke"})
  public void verifyAddClient() {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ClientPage cp=new ClientPage(driver);
	  String actualClient=cp.addClient("AB Associates", "14 B", "LKM", "FL", "32003", "USA", "5675672", "www.test.com", "GSTN2345","AFN");
	  String expectedClient="AB Associates";
	  Assert.assertEquals(actualClient, expectedClient);
  }
  @Test(priority=2,groups={"regression"})
  public void verifySearchAndEditClient() {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ClientPage cp=new ClientPage(driver);
	  String actualEditClient=cp.searchAndEditClient("AB Associates", "AB AssociatesEdited");
	  String expectedEditClient="AB AssociatesEdited";
	  Assert.assertEquals(actualEditClient, expectedEditClient);
  }
  @Test(priority=3,groups={"smoke","regression"})
  public void verifySearchAndDeleteClient() {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");//same code 13 and 14 can be used in base test
	  ClientPage cp=new ClientPage(driver);
	  String actualDeletedClient=cp.searchAndDeleteClient("AB AssociatesEdited");
	  String expectedDeletedClient="No record found.";
	  Assert.assertEquals(actualDeletedClient, expectedDeletedClient);
	  
  }
  @Test(priority=4,groups={"smoke","regression"})
  public void verifySearch() {
	  LoginPage lp=new LoginPage(driver);
	  String actual=lp.doLogin("admin@admin.com", "12345678");
	  ClientPage cp=new ClientPage(driver);
	  String actualSearch=cp.searchClient("AAAA");
	  String expectedSearch="AAAA";
	  Assert.assertEquals(actualSearch, expectedSearch);
	  
  }
  
}
