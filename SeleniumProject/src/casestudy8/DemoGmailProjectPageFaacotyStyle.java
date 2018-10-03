package casestudy8;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoGmailProjectPageFaacotyStyle {

	public static void main(String[] args) {
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		String uMail, uPass, toMail;
		System.out.println("Enter user Mail ID");
		Scanner sc = new Scanner(System.in);
		uMail = sc.next();
		System.out.println("Enter user password");
		uPass = sc.next();
		System.out.println("Enter Mail ID to send Mail");
		toMail = sc.next();
	 	GmailProjectPageFactoryStyle PF = new GmailProjectPageFactoryStyle(driver);
		try {
			PF.loginToGmail(uMail, uPass);
			PF.composeMail(toMail);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
