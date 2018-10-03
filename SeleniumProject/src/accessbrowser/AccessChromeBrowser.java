package accessbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccessChromeBrowser {

	ChromeDriver driver;
	WebDriver driver1;

	void invokeBrowser(int x) {
		if (x == 1 ){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.edureka.co");
		System.out.println(driver.getTitle());
		searchCourse(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Log")).click();
		closeBrowser(driver);
	}
		else{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver1 = new FirefoxDriver();
			driver1.manage().window().maximize();
			driver1.manage().deleteAllCookies();
			driver1.get("https://www.edureka.co");
			System.out.println(driver1.getTitle());
			searchCourse(driver1);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver1.getTitle());
			driver1.navigate().back();
			driver1.findElement(By.partialLinkText("Log")).click();
			closeBrowser(driver1);
		}
	}
	public void searchCourse(WebDriver obj){
		
		obj.findElement(By.id("homeSearchBar")).sendKeys("java");
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.findElement(By.id("homeSearchBarIcon")).click();
		
	}
 
	  void closeBrowser(WebDriver obj){
		  //driver.close(); //only one singie window
	      obj.quit(); // End everything
		  
	  }
}
