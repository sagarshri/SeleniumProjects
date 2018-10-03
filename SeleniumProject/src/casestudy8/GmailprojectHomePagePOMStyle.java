package casestudy8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailprojectHomePagePOMStyle {
	private WebElement composeMail;
	
	public GmailprojectHomePagePOMStyle(WebDriver driver) {
	composeMail = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
	}
	
	public void clickCompose(){
		composeMail.click();
	}
}
