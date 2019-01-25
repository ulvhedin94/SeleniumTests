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

public class BootstrapDownloadProgressTests {
	private RemoteWebDriver webDriver;
	private BootstrapDownloadProgressDemo bootstrapDownloadProgressDemo;
	private String driverPath = "C:\\Users\\Karolina\\git\\SeleniumTests\\Selenium\\Chrome Driver\\chromedriver.exe";
	private Actions action;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		webDriver = new ChromeDriver();
		action = new Actions(webDriver);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	//Open Chrome
	private void runChrome() {
		bootstrapDownloadProgressDemo = new BootstrapDownloadProgressDemo(webDriver, action);
		bootstrapDownloadProgressDemo.openUrl(BootstrapDownloadProgressDemo.getUrl());
		bootstrapDownloadProgressDemo.initializeElements(webDriver);
	}
	
	@Test
	public void clickAndWaitUntilProgressFinishByTextTest() throws Exception {
		runChrome();
		
		Assert.assertFalse(bootstrapDownloadProgressDemo.buttonDownloadGet().getAttribute("class").contains("active"));
		
		bootstrapDownloadProgressDemo.buttonDownloadClick();
		
		Assert.assertTrue(bootstrapDownloadProgressDemo.buttonDownloadGet().getAttribute("class").contains("active"));
		
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(bootstrapDownloadProgressDemo.downloadProgressResultText(), "100%"));
		
		Assert.assertEquals("100%", bootstrapDownloadProgressDemo.downloadProgressResultText().getText());

	}
	
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
