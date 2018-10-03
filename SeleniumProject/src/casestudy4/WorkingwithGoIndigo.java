
package casestudy4;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkingwithGoIndigo {
	
	        void invokeBrowser() {
		
			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.goindigo.in/?linkNav=home_header");
			System.out.println(driver.getTitle());
			
			checkAvailability(driver);
	        }

	public void checkAvailability(WebDriver obj) {
		   obj.findElement(By.linkText("One Way")).click();
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   obj.findElement(By.xpath("//button[@class='btn buttonGlbl btn-close button-trigger']")).click();
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   obj.findElement(By.xpath("//div[@id='oneWay']//input[@class='origins-value city-name-value']")).clear();
		   obj.findElement(By.xpath("//div[@id='oneWay']//input[@class='origins-value city-name-value']")).sendKeys("Bengaluru");
		   obj.findElement(By.xpath("//div[@id='oneWay']//input[@class='destinations-value city-name-value']")).clear();
		   obj.findElement(By.xpath("//div[@id='oneWay']//input[@class='destinations-value city-name-value']")).sendKeys("Lucknow");
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   //WebElement adultCount = obj.findElement(By.xpath("//div[@class='cols']/label/select[@class='select-custome book-trip-adult']"));
		   WebElement adultCount = obj.findElement(By.xpath("//select[@name='indiGoOneWaySearch.PassengerCounts[0].Count']"));
		   System.out.println("Currently Filling Adult Count to 3");
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  Select dropdown = new Select(adultCount);
		  dropdown.selectByVisibleText("3");
		  
		  WebElement childCount = obj.findElement(By.xpath("//label[@class='select-wrapper']/select[@name='indiGoOneWaySearch.PassengerCounts[1].Count']"));
		   System.out.println("Currently Filling Child count to 2");
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  Select dropdown1 = new Select(childCount);
		  dropdown1.selectByVisibleText("2");
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		  System.out.println("Searching flights for current date");
		 
	      obj.findElement(By.xpath(".//*[@id='oneWay']/form/div[2]/button")).click();
		  try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  obj.close();
	}
	
}
