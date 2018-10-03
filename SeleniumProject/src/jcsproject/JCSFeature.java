package jcsproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JCSFeature {
	
ChromeDriver driver;
	
    @Parameters({"domain","username","password"})
	@Test(priority=100)
	public void loginTest(String domain, String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://psm-ui.usdv1.oraclecloud.com/psmui/faces/paasRunner.jspx?serviceType=JAAS");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("tenantDisplayName")).sendKeys(domain);
		Thread.sleep(3000);
		driver.findElement(By.id("signin")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("signin")).click();
		Assert.assertEquals(driver.getTitle(), "Oracle Java Cloud Service Details");
	}
    
    @Test(priority=300)
    public void jcsProvisioning() throws InterruptedException{
    	driver.findElement(By.xpath("//button/span[contains(text(),'reate Instance')]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//table[contains(@id,'ScrollContent')]/tbody/tr/td[contains(text(),'Java')]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[text()='Instance Name']/../..//input")).sendKeys("JCSTest");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[contains(text(),'Description')]/../..//input")).sendKeys("Trying Provisioning");
    	Thread.sleep(2000);
    	WebElement serviceVersion = driver.findElement(By.xpath("//span[contains(text(),'Software Release')]/../..//select"));
    	Select verDropdown = new Select(serviceVersion);
    	verDropdown.selectByVisibleText("Oracle WebLogic Server 12c, 12.2.1.2");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button/span[contains(text(),'ext')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[contains(text(),'Advanced')]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[text()='WebLogic Access']/../../../../../../../../..//span[starts-with(text(),'Password')]/../..//input")).sendKeys("Welcome1#");
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[text()='WebLogic Access']/../../../../../../../../..//span[starts-with(text(),'Conf')]/../..//input")).sendKeys("Welcome1#");
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//table[@id='r1:2:pt1det:pt1ProvFlow:detailsPage:sshKeyPopup:pgl19']//*/input")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//table[@id='r1:2:pt1det:pt1ProvFlow:detailsPage:sshKeyPopup:pgl19']//*/textarea")).
    	sendKeys("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDOOVKYC3NI6FQd63NTlEGhvGuk7+H69VCYXLC6JGIhaNQGb0DnEukcDVlONInrY0OFKD1NYFGPwuh+C65mgv3af+fCerUedWZwFKzuo+vNikQ9DOI7OIpCN3YHgZW43OmK51G2hfmi7QFjyNpJdUkw2GQb+IlP3lVAF4cQ5Pf1LZfn8oJVfDpAlZuIqR5MBDcoi/dNEO2a6o+Wm5tCOrkTuOLjOFqdWG0ugAsZyz/KwIZL9/ks4AGeM+RrJr8KA6Ck4XlSG62sMD4ph5GZSXQYsvodJjypC8XnAb6nW5LHEq6KYSooG/UBgzUVW0bsxFQoHO1nGtzZmn0KJd5Gu3rt xperiment");
    	Thread.sleep(3000);
    	//Runtime.getruntime.exec("C:/Users/sshrivat.ORADEV/Documents/key.exe");
    	driver.findElement(By.xpath("//a/span[contains(text(),'Enter')]")).click();
    }
	
	/*@Test(priority=600)
	public void loggedOut() throws InterruptedException{
		driver.findElement(By.id("r1:0:pt1:header:h:logoutlink")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("r1:0:pt1:header:h:logout")).click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "Sign Out");
		driver.quit();
	}
	*/

	
}
