package casestudy8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailProjectPasswordEntryPOMStyle {
	private WebElement loginPassword;

	private WebElement submitPassword;
	public GmailProjectPasswordEntryPOMStyle(WebDriver driver) {
		loginPassword = driver.findElement(By.xpath("//input[@name='password']"));
		submitPassword = driver.findElement(By.xpath("//div[@id='passwordNext']/content/span[contains(text(),'Next')]"));
		
	}
	
	public void enterPassword(String uPass) throws InterruptedException{
		loginPassword.sendKeys(uPass);
		Thread.sleep(3000);
		submitPassword.click();
		}
	
}
