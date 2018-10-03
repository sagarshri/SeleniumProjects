package casestudy5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpdateEdurekaProfile {

	public void invokeBrowser(String username, String password) {
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
		System.out.println(driver.getTitle());
		logInToEdureka(driver, username, password);
	}

	private void logInToEdureka(ChromeDriver driver, String username, String password) {

		driver.findElement(By.linkText("Log In")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement uName = driver.findElement(By.id("inputName"));
		uName.sendKeys(username);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("pwd1")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']/img")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[@class='dropdown-toggle']//following-sibling::ul/li[1]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Updating Personal Details......");

		driver.findElement(By.id("personal_details")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//input[@name='currentrole']")).clear();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//input[@name='currentrole']")).sendKeys("Manual and Automation Testing");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().back();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("professional_details")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Updating Professional Details......");

		driver.findElement(By.xpath("//input[@name='linkedinLink']")).clear();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//input[@name='linkedinLink']")).sendKeys("https://www.linkedin.com/feed/");

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().back();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[contains(text(),' Community')]")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Accessing the Blog.....");

		driver.findElement(By
				.xpath("//button[contains(text(),' Community')]//following-sibling::ul/li/a[contains(text(),'Blog')]"))
				.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().back();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Going back to Home page......");

		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Logging out now.....");

		driver.findElement(By.xpath("//a[@class='dropdown-toggle']/img")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[@class='dropdown-toggle']//following-sibling::ul/li[7]")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}
}
