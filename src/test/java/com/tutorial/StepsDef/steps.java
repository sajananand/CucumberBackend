package com.tutorial.StepsDef;

import com.tutorial.StepDefs;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
    StepDefs stepDefs;

    public steps(){
        stepDefs = new StepDefs();
    }

    @Given("^I am on home page$")
    public void i_am_home_page(){
        stepDefs.isOnHomePage();
    }

    @Given("^I click on signIn button$")
    public void click_SignIn() {
        stepDefs.clickSignIn();
    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void enterUsername(String username) {
        stepDefs.enterUserName(username);
    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void enterPassword(String password) {
        stepDefs.enterPassword(password);
    }

    @Then("^Page should show invalid login$")
    public void invalidLogin() {
        stepDefs.isInvalidLoginPassword();
    }


    @When("^I click create account button$")
    public void clickCreateAccount() {
        stepDefs.clickCreateAccount();
    }

    @Then("^Page should redirect to signup$")
    public void isOnSignUpPage() {
        stepDefs.isOnsignUpPage();
    }


    @When("^I enter incorrect form data$")
    public void enterFormData(DataTable table) {
        stepDefs.enterFormData(table);
    }

    @Then("^A signup error should be shown$")
    public void isinvalidData() {
        stepDefs.isinvalidData();
    }
}
