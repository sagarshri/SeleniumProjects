package casestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccessApplication {

	
	void invokeBrowser(int x) {
		if (x == 1) {
			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			System.out.println(driver.getTitle());
			
			demoFindElementMethods(driver);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			closeBrowser(driver);
		} else {
			WebDriver driver1;
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver1 = new FirefoxDriver();
			driver1.manage().window().maximize();
			driver1.manage().deleteAllCookies();
			driver1.get("https://www.edureka.co");
			System.out.println(driver1.getTitle());
			
			demoFindElementMethods(driver1);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			closeBrowser(driver1);
		}
	}

		public void demoFindElementMethods(WebDriver obj) {
		System.out.println("This method will tryout variour Find Element Methods Discussed so far to find the web element"
				+ "like.....Xpath, Id, Link text, Partial Link text");
		
		System.out.println("Searching course Java using --- find_Element_By_Id");
		try {
			obj.findElement(By.id("homeSearchBar")).sendKeys("java");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj.findElement(By.id("homeSearchBarIcon")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("We are at :"+ obj.getTitle() + "page") ;
		
		obj.navigate().back();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Searching Python course using--- XPATH");
		obj.findElement(By.xpath("//input[@type='search']")).sendKeys("Python");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj.findElement(By.id("homeSearchBarIcon")).click();
		System.out.println("We are at :"+ obj.getTitle() + "page") ;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj.navigate().back();
		
		
		System.out.println("Clicking Browse Courses option using -- find_Element_By_Link_Text");
		obj.findElement(By.linkText("Browse Courses")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		System.out.println("We are at :"+ obj.getTitle() + "page") ;
		
		obj.navigate().back();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Clicking Login link using --- find_Element_By_Partial_Link_Text");
		obj.findElement(By.partialLinkText("Log")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}
		
	void closeBrowser(WebDriver obj) {
		obj.quit();

	}
}
