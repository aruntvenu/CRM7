package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class ClientPage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement clients;
	@FindBy(xpath="//a[text()=' Add client']")
	WebElement addClient;
	@FindBy(xpath="//input[@name='company_name']")
	WebElement companyNameField;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath="//input[@name='city']")
	WebElement cityField;
	@FindBy(xpath="//input[@name='state']")
	WebElement stateField;
	@FindBy(xpath="//input[@name='zip']")
	WebElement zipField;
	@FindBy(xpath="//input[@name='country']")
	WebElement countryField;
	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneField;
	@FindBy(xpath="//input[@name='website']")
	WebElement websiteField;
	@FindBy(xpath="//input[@name='vat_number']")
	WebElement vatNumberField;
	@FindBy(xpath="//div[@id='s2id_currency']")
	WebElement currencyField;
	@FindBy(xpath="//input[@id='s2id_autogen5_search']")
	WebElement currencySearchField;
	@FindBy(xpath="//span[text()='AFN']")
	WebElement selectedCurrencyAFN;

	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	@FindBy(xpath="//input[@type='search']")
	WebElement clientsSearch;
	@FindBy(xpath="//a[@title='Edit client']")
	WebElement clientsEdit;
	@FindBy(xpath="//input[@name='company_name']")
	WebElement companyNameEdit;
	@FindBy(xpath="//button[@type='submit']")
	WebElement companyNameEditSave;
	@FindBy(xpath="//a[@title='Delete client']")
	WebElement clientsDelete;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement clientsDeleteConfirmation;
	@FindBy(xpath="//button[@class='close']")
	WebElement closeButton;
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[2]")
	WebElement clientCompanyNameColumn;
	@FindBy(xpath="//button[@class='close']")
	WebElement finalClose;
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[1]")
	WebElement noRecordFound;
	WaitUtility waitUtil;
	ElementUtility elementUtil;//object declaration




	public ClientPage(WebDriver driver) 

	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitUtil=new WaitUtility(driver);
		elementUtil=new ElementUtility(driver); //object initialization
	}
	public String addClient(String companyName,String address,String city,String state,String zip,String country,String phone,String website,String vatNumber,String currency)
	{

		clients.click();
		waitUtil.waitForClick(addClient);
		addClient.click();
		companyNameField.sendKeys(companyName);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		elementUtil.scroll(countryField);
		countryField.sendKeys(country);
		phoneField.sendKeys(phone);
		websiteField.sendKeys(website);
		vatNumberField.sendKeys(vatNumber);
		currencyField.click();
		currencySearchField.sendKeys(currency);
		selectedCurrencyAFN.click();
		//elementUtil.scroll(save);


		save.click();
		waitUtil.waitForClick(closeButton);
		closeButton.click();  
		finalClose.click();
		clientsSearch.sendKeys(companyName);
		String actual=clientCompanyNameColumn.getText();
		return actual;
	}
	public String searchAndEditClient(String searchValue,String editValue )
	{
		clients.click();
		waitUtil.waitForClick(clientsSearch);
		clientsSearch.sendKeys(searchValue);
		clientsEdit.click();
		//companyNameEdit.clear();
		//companyNameEdit.sendKeys(editValue);
		elementUtil.clearAndSendKey(companyNameEdit, editValue);
		companyNameEditSave.click();
		waitUtil.waitForClick(closeButton);
		closeButton.click();  
		finalClose.click();
		clientsSearch.clear();
		clientsSearch.sendKeys(editValue);
		String actual=clientCompanyNameColumn.getText();
		return actual;
	}
	public String searchAndDeleteClient(String searchValue)
	{   clients.click();
	waitUtil.waitForClick(clientsSearch);
	clientsSearch.sendKeys(searchValue);
	clientsDelete.click();
	clientsDeleteConfirmation.click();
	waitUtil.waitForClick(finalClose);
	finalClose.click();
	clientsSearch.clear();
	clientsSearch.sendKeys(searchValue);
	String actual=noRecordFound.getText();
	return actual;

	}
	public String searchClient(String searchV)
	{
		clients.click();
		clientsSearch.sendKeys(searchV);
		String actual=clientCompanyNameColumn.getText();
		return actual;
	}
}
