package com.seleniumeasy.jBehave.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumeasy.functionalTests.data.Data;
import com.seleniumeasy.functionalTests.pageObjects.AjaxFormSubmitDemo;

public class AjaxFormSubmitSteps extends Steps{
	AjaxFormSubmitDemo AjaxFormSumbitPage;
	RemoteWebDriver webDriver;
	Actions action;
	WebDriverWait wait;

	@Given("user is on AjaxFormSubmitPage")
	public void goToBFFP() throws InterruptedException {
		webDriver = new ChromeDriver();
		wait = new WebDriverWait(webDriver, Data.defaultTimeout);
		webDriver.manage().window().maximize();
		webDriver.navigate().to(AjaxFormSubmitDemo.getUrl());
		Thread.sleep(3000);
		AjaxFormSumbitPage = new AjaxFormSubmitDemo(webDriver, action);
		AjaxFormSumbitPage.initializeElements(webDriver);
	}
	
	@When("user writes some name")
    public void writeName() throws InterruptedException {
		AjaxFormSumbitPage.textboxNameInputText("Lorem Ipsum Dolores Umbridge");
    }
	
	@When("user writes some comment")
    public void writeComment() throws InterruptedException {
		AjaxFormSumbitPage.textboxCommentInputText("Lorem Ipsum Dolores Umbridge");
    }

    @When("user clicks submit button")
    public void clickSubmitButton() throws InterruptedException {
    	AjaxFormSumbitPage.buttonSubmitClick();
    }
    
    @When("user waits until the message arrives")
    public void waitForMessageToCome() throws InterruptedException {
    	wait.until(ExpectedConditions.textToBePresentInElement(AjaxFormSumbitPage.submitResultText(), "Form submited Successfully!"));
    }

    @Then("form should be submitted successfully")
    public void resultShouldBeSame(){
		org.junit.Assert.assertEquals("Form submited Successfully!", AjaxFormSumbitPage.submitResultText().getText());
    }

    @AfterScenario
    public void shutDown(){
    	if (webDriver != null)
    		webDriver.quit();
    }
}