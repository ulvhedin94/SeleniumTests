package junitTest;

import pageObject.*;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxFormSubmitTests {
	private RemoteWebDriver webDriver;
	private AjaxFormSubmitDemo ajaxFormSubmitDemo;
	private String driverPath = "C:\\Users\\Karolina\\git\\SeleniumTests\\Selenium\\Chrome Driver\\chromedriver.exe";
	private Actions action;
	private WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		webDriver = new ChromeDriver();
		action = new Actions(webDriver);
		wait = new WebDriverWait(webDriver, 10);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	//Open Chrome
	private void runChrome() {
		ajaxFormSubmitDemo = new AjaxFormSubmitDemo(webDriver, action);
		ajaxFormSubmitDemo.openUrl(AjaxFormSubmitDemo.getUrl());
		ajaxFormSubmitDemo.initializeElements(webDriver);
	}
	
	@Test
	public void enterDataAndWaitTest() throws Exception {
		runChrome();
		ajaxFormSubmitDemo.textboxNameInputClick();
		ajaxFormSubmitDemo.textboxNameInputText("Lorem Ipsum Dolores Umbridge");
		ajaxFormSubmitDemo.textboxCommentInputClick();
		ajaxFormSubmitDemo.textboxCommentInputText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		ajaxFormSubmitDemo.buttonSubmitClick();
		wait.until(ExpectedConditions.textToBePresentInElement(ajaxFormSubmitDemo.submitResultText(), "Form submited Successfully!"));
		
		Assert.assertEquals("Form submited Successfully!", ajaxFormSubmitDemo.submitResultText().getText());
	}
	
	@Test
	public void enterNothingValidationTest() throws Exception {
		runChrome();
		ajaxFormSubmitDemo.buttonSubmitClick();
		
		Assert.assertEquals("*", ajaxFormSubmitDemo.validationErrorDisplay().getText());
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
