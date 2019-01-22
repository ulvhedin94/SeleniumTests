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

public class BootstrapDualListBoxTests {
	private RemoteWebDriver webDriver;
	private BootstrapDualListBoxDemo bootstrapDualListBoxDemo;
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
		bootstrapDualListBoxDemo = new BootstrapDualListBoxDemo(webDriver, action);
		bootstrapDualListBoxDemo.openUrl(BootstrapDualListBoxDemo.getUrl());
		bootstrapDualListBoxDemo.initializeElements(webDriver);
	}
	
	@Test
	public void Test() throws Exception {
		runChrome();
		bootstrapDualListBoxDemo.listGroup1ElementClick(1);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		
		bootstrapDualListBoxDemo.getActualListBoxesXpath(webDriver);
		
		Assert.assertEquals(4, bootstrapDualListBoxDemo.listGroup1Size());
		Assert.assertEquals(6, bootstrapDualListBoxDemo.listGroup2Size());
		Assert.assertEquals("Dapibus ac facilisis in", bootstrapDualListBoxDemo.listGroup2Element(5).getText());
		
	}
	
	@Test
	public void emptyListGroup1ThenGroup2AndSizeTest() throws Exception {
		runChrome();
		bootstrapDualListBoxDemo.listGroup1ElementClick(0);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		bootstrapDualListBoxDemo.listGroup1ElementClick(1);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		bootstrapDualListBoxDemo.listGroup1ElementClick(2);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		bootstrapDualListBoxDemo.listGroup1ElementClick(3);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		bootstrapDualListBoxDemo.listGroup1ElementClick(4);
		bootstrapDualListBoxDemo.buttonToRightBoxClick();
		bootstrapDualListBoxDemo.getActualListBoxesXpath(webDriver);

		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup1IsEmpty());
		Assert.assertEquals(10, bootstrapDualListBoxDemo.listGroup2Size());

		bootstrapDualListBoxDemo.buttonSelectAllBox2Click();
		bootstrapDualListBoxDemo.buttonToLeftBoxClick();
		bootstrapDualListBoxDemo.getActualListBoxesXpath(webDriver);

		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup2IsEmpty());
		Assert.assertEquals(10, bootstrapDualListBoxDemo.listGroup1Size());
	}
	@Test
	public void twoRowsToLeftCheckIfListGroup2ContainsStringIsDisplayedTest() throws Exception {
		runChrome();
		bootstrapDualListBoxDemo.listGroup2ElementClick(1);
		bootstrapDualListBoxDemo.listGroup2ElementClick(2);
		bootstrapDualListBoxDemo.buttonToLeftBoxClick();
		bootstrapDualListBoxDemo.getActualListBoxesXpath(webDriver);
		
		Assert.assertEquals(3, bootstrapDualListBoxDemo.listGroup2Size());
		
		bootstrapDualListBoxDemo.searchInput2Click();
		bootstrapDualListBoxDemo.searchInput2Text("i");
		
		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup2Element(0).getText().contains("i"));
		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup2Element(0).isDisplayed());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup2Element(1).getText().contains("i"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup2Element(1).isDisplayed());
		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup2Element(2).getText().contains("i"));
		Assert.assertTrue(bootstrapDualListBoxDemo.listGroup2Element(2).isDisplayed());
	}
	@Test
	public void checkIfRowContainsStringIsDisplayedTest() throws Exception {
		runChrome();
		bootstrapDualListBoxDemo.searchInput1Click();
		bootstrapDualListBoxDemo.searchInput1Text("@");
		
		Assert.assertEquals(5, bootstrapDualListBoxDemo.listGroup1Size());
		Assert.assertEquals(5, bootstrapDualListBoxDemo.listGroup2Size());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(0).getText().contains("@"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(0).isDisplayed());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(1).getText().contains("@"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(1).isDisplayed());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(2).getText().contains("@"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(2).isDisplayed());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(3).getText().contains("@"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(3).isDisplayed());
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(4).getText().contains("@"));
		Assert.assertFalse(bootstrapDualListBoxDemo.listGroup1Element(4).isDisplayed());
	}
	@After
	public void tearDown() throws Exception {
		if (webDriver != null)
			webDriver.quit();
	}
}
