package com.tutorial.Helper;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AutomationUtils {

	WebDriver driver = null;
	

	public AutomationUtils() {

	}

	public AutomationUtils(WebDriver browserDriver) {
		this.driver = browserDriver;
	}

	public void gotoPage(String url) {
		driver.get(url);
	}

	public boolean processWait(int duration){
		try {
			Thread.sleep(duration * 1000);
			return true;
		} catch (InterruptedException e) {
			return false;
		}
		

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
//		log.info("Browser window maximized");
	}

	public boolean verifyPageByTitle(String expectedTitle) {
		try {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			return true;
		} catch (AssertionError e) {
			return false;
		} 
	}


	public boolean verifyPageByHeadingBySelector(String htmlselector, String expectedHeading) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertEquals(expectedHeading, driver.findElement(By.cssSelector(htmlselector)).getText());
			return true;
		} catch (AssertionError e) {
			return false;
		}
		
	}
	
	public boolean pageContains(String htmlselector, String string) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean contains = driver.findElement(By.cssSelector(htmlselector)).getText().contains(string);
			if(contains){
				return true;
			}else{
				return false;
			}
						
		} catch (Exception e) {
				return false;

		}
	}
	
				
	public void clickElementById(String elementId) {
		try {
			driver.findElement(By.id(elementId)).click();
//			log.info("clicked element: " + elementId);
		} catch (Exception e) {

		}

	}

	public void clickElementByCssSelector(String selector) {
		try {
			driver.findElement(By.cssSelector(selector)).click();
//			log.info("clicked element: " + elementId);
		} catch (Exception e) {

		}

	}

	public void clickElementByClass(String elementClass) {
		try {
			driver.findElement(By.className(elementClass)).click();
//			log.info("clicked element: " + elementClass);
		} catch (Exception e) {
		}
	}

	public void enterText(String cssSelector, String data) {
		try {
			driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
//			log.info("Entered- " + data + " to the element: " + elementId);
		} catch (Exception e) {

		}
	}

	public String generateNumber() {
		Random ran = new Random();
		int min = 111111111;
		int max = 999999999;
		String randomNumber = Integer.toString(min + ran.nextInt(max - min + 1));
//		log.info("Generated random number");
		return randomNumber;

	}

	public void selectOptionByText(String elementId, String option) {
		try {
			Select dropdown = new Select(driver.findElement(By.id(elementId)));
			dropdown.selectByVisibleText(option);
//			log.info("Selected " + option + " from " + elementId);
		} catch (Exception e) {

		}

	}

	public void selectOptionByIndex(String elementId, int index) {
		try {
			Select dropdown = new Select(driver.findElement(By.id(elementId)));
			dropdown.selectByIndex(index);
//			log.info("Selected option " + index + " from " + elementId);
		} catch (Exception e) {


		}
	}

	public String generateEmail() {
		String email = "testclient" + generateNumber() + "@mailas.com";
//		log.info("generated random mail address: " + email);
		return email;
	}
	
	public void captureScreen() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\selenium training\\screenshot\\screenshot.png"));
	}

	public void errorQuit() {
//		log.info("error");
		try {
			captureScreen();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void closeWindow() {
//		log.info("Browser window closed");
		driver.quit();
	}

}
