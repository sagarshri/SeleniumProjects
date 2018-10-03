package searchCourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCourseSearch {

	void invokeBrowser() {
		
			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			System.out.println(driver.getTitle());
			searchCourse(driver);
			driver.close();
}
      public void searchCourse(WebDriver obj){
    	  System.out.println("Searching for selenium courses " );
  		
  			obj.findElement(By.id("homeSearchBar")).sendKeys("selenium");
  		
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
  		
  		obj.findElement(By.className("coursetitle")).click();
  		try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  		String pagetitle = obj.getTitle();
  		
  		if (pagetitle.contains("Selenium 3.0 WebDriver Online Training")){
  			System.out.println("Page title is matching and it is : " + pagetitle);
  			
  		}
  		else{
  			System.out.println("Page titel is not matching and it is : "+ pagetitle);
  		}
  		
  		obj.navigate().back();
  		try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  		System.out.println("Now moving to All Courses");
  		obj.findElement(By.linkText("All Courses")).click();
  		try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  		System.out.println("Current Page is :" + obj.getTitle());
  		
      }
}
