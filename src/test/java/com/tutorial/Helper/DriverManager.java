package com.tutorial.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver driver;
    public static AutomationUtils auto;

    public void openBrowser(){
        //Download Webdriver from http://www.seleniumhq.org/download/ and provide unzipped exe path
//        System.setProperty("webdriver.chrome.driver", "\\usr\\local\\bin\\chromedriver");
        driver=new ChromeDriver();
        auto = new AutomationUtils(driver);
    }

    public void closeBrowser(){
        driver.quit();
    }

}
