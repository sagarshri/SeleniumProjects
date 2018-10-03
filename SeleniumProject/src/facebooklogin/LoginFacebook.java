package facebooklogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFacebook {

	ChromeDriver driver;

	void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		login();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closeBrowser();
	}
	
	public void login() {
        
		
			driver.findElement(By.name("email")).sendKeys("sagarshrivastava1989@gmail.com");
			driver.findElement(By.name("pass")).sendKeys("S@786tava12");
		//	WebElement button = driver.findElement(By.name("login"));
			driver.findElement(By.id("loginbutton")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.navigate().refresh();
			driver.findElementByClassName("_1frb").sendKeys("Ankita Jain");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
	}			
	void closeBrowser(){
		  //driver.close(); //only one singie window
	  driver.quit(); // End everything
		  
	  }
}
