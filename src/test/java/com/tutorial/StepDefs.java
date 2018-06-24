package com.tutorial;

import com.tutorial.Helper.DriverManager;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class StepDefs extends DriverManager {

    public void searchText(String searchString){
        driver.findElement(By.id("lst-ib")).sendKeys(searchString);
        driver.findElement(By.id("_fZl")).click();
    }

    public void enterUserName(String userName){
        auto.enterText("#identifierId",userName);
        auto.clickElementByCssSelector("#identifierNext > content > span");
        auto.processWait(2);
    }

    public void enterPassword(String password){
        auto.enterText("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input",password);
        auto.clickElementByCssSelector("#passwordNext > content > span");
        auto.processWait(2);
    }

    public void isInvalidLoginPassword() {
        auto.processWait(5);
        Assert.assertTrue(auto.pageContains("#password > div.LXRPh > div.dEOOab.RxsGPe", "Wrong password"));
    }

    public void isOnHomePage() {
        auto.gotoPage("https://google.com");
        auto.processWait(2);
        String title = driver.getTitle();
        Assert.assertEquals("Title does not have Google","Google", title);
    }

    public void clickSignIn() {
        auto.clickElementByCssSelector("#gb_70");
        auto.processWait(5);
        Assert.assertTrue(auto.pageContains("#headingText","Sign in"));
    }

    public void clickCreateAccount() {
        auto.clickElementByCssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div > div.daaWTb > div > div > content > span");
        auto.processWait(5);
        Assert.assertFalse(auto.pageContains("#headingText","Sign in"));
    }

    public void isOnsignUpPage() {
        auto.processWait(5);
        Assert.assertTrue(auto.pageContains("#headingText","Create your Google Account"));
    }

    public void isinvalidData() {
        auto.processWait(3);
        Assert.assertTrue(auto.pageContains("#passwd > div.LXRPh > div.dEOOab.RxsGPe","Use 8 characters or more for your password"));
    }

    public void enterFormData(DataTable table) {
        List<List<String>> data = table.raw();
        auto.enterText("#firstName",data.get(1).get(1));
        auto.enterText("#lastName",data.get(2).get(1));
        auto.enterText("#username",data.get(3).get(1));
        auto.enterText("#passwd > div.aCsJod.oJeWuf > div > div.Xb9hP > input",data.get(4).get(1));
        auto.enterText("#confirm-passwd > div.aCsJod.oJeWuf > div > div.Xb9hP > input",data.get(4).get(1));
        auto.clickElementByCssSelector("#accountDetailsNext > content > span");
    }
}
