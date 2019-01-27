package com.seleniumeasy.functionalTests.testCases;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.data.Data;
import com.seleniumeasy.functionalTests.pageObjects.*;

public class TablePaginationTests {
	private RemoteWebDriver webDriver;
	private TablePaginationDemo tablePaginationDemo;
	private Actions action;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", Data.DRIVER_PATH);
		webDriver = new ChromeDriver();
		action = new Actions(webDriver);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	//Open Chrome
	private void runChrome() {
		tablePaginationDemo = new TablePaginationDemo(webDriver, action);
		tablePaginationDemo.openUrl(TablePaginationDemo.getUrl());
		tablePaginationDemo.initializeElements(webDriver);
	}
	
	@Test
	public void buttonsPerPageDisplayTest() throws Exception {
		runChrome();
		
		Assert.assertFalse(tablePaginationDemo.buttonPreviousPageDisplay().isDisplayed());
		Assert.assertTrue(tablePaginationDemo.buttonNextPageDisplay().isDisplayed());
		
		tablePaginationDemo.buttonNextPageClick();
		
		Assert.assertTrue(tablePaginationDemo.buttonPreviousPageDisplay().isDisplayed());
		
		tablePaginationDemo.buttonNextPageClick();
		
		Assert.assertFalse(tablePaginationDemo.buttonNextPageDisplay().isDisplayed());
	}
	
	@Test
	public void checkEnabledAndDisabledRows() throws Exception {
		runChrome();
		
		Assert.assertEquals(13, tablePaginationDemo.listGroupSize());
		
		for (int i = 0; i < tablePaginationDemo.listGroupSize(); i++) {
			Assert.assertTrue(tablePaginationDemo.listGroupElement(i).isDisplayed());
			
			if ((i+1) % 5 == 0)
			{
				Assert.assertFalse(tablePaginationDemo.listGroupElement(i+1).isDisplayed());
				tablePaginationDemo.buttonNextPageClick();
				Assert.assertFalse(tablePaginationDemo.listGroupElement(i).isDisplayed());
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
