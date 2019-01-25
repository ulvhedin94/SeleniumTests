package junitTest;

import pageObject.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDataLoadingTests {
	private RemoteWebDriver webDriver;
	private DynamicDataLoadingDemo dynamicDataLoadingDemo;
	private String driverPath = "C:\\Users\\Karolina\\git\\SeleniumTests\\Selenium\\Chrome Driver\\chromedriver.exe";
	private Actions action;
	WebDriverWait wait;
	
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
		dynamicDataLoadingDemo = new DynamicDataLoadingDemo(webDriver, action);
		dynamicDataLoadingDemo.openUrl(DynamicDataLoadingDemo.getUrl());
		dynamicDataLoadingDemo.initializeElements(webDriver);
	}
	
	@Test
	public void clickAndWaitUntilRandomUserShowsTest() throws Exception {
		runChrome();
		dynamicDataLoadingDemo.buttonGetNewUserClick();
		wait.until(ExpectedConditions.textToBePresentInElement(dynamicDataLoadingDemo.loadingAreaGet(), "Name"));
	}
	
	@Test
	public void clickAndWaitUntilRandomUserShowsThreeTimesTest() throws Exception {
		runChrome();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		for (int i = 0; i < 3; i++) {
			dynamicDataLoadingDemo.buttonGetNewUserClick();
			wait.until(ExpectedConditions.textToBePresentInElement(dynamicDataLoadingDemo.loadingAreaGet(), "Name"));
		}
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
