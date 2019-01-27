package com.seleniumeasy.jBehave.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.pageObjects.BasicFirstFormDemo;

public class BasicFirstFormSteps extends Steps{
	BasicFirstFormDemo BasicFirstFormPage;
	RemoteWebDriver webDriver;
	Actions action;

	@Given("user is on BasicFirstFormDemoPage")
	public void goToBFFP() throws InterruptedException {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.navigate().to(BasicFirstFormDemo.getUrl());
		Thread.sleep(3000);
		BasicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		BasicFirstFormPage.initializeElements(webDriver);
	}
	
	@When("user writes something")
    public void writeLorem() throws InterruptedException {
		BasicFirstFormPage.messageTextBox1Input("Lorem Ipsum Dolores Umbridge");
    }

    @When("user clicks Show Message button")
    public void clickShowMessage() throws InterruptedException {
    	BasicFirstFormPage.messageButton1Click();
    }
    
    @When("user enters value a and value b")
    public void enterValues() throws InterruptedException {
		BasicFirstFormPage.valueTextBox1Input("2");
		BasicFirstFormPage.valueTextBox1Input("3");
    }

    @When("user clicks Get Total button")
    public void clickGetTotal() throws InterruptedException {
    	BasicFirstFormPage.valueButton1Click();
    }

    @Then("result should be same as user phrase")
    public void resultShouldBeTheSame() throws InterruptedException {
        org.junit.Assert.assertEquals("Lorem Ipsum Dolores Umbridge", BasicFirstFormPage.messageResult1Text().getText());
    }
    
    @Then("result should be the sum of two entered values")
    public void resultSum() throws InterruptedException {
        org.junit.Assert.assertEquals(5, BasicFirstFormPage.valueResult1Text().getText());
    }

    @AfterScenario
    public void shutDown(){
    	if (webDriver != null)
    		webDriver.quit();
    }
}