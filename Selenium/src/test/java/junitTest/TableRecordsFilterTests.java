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

public class TableRecordsFilterTests {
	private RemoteWebDriver webDriver;
	private TableRecordsFilterDemo tableRecordsFilterDemo;
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
		tableRecordsFilterDemo = new TableRecordsFilterDemo(webDriver, action);
		tableRecordsFilterDemo.openUrl(TableRecordsFilterDemo.getUrl());
		tableRecordsFilterDemo.initializeElements(webDriver);
	}
	
	@Test
	public void checkGreenOnlyTest() throws Exception {
		runChrome();
		
		tableRecordsFilterDemo.buttonGreenClick();
		wait.until(ExpectedConditions.visibilityOf(tableRecordsFilterDemo.container1Display()));
		
		Assert.assertTrue(tableRecordsFilterDemo.container1Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container4Display().isDisplayed());
	}
	
	@Test
	public void checkOrangeOnlyTest() throws Exception {
		runChrome();
		
		tableRecordsFilterDemo.buttonOrangeClick();
		wait.until(ExpectedConditions.visibilityOf(tableRecordsFilterDemo.container2Display()));
		
		Assert.assertTrue(tableRecordsFilterDemo.container2Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container5Display().isDisplayed());
	}
	
	@Test
	public void checkRedOnlyTest() throws Exception {
		runChrome();
		
		tableRecordsFilterDemo.buttonRedClick();
		wait.until(ExpectedConditions.visibilityOf(tableRecordsFilterDemo.container3Display()));
		
		Assert.assertTrue(tableRecordsFilterDemo.container3Display().isDisplayed());
	}
	
	@Test
	public void redThenAllTest() throws Exception {
		runChrome();
		
		tableRecordsFilterDemo.buttonRedClick();
		wait.until(ExpectedConditions.visibilityOf(tableRecordsFilterDemo.container3Display()));
		
		Assert.assertTrue(tableRecordsFilterDemo.container3Display().isDisplayed());
		
		tableRecordsFilterDemo.buttonAllClick();
		wait.until(ExpectedConditions.visibilityOf(tableRecordsFilterDemo.container1Display()));
		
		Assert.assertTrue(tableRecordsFilterDemo.container1Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container2Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container3Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container4Display().isDisplayed());
		Assert.assertTrue(tableRecordsFilterDemo.container5Display().isDisplayed());
	}
	
	@Test
	public void checkIfTwoStarsAndTwoCheckboxesAreCheckedTest() throws Exception {
		runChrome();
		tableRecordsFilterDemo.checkbox1Click();
		tableRecordsFilterDemo.checkbox2Click();
		tableRecordsFilterDemo.star3Click();
		tableRecordsFilterDemo.star5Click();
		
		Assert.assertTrue(tableRecordsFilterDemo.container1Display().getAttribute("class").contains("selected"));
		Assert.assertTrue(tableRecordsFilterDemo.container2Display().getAttribute("class").contains("selected"));
		Assert.assertTrue(tableRecordsFilterDemo.star3IsChecked().getAttribute("class").contains("checked"));
		Assert.assertTrue(tableRecordsFilterDemo.star5IsChecked().getAttribute("class").contains("checked"));
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
