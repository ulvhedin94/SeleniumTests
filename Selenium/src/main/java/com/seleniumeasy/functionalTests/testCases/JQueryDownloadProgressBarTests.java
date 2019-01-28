package com.seleniumeasy.functionalTests.testCases;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumeasy.functionalTests.data.Data;
import com.seleniumeasy.functionalTests.pageObjects.*;

public class JQueryDownloadProgressBarTests {
	private RemoteWebDriver webDriver;
	private JQueryDownloadProgressBarDemo jqueryDownloadProgressBarDemo;
	private Actions action;
	private WebDriverWait wait;
	private WebElement resetCancelButton;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", Data.DRIVER_PATH);
		webDriver = new ChromeDriver();
		action = new Actions(webDriver);
		wait = new WebDriverWait(webDriver, Data.defaultTimeout);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public WebElement resetCancelButtonText() {
		return resetCancelButton;
	}
	
	//Open Chrome
	private void runChrome() {
		jqueryDownloadProgressBarDemo = new JQueryDownloadProgressBarDemo(webDriver, action);
		jqueryDownloadProgressBarDemo.openUrl(JQueryDownloadProgressBarDemo.getUrl());
		jqueryDownloadProgressBarDemo.initializeElements(webDriver);
	}
	
	@Test
	public void downloadThenCancelTest() throws Exception {
		runChrome();
		jqueryDownloadProgressBarDemo.buttonDownloadClick();
		
		Assert.assertTrue(jqueryDownloadProgressBarDemo.downloadDialogDisplay().isDisplayed());
		
		//Thread.sleep(3000);
		
		Assert.assertEquals("Cancel Download", jqueryDownloadProgressBarDemo.buttonCloseText().getText());

		jqueryDownloadProgressBarDemo.buttonCloseClick();
		
		Assert.assertFalse(jqueryDownloadProgressBarDemo.downloadDialogDisplay().isDisplayed());
	}
	
	@Test
	public void downloadThenWaitForCompleteTest() throws Exception {
		runChrome();
		jqueryDownloadProgressBarDemo.buttonDownloadClick();
		
		Assert.assertTrue(jqueryDownloadProgressBarDemo.downloadDialogDisplay().isDisplayed());
		
		wait.until(ExpectedConditions.textToBePresentInElement(jqueryDownloadProgressBarDemo.downloadProgressResultDisplay(), "Complete!"));
		resetCancelButton = webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
		
		Assert.assertEquals("Close", resetCancelButtonText().getText());
		
		resetCancelButton.click();
		
		Assert.assertFalse(jqueryDownloadProgressBarDemo.downloadDialogDisplay().isDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
