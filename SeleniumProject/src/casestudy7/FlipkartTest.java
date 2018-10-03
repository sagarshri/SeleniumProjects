package casestudy7;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	public class FlipkartTest extends FlipkartProject {
		ChromeDriver driver;
		
		@BeforeClass
		public void invokeBrowser() {
			
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com");
			driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!");
			/*try {
				shopItem("Selenium Book");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			closeBrowser();*/
		}
		@Parameters({"BookName"})
		@Test(priority=100)
		  
		    public void shopItem(String itemName) throws InterruptedException {
		    	WebElement bookElement = driver.findElement(By.xpath("//div/ul/li[7]"));
		    	Actions action = new Actions(driver);
	            action.moveToElement(bookElement).build().perform();
	            WebElement bookLink = driver.findElement(By.linkText("Books"));
	            action.moveToElement(bookLink).click().build().perform();
				driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(itemName);
				driver.findElement(By.tagName("button")).click();
				Thread.sleep(5000);
				String fileLocation = System.getProperty("user.dir")+"/screenshots/BookAvailable.png";
				takeScreenShot(driver,fileLocation);
				String parentWindow = driver.getWindowHandle();
				driver.findElement(By.linkText("Selenium Webdriver Practical Guide")).click();
	            Set<String> windoHandles = driver.getWindowHandles();
	            String childWindoHandle = windoHandles.toArray()[1].toString();
	            driver.switchTo().window(childWindoHandle);
	            
	            Thread.sleep(4000);
	            System.out.println("Checking Availavility in My Location with Pin:560037");
	            driver.findElement(By.id("pincodeInputId")).sendKeys("560037");
	            driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
	            System.out.println("Delevery in : " + driver.findElement(By.xpath("//div[@class='_29Zp1s']/span[1]")).getText());
	            fileLocation = System.getProperty("user.dir")+"/screenshots/DeliveryDetails.png";
	            driver.findElement(By.xpath("//span[contains(text(),'View Details')]")).click();
	            
	            
	            takeScreenShot(driver, fileLocation);
	            Thread.sleep(8000);
	            //driver.findElement(By.xpath("//div[@class='_3hgEev']//button[contains(text(),'✕')]")).click();
	            driver.navigate().refresh(); 
	            WebElement addToCart = driver.findElement(By.xpath("//ul[@class='row']/li[1]/button"));
	            int x = addToCart.getLocation().getX();
	            int y = addToCart.getLocation().getY();
	            System.out.println("Location for X : "+ x + "and location for Y :"+ y);
	            scrollTo(driver, x, y);
	            Thread.sleep(4000);
	            addToCart.click();
	            Thread.sleep(6000);
	            System.out.println(driver.getTitle());
	            driver.findElement(By.xpath("//button/span[contains(text(),'Place Order')]")).click();
	            Thread.sleep(6000);
	            driver.findElement(By.xpath("//form/div/input")).clear();
	            driver.findElement(By.xpath("//form/div/input")).sendKeys("abc@gmail.com");
	            Thread.sleep(4000);
	            driver.findElement(By.xpath("//form/div/button")).click();
	            driver.findElement(By.xpath("//form/div[2]/input")).sendKeys("abc123");
	            driver.findElement(By.xpath("//form/div[3]/button")).click();
	            Thread.sleep(8000);
	            fileLocation = System.getProperty("user.dir")+"/screenshots/CheckoutError.png";
	            
	            takeScreenShot(driver, fileLocation);
	            String actualError = driver.findElement(By.xpath("//form/div[1]/span[2]")).getText();
	            Assert.assertEquals(actualError, "Your username or password is incorrect");
	            driver.close();
	            driver.switchTo().window(parentWindow);
	            
			}
		    
		    
		
		    @AfterClass
		    public void closeBrowser() {
			driver.close();
			
			
		}
		
	}


