package com.seleniumeasy.jBehave.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.pageObjects.BasicSelectDropdownDemo;

public class BasicSelectDropdownSteps extends Steps{
	BasicSelectDropdownDemo BasicSelectDropdownPage;
	RemoteWebDriver webDriver;
	Actions action;

	@Given("user is on BasicSelectDropdownDemoPage")
	public void goToBFFP() throws InterruptedException {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.navigate().to(BasicSelectDropdownDemo.getUrl());
		Thread.sleep(3000);
		BasicSelectDropdownPage = new BasicSelectDropdownDemo(webDriver, action);
		BasicSelectDropdownPage.initializeElements(webDriver);
	}
	
	@When("user clicks on the list")
    public void clickOnTheList() throws InterruptedException {
		BasicSelectDropdownPage.dropdownListClick();
    }

    @When("user selects a value")
    public void clickCalifornia() throws InterruptedException {
    	BasicSelectDropdownPage.selectMondayClick();
    }
    
    @When("user clicks on the option")
    public void clickFirstSelected() throws InterruptedException {
		BasicSelectDropdownPage.selectCaliforniaClick();
    }

    @When("user clicks on the First Selected button")
    public void chooseMonday() throws InterruptedException {
    	BasicSelectDropdownPage.buttonFirstSelectedClick();
    }

    @Then("result should be the same as user's choice")
    public void resultShouldBeTheSame() throws InterruptedException{
        org.junit.Assert.assertEquals("Day selected :- Monday", BasicSelectDropdownPage.messageResult1Text().getText());
    }
    
    @Then("result should be the same as user's chosen option")
    public void resultShouldShowOption() throws InterruptedException{
        org.junit.Assert.assertEquals("First selected option is : California", BasicSelectDropdownPage.messageResult2Text().getText());
    }

    @AfterScenario
    public void shutDown(){
    	if (webDriver != null)
    		webDriver.quit();
    }
}