package casestudy8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailProjectUserEntryPOMStyle {
	private WebElement loginUsername;
	private WebElement submitUsername;
	
	public GmailProjectUserEntryPOMStyle(WebDriver driver) {
		loginUsername = driver.findElement(By.xpath("//input[@id='identifierId']"));
		submitUsername = driver.findElement(By.xpath("//div[@id='identifierNext']"));
		}
	
	public void enterUsername(String uMail) throws InterruptedException{
		loginUsername.sendKeys(uMail);
		submitUsername.click();
		
		}
	
	
	
	
	
}	
