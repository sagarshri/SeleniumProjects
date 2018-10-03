package casestudy8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailProjectCompseMailPagePOMStyle {
	private WebElement mailTo;
	private WebElement mailSubject;
	private WebElement mailBody;
	private WebElement mailSentbutton;
	
	public GmailProjectCompseMailPagePOMStyle(WebDriver driver) {
		mailTo = driver.findElement(By.xpath("//textarea[@name='to']"));
		mailSubject = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		mailBody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		mailSentbutton = driver.findElement(By.xpath("//div[contains(text(),'Send') and @role='button']"));
	}
	
	public void sentMail(String toMail){
		mailTo.sendKeys(toMail);
	    mailSubject.sendKeys("Dummy Mail");
		mailBody.sendKeys("Sending testing mail");
		mailSentbutton.click();
		
	}
}
