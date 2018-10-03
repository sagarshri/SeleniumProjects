package casestudy8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailProjectPageFactoryStyle {
	
	@FindBy(xpath = "//input[@id='identifierId']")
	private WebElement loginUsername;
	
	@FindBy(xpath = "//div[@id='identifierNext']")
	private WebElement submitUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement loginPassword;

	@FindBy(xpath = "//div[@id='passwordNext']/content/span[contains(text(),'Next')]")
	private WebElement submitPassword;
	
	@FindBy(xpath = "//div[contains(text(),'Compose')]")
	private WebElement composeMail;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement mailTo;
	
	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement mailSubject;
	
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement mailBody;
	
	@FindBy(xpath = "//div[contains(text(),'Send') and @role='button']")
	private WebElement mailSentbutton;
	
	public GmailProjectPageFactoryStyle(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToGmail(String uMail, String uPass) throws InterruptedException{
		loginUsername.sendKeys(uMail);
		submitUsername.click();
		loginPassword.sendKeys(uPass);
		Thread.sleep(3000);
		submitPassword.click();
	}
	
	public void composeMail(String toMail){
		composeMail.click();
		mailTo.sendKeys(toMail);
	    mailSubject.sendKeys("Dummy Mail");
		mailBody.sendKeys("Sending testing mail");
		mailSentbutton.click();
	}
}
