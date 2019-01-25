package junitTest;

import pageObject.*;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapAlertMessagesTests {
	private RemoteWebDriver webDriver;
	private BootstrapAlertMessagesDemo bootstrapAlertMessagesPage;
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
		bootstrapAlertMessagesPage = new BootstrapAlertMessagesDemo(webDriver, action);
		bootstrapAlertMessagesPage.openUrl(BootstrapAlertMessagesDemo.getUrl());
		bootstrapAlertMessagesPage.initializeElements(webDriver);
	}
	
	//Success Tests:
	@Test
	public void normalSuccessAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonNormalSuccessClick();
		
		Assert.assertEquals("I'm a normal success message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalSuccessText().getText().split("\n")[1]);
	}
	
	@Test
	public void normalSuccessAlertWithCloseButtonTest() throws Exception {
		runChrome();

		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalSuccessIsDisplayed());

		bootstrapAlertMessagesPage.buttonNormalSuccessClick();

		Assert.assertEquals("I'm a normal success message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalSuccessText().getText().split("\n")[1]);
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalSuccessIsDisplayed());

		bootstrapAlertMessagesPage.exitNormalSuccessClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalSuccessIsDisplayed());
	}
	
	@Test
	public void autocloseableSuccessAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoSuccessClick();	

		Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoSuccessText().getText());
		
	}
	
	@Test
	public void autocloseableSuccessAlertCheckDisabledButtonTest() throws Exception {
		runChrome();
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoSuccessIsEnabled());
		
		bootstrapAlertMessagesPage.buttonAutoSuccessClick();	

		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoSuccessIsEnabled());
	}
	
	@Test
	public void autocloseableSuccessAlertWaitUntilDisplayedTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoSuccessClick();

		Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoSuccessText().getText());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoSuccessIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));

		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoSuccessIsDisplayed());
	}
	
	//Warning Tests:
	@Test
	public void normalWarningAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonNormalWarningClick();
		
		Assert.assertEquals("I'm a normal warning message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalWarningText().getText().split("\n")[1]);
	}
	
	@Test
	public void normalWarningAlertWithCloseButtonTest() throws Exception {
		runChrome();

		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalWarningIsDisplayed());

		bootstrapAlertMessagesPage.buttonNormalWarningClick();

		Assert.assertEquals("I'm a normal warning message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalWarningText().getText().split("\n")[1]);
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalWarningIsDisplayed());

		bootstrapAlertMessagesPage.exitNormalWarningClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalWarningIsDisplayed());
	}
	
	@Test
	public void autocloseableWarningAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoWarningClick();	

		Assert.assertEquals("I'm an autocloseable warning message. I will hide in 3 seconds.", bootstrapAlertMessagesPage.alertAutoWarningText().getText());
	}
	
	@Test
	public void autocloseableWarningAlertCheckDisabledButtonTest() throws Exception {
		runChrome();
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoWarningIsEnabled());
		
		bootstrapAlertMessagesPage.buttonAutoWarningClick();	

		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoWarningIsEnabled());
	}
	
	@Test
	public void autocloseableWarningAlertWait3SecondsTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoWarningClick();

		Assert.assertEquals("I'm an autocloseable warning message. I will hide in 3 seconds.", bootstrapAlertMessagesPage.alertAutoWarningText().getText());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoWarningIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")));
		
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoWarningIsDisplayed());
	}
	
	//Danger Tests:
	@Test
	public void normalDangerAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonNormalDangerClick();
		
		Assert.assertEquals("I'm a normal danger message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalDangerText().getText().split("\n")[1]);
	}
	
	@Test
	public void normalDangerAlertWithCloseButtonTest() throws Exception {
		runChrome();

		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalDangerIsDisplayed());

		bootstrapAlertMessagesPage.buttonNormalDangerClick();

		Assert.assertEquals("I'm a normal danger message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalDangerText().getText().split("\n")[1]);
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalDangerIsDisplayed());

		bootstrapAlertMessagesPage.exitNormalDangerClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalDangerIsDisplayed());
	}
	
	@Test
	public void autocloseableDangerAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoDangerClick();	

		Assert.assertEquals("I'm an autocloseable danger message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoDangerText().getText());
	}
	
	@Test
	public void autocloseableDangerAlertCheckDisabledButtonTest() throws Exception {
		runChrome();
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoDangerIsEnabled());
		
		bootstrapAlertMessagesPage.buttonAutoDangerClick();	

		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoDangerIsEnabled());
	}
	
	@Test
	public void autocloseableDangerAlertWait5SecondsTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoDangerClick();

		Assert.assertEquals("I'm an autocloseable danger message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoDangerText().getText());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoDangerIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")));
		
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoDangerIsDisplayed());
	}
	
	//Info Tests:
	@Test
	public void normalInfoAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonNormalInfoClick();
	
		Assert.assertEquals("I'm a normal info message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalInfoText().getText().split("\n")[1]);
	}
	
	@Test
	public void normalInfoAlertWithCloseButtonTest() throws Exception {
		runChrome();

		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalInfoIsDisplayed());

		bootstrapAlertMessagesPage.buttonNormalInfoClick();

		Assert.assertEquals("I'm a normal info message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalInfoText().getText().split("\n")[1]);
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalInfoIsDisplayed());

		bootstrapAlertMessagesPage.exitNormalInfoClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalInfoIsDisplayed());
	}
	
	@Test
	public void autocloseableInfoAlertTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoInfoClick();	

		Assert.assertEquals("I'm an autocloseable info message. I will hide in 6 seconds.", bootstrapAlertMessagesPage.alertAutoInfoText().getText());
	}
	
	@Test
	public void autocloseableInfoAlertCheckDisabledButtonTest() throws Exception {
		runChrome();
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoInfoIsEnabled());
		
		bootstrapAlertMessagesPage.buttonAutoInfoClick();	

		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoInfoIsEnabled());
	}
	
	@Test
	public void autocloseableInfoAlertWait6SecondsTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoInfoClick();

		Assert.assertEquals("I'm an autocloseable info message. I will hide in 6 seconds.", bootstrapAlertMessagesPage.alertAutoInfoText().getText());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoInfoIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")));
		
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoInfoIsDisplayed());
	}
	
	//All Alerts Test:
	@Test
	public void allAlertsTest() throws Exception {
		runChrome();
		bootstrapAlertMessagesPage.buttonAutoSuccessClick();
		bootstrapAlertMessagesPage.buttonNormalSuccessClick();
		bootstrapAlertMessagesPage.buttonAutoWarningClick();
		bootstrapAlertMessagesPage.buttonNormalWarningClick();
		bootstrapAlertMessagesPage.buttonAutoDangerClick();
		bootstrapAlertMessagesPage.buttonNormalDangerClick();
		bootstrapAlertMessagesPage.buttonAutoInfoClick();
		bootstrapAlertMessagesPage.buttonNormalInfoClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoSuccessIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoWarningIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoDangerIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.buttonAutoInfoIsEnabled());
		
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoSuccessIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoWarningIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoDangerIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.alertAutoInfoIsDisplayed());
		
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalSuccessIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalWarningIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalDangerIsDisplayed());
		Assert.assertTrue(bootstrapAlertMessagesPage.exitNormalInfoIsDisplayed());
		
		Assert.assertEquals("I'm a normal success message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalSuccessText().getText().split("\n")[1]);
		Assert.assertEquals("I'm a normal warning message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalWarningText().getText().split("\n")[1]);
		Assert.assertEquals("I'm a normal danger message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalDangerText().getText().split("\n")[1]);
		Assert.assertEquals("I'm a normal info message. To close use the appropriate button.", bootstrapAlertMessagesPage.alertNormalInfoText().getText().split("\n")[1]);
		
		Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoSuccessText().getText());
		Assert.assertEquals("I'm an autocloseable warning message. I will hide in 3 seconds.", bootstrapAlertMessagesPage.alertAutoWarningText().getText());
		Assert.assertEquals("I'm an autocloseable danger message. I will hide in 5 seconds.", bootstrapAlertMessagesPage.alertAutoDangerText().getText());
		Assert.assertEquals("I'm an autocloseable info message. I will hide in 6 seconds.", bootstrapAlertMessagesPage.alertAutoInfoText().getText());
		
		bootstrapAlertMessagesPage.exitNormalSuccessClick();
		bootstrapAlertMessagesPage.exitNormalWarningClick();
		bootstrapAlertMessagesPage.exitNormalDangerClick();
		bootstrapAlertMessagesPage.exitNormalInfoClick();
		
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalSuccessIsDisplayed());
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalWarningIsDisplayed());
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalDangerIsDisplayed());
		Assert.assertFalse(bootstrapAlertMessagesPage.exitNormalInfoIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")));
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoWarningIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoWarningIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoSuccessIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoSuccessIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")));
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoDangerIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoDangerIsDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")));
		
		Assert.assertTrue(bootstrapAlertMessagesPage.buttonAutoInfoIsEnabled());
		Assert.assertFalse(bootstrapAlertMessagesPage.alertAutoInfoIsDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
