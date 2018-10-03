package casestudy6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CourseSearchTest {
	ChromeDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co");
		System.out.println(driver.getTitle());
	}
	
	@Parameters({"userid","password"})
	@Test(priority=100)
	public void logInToEdureka(String username, String password) throws InterruptedException {
        System.out.println("Login to Account");
		driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);
		WebElement uName = driver.findElement(By.id("inputName"));
		uName.sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.id("pwd1")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
		Assert.assertEquals(true,driver.findElement(By.linkText("Refer")).isDisplayed());
		System.out.println("login is successful......");
		
	}
	
	@Test(priority=200, dataProvider="getData")
	public void searchCourse(String course) throws InterruptedException{
		System.out.println("Searching for selenium courses");
		driver.findElement(By.id("homeSearchBar")).sendKeys(course);
		Thread.sleep(4000);
		driver.findElement(By.id("homeSearchBarIcon")).click();
        driver.findElement(By.className("coursetitle")).click();
        String pagetitle = driver.getTitle();
       	Assert.assertEquals("Selenium 3.0 WebDriver Online Training | Selenium Certification Course | Edureka",
				pagetitle);
    }
	
	@Test(priority=300)
	public void Logout(){
		System.out.println("Logging out now.....");
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']/img")).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']//following-sibling::ul/li[7]")).click();
  	    Assert.assertEquals(true, driver.findElement(By.linkText("Log In")).isDisplayed());
	}
	
	@DataProvider
	public Object[][] getData(){
          Object[][] data;
		
		  data = new Object[1][1];
		
		data[0][0] = "Selenium";
		return data;
		
	}
	
	@Test(priority=400)
	public void SignUpWithExistingID() throws InterruptedException{
		System.out.println("Trying to Sign up with existing Email ID");
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("signupname")).sendKeys("Sagar Shrivastava");
		Thread.sleep(3000);
		driver.findElement(By.id("signupemail")).sendKeys("sagarshrivastava1989@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("signuptel")).sendKeys("1234567890");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd3")).sendKeys("abc123232432");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
		Thread.sleep(3000);
		String status = driver.findElement(By.id("signup_error_message")).getText();
		Assert.assertEquals("Email address already exists. Please Sign In.", status);
		System.out.println(status);
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
  
}
