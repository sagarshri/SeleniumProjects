package casestudy7;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartProject {
	
	public void scrollTo(WebDriver driver, int x, int y){
		
		String jsCommand;
		JavascriptExecutor jsEngine;
		
		jsEngine = (JavascriptExecutor) driver;
		
		jsCommand = String.format("window.scrollTo(%d,%d)", x, y);
		
		jsEngine.executeScript(jsCommand);
	}
    
    public void takeScreenShot(ChromeDriver oBrowser, String sFileName){

    	try {
    		TakesScreenshot oCamera;

    		File oTmpFile, oImageFile;

    		oImageFile = new File(sFileName);

    		if(new File(sFileName).exists()){
    			throw new Exception("Image File already exists.. choose some different name");
    		}

    		oCamera = (TakesScreenshot) oBrowser;

    		oTmpFile = oCamera.getScreenshotAs(OutputType.FILE);

    		FileUtils.copyFile(oTmpFile, oImageFile);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
