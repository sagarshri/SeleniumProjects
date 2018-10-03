package casestudy8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailProject {
	
	ChromeDriver driver;

	@BeforeClass
    public void invokeBrowser() {
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	driver.get("https://www.gmail.com");
  }
	
	@Test(priority=100)
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "Gmail");
	}
	
	@Test(priority=200)
	public void verifyLogin() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sagarshrivastava1989@gmail.com");
	    driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welc0me26@26");
	    //driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='passwordNext']/content/span[contains(text(),'Next')]")).click();
	    WebElement inboxElement = driver.findElement(By.linkText("Inbox"));
		//System.out.println(inboxElement.getAttribute("title"));
	    String title = driver.getTitle();
		Assert.assertTrue(title.contains("Inbox"));
	}
	
	@Test(priority=300)
	public void composeMail() {
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		driver.findElement(By.xpath("//div[@id=':or']/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[1]/div/span[contains(text(),'To')]/../../../td[2]/div/div//textarea[@id=':q4']")).sendKeys("sagarshrivastava1989@gmail.com");
		driver.findElement(By.xpath("//div[@id=':or']/table/tbody/tr/td[2]/form/div[3]/input")).sendKeys("Dummy Mail");
       
        driver.findElement(By.xpath("//div[@id=':or']/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div[@id=':qr']")).sendKeys("Sending testing mail");
        driver.findElement(By.xpath("//div[@id=':pc']")).click();
        
	}
	
	 @Test(priority=400)
	 public void logoutGmail() {
		driver.findElement(By.xpath("//header[@id='gb']/div[2]/div[3]/div/div[2]/div/a/span")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		Assert.assertEquals(driver.getTitle(), "Gmail");
	}
	/* @AfterClass
	 public void closeBrowser() {
	 driver.close();
	}*/


}
