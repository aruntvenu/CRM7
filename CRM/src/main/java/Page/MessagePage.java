package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class MessagePage 
{
	WebDriver driver;

	@FindBy(xpath="//span[text()='Messages']")
	WebElement messages;
	@FindBy(xpath="//a[text()='Compose']")
	WebElement composeButton;
	@FindBy(xpath="//div[@id='s2id_to_user_id']")
	WebElement toField;
	@FindBy(xpath="//input[@id='s2id_autogen3_search']")
	WebElement toSearchField;
	@FindBy(xpath="//span[text()='John']")
	
	WebElement contactSelect;
	@FindBy(xpath="//input[@name='subject']")
	WebElement subjectField;
	@FindBy(xpath="//textarea[@id='message']")
	WebElement messageDescField;
	@FindBy(xpath="//button[text()=' Send']")
	WebElement sendButton;
	@FindBy(xpath="//div[text()='The message has been sent.']")
	WebElement successMessage;
	@FindBy(xpath="//a[text()='Sent items']")
	WebElement sentTab;
	@FindBy(xpath="//input[@id='search-messages']")
	WebElement messageSearch;
	@FindBy(xpath="//strong[text()=' John John']")
	WebElement searchResult;
	@FindBy(xpath="//p[@class='pt5 pb10 b-b']")
	WebElement messageSubject;
	WaitUtility waitUtil;
	ElementUtility elementUtil;
	public MessagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitUtil=new WaitUtility(driver);
	    elementUtil=new ElementUtility(driver);
		
	}
	public String addMessage(String subject,String message,String searchText)
	{
		//waitUtil.waitForClick(messages);
		messages.click();
		waitUtil.waitForClick(composeButton);
		composeButton.click();
		toField.click();
		toSearchField.sendKeys("John");
		contactSelect.click();
		subjectField.sendKeys(subject);
		messageDescField.sendKeys(message);
		sendButton.click();
		waitUtil.waitForClick(successMessage);
		successMessage.click();
		sentTab.click();
		messageSearch.sendKeys(searchText);
		searchResult.click();
		String actual=messageSubject.getText();
		return actual;
		
			
	}
	public String searchMessage(String searchV)
	{
		messages.click();
		sentTab.click();
		messageSearch.sendKeys(searchV);
		searchResult.click();
		String actual=messageSubject.getText();
		return actual;
	}


}
