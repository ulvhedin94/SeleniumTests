package junitTest;

import pageObject.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BasicSelectDropdownDemoTests {
	private RemoteWebDriver webDriver;
	private BasicSelectDropdownDemo basicSelectDropdownDemo;
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
		basicSelectDropdownDemo = new BasicSelectDropdownDemo(webDriver, action);
		basicSelectDropdownDemo.openUrl(BasicSelectDropdownDemo.getUrl());
		basicSelectDropdownDemo.initializeElements(webDriver);
	}
	
	@Test
	public void selectSundayTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectSundayClick();
		
		Assert.assertEquals("Day selected :- Sunday", basicSelectDropdownDemo.messageResult1Text().getText());
	}
	
	@Test
	public void selectCaliforniaFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectCaliforniaClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectCaliforniaAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectCaliforniaClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("Options selected are : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectCaliforniaThenOhioFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectCaliforniaClick();
		basicSelectDropdownDemo.selectOhioClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("First selected option is : Ohio", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectCaliforniaThenOhioAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectCaliforniaClick();
		basicSelectDropdownDemo.selectOhioClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("First selected option is : Ohio", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithClickAndReleaseFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithClickAndRelease();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithClickAndReleaseAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithClickAndRelease();
		basicSelectDropdownDemo.buttonGetAllSelectedClick();
		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithClickAndReleaseAfterClickFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithClickAndReleaseAfterClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithClickAndReleaseAfterClickAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithClickAndReleaseAfterClick();
		basicSelectDropdownDemo.buttonGetAllSelectedClick();
		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithShiftKeyFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithShiftKey();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		Thread.sleep(3000);
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithShiftKeyAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithShiftKey();
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithCtrlKeyFirstSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithCtrlKey();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void selectAllStatesWithCtrlKeyAllSelectedTest() throws Exception {
		runChrome();
		basicSelectDropdownDemo.selectAllStatesWithCtrlKey();
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
	}
	
	@Test
	public void everythingAtOnceBasicSelectDayTest() throws Exception {
		runChrome();
		//Sunday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectSundayClick();
		
		Assert.assertEquals("Day selected :- Sunday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Monday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectMondayClick();
		
		Assert.assertEquals("Day selected :- Monday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Tuesday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectTuesdayClick();
		
		Assert.assertEquals("Day selected :- Tuesday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Wednesday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectWednesdayClick();
		
		Assert.assertEquals("Day selected :- Wednesday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Thursday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectThursdayClick();
		
		Assert.assertEquals("Day selected :- Thursday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Friday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectFridayClick();
		
		Assert.assertEquals("Day selected :- Friday", basicSelectDropdownDemo.messageResult1Text().getText());
		
		//Saturday
		basicSelectDropdownDemo.dropdownListClick();
		basicSelectDropdownDemo.selectSaturdayClick();
		
		Assert.assertEquals("Day selected :- Saturday", basicSelectDropdownDemo.messageResult1Text().getText());		
	}
	
	@Ignore
	public void everythingAtOnceMultiSelectStatesTest() throws Exception {
		runChrome();
		//First State - California
		basicSelectDropdownDemo.selectCaliforniaClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();

		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
		
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California", basicSelectDropdownDemo.messageResult2Text().getText());
		
		//Second State - Ohio
		basicSelectDropdownDemo.selectOhioClick();
		basicSelectDropdownDemo.buttonFirstSelectedClick();

		Assert.assertEquals("First selected option is : Ohio", basicSelectDropdownDemo.messageResult2Text().getText());
		
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : Ohio", basicSelectDropdownDemo.messageResult2Text().getText());
		
		//Select All States - Click And Release
		basicSelectDropdownDemo.selectAllStatesWithClickAndRelease();
		basicSelectDropdownDemo.buttonFirstSelectedClick();

		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
		
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
		
		//Select All States - Shift Key
		basicSelectDropdownDemo.selectAllStatesWithShiftKey();
		basicSelectDropdownDemo.buttonFirstSelectedClick();

		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
		
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());
		
		//Select All States - Control Key
		basicSelectDropdownDemo.selectAllStatesWithCtrlKey();
		basicSelectDropdownDemo.buttonFirstSelectedClick();
		
		Assert.assertEquals("First selected option is : California", basicSelectDropdownDemo.messageResult2Text().getText());
		
		basicSelectDropdownDemo.buttonGetAllSelectedClick();

		Assert.assertEquals("Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington", basicSelectDropdownDemo.messageResult2Text().getText());	
	}
	
	@After
	public void tearDown() throws Exception {

		//webDriver.close();
		webDriver.quit();
	}
}
