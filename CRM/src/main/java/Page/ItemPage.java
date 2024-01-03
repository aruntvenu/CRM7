package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class ItemPage 
{
	WebDriver driver;
	@FindBy(xpath="//span[text()='Items']")
	WebElement items;
	@FindBy(xpath="//span[text()='Items']")
	WebElement itemsTab;
	@FindBy(xpath="//a[text()=' Add item']")
	WebElement addItem;
	@FindBy(xpath="//input[@name='title']")
	WebElement itemTitleField;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement itemDescriptionField;
	@FindBy(xpath="//input[@name='unit_type']")
	WebElement itemUnitTypeField;
	@FindBy(xpath="//input[@name='item_rate']")
	WebElement itemRateField;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement itemSave;
	@FindBy(xpath="//input[@type='search']")
	WebElement itemSearch;
	@FindBy(xpath="//a[@title='Edit item']")
	 WebElement itemEdit;
	@FindBy(xpath="//input[@name='title']")
	WebElement editTitle;
	@FindBy(xpath="//button[@type='submit']")
	WebElement editSave;
	@FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
	WebElement itemTitleColumn;
	@FindBy(xpath="//button[text()=' Close']")
	WebElement closeButton;
	@FindBy(xpath="//button[@class='close']")
	WebElement closePopupButton;
	@FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
	WebElement noRecord;
	@FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
	WebElement searchRecord;
	WaitUtility waitUtil;
	ElementUtility elementUtil;
	
	
	 
	
	public ItemPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitUtil=new WaitUtility(driver);
	    elementUtil=new ElementUtility(driver);
	}
	
	public String addItem(String itemTitle,String itemDescription,String itemUnitType,String itemRate)
	{
		waitUtil.waitForClick(addItem);
		  addItem.click();
		  itemTitleField.sendKeys(itemTitle);
		  itemDescriptionField.sendKeys(itemDescription);
		  itemUnitTypeField.sendKeys(itemUnitType);
		  itemRateField.sendKeys(itemRate);
		  itemSave.click();
		  waitUtil.waitForClick(closeButton);
		  closeButton.click();
		  closePopupButton.click();
		//itemSearch.sendKeys(itemTitle);
		  String actual=search(itemTitle);
		
	return actual;
		
	}
	public String searchAndEditItem(String searchValue,String editValue)
	{
		waitUtil.waitForClick(itemSearch);
		itemSearch.sendKeys(searchValue);
		 itemEdit.click();
		 editTitle.clear();
		  editTitle.sendKeys(editValue);
		  editSave.click();	
		  waitUtil.waitForClick(closeButton);
		  closeButton.click();
		  closePopupButton.click();
		  itemSearch.clear();
		  String actual=search(editValue);
		  return actual;
	}
	public String searchAndDelete(String searchValue)
	{
		waitUtil.waitForClick(itemSearch);
		itemSearch.sendKeys(searchValue);
		WebElement itemDelete=driver.findElement(By.xpath("//i[@class='fa fa-times fa-fw']"));
		  itemDelete.click();
		  waitUtil.waitForClick(closePopupButton);
		  closePopupButton.click();
		  itemSearch.clear();
		  
		  itemSearch.sendKeys(searchValue);
		 String actual=noRecord.getText();
		  return actual;
		  
		  
	}
	public void clickItem()
	{
		items.click();
	}
	public String search(String searchValue)
	{
		waitUtil.visibilityWait(itemSearch);
		elementUtil.clearAndSendKey(itemSearch, searchValue);

		By locator=By.xpath("//table[@id='item-table']//tbody//tr//td[contains(text(),'"+searchValue+"')]");
		waitUtil.visibilityWait(locator);
		List<WebElement> itemtable=driver.findElements(By.xpath("//table[@id='item-table']//tbody//tr//td[1]"));
		waitUtil.visibilityWait(itemtable);
		int row=elementUtil.getTabledataRowCount(itemtable, searchValue);
		String actualmsg="";
		
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='item-table']//tbody//tr["+row+"]//td[1]"));
			actualmsg=tableRow.getText();
			System.out.println("Verify SearchItem : " +actualmsg);
		}
		return actualmsg;
	
	}
	public String searchItem(String searchV)
	{
		itemsTab.click();
		
		itemSearch.sendKeys(searchV);
		String actual=searchRecord.getText();
		return actual;
	}

	
}
