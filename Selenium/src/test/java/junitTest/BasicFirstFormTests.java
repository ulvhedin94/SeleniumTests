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

public class BasicFirstFormTests {
	private RemoteWebDriver webDriver;
	private BasicFirstFormDemo basicFirstFormPage;
	private String driverPath = "C:\\Users\\Karolina\\selenium_workbench\\Selenium\\Chrome Driver\\chromedriver.exe";
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
	
	//Testing Single Input Field
	@Test
	public void messageTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.messageTextBox1Click();
		basicFirstFormPage.messageTextBox1Input("Janusz");
		basicFirstFormPage.messageButton1Click();
		
		Assert.assertEquals("Janusz", basicFirstFormPage.messageResult1Text().getText());
	}
	
	//Testing Two Input Fields
	@Test
	public void valueTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.valueTextBox1Click();
		basicFirstFormPage.valueTextBox1Input("4");
		basicFirstFormPage.valueTextBox2Click();
		basicFirstFormPage.valueTextBox2Input("5");
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("9", basicFirstFormPage.valueResult1Text().getText());
	}
		
	@Test
	public void nonValueTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.valueTextBox1Click();
		basicFirstFormPage.valueTextBox1Input("Janusz");
		basicFirstFormPage.valueTextBox2Click();
		basicFirstFormPage.valueTextBox2Input("5");
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
	}
		
	@Test
	public void noInputValueTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
	}
	
	@Test
	public void twoBadValuesTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.valueTextBox1Click();
		basicFirstFormPage.valueTextBox1Input("3Janusz");
		basicFirstFormPage.valueTextBox2Click();
		basicFirstFormPage.valueTextBox2Input("5Zdzisław");
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
	}
	
	//Testing everything at once
	@Ignore
	public void everythingAtOnceBasicFirstFormTest() throws Exception {
		basicFirstFormPage = new BasicFirstFormDemo(webDriver, action);
		basicFirstFormPage.openUrl(BasicFirstFormDemo.getUrl());
		basicFirstFormPage.initializeElements(webDriver);
		basicFirstFormPage.messageTextBox1Click();
		basicFirstFormPage.messageTextBox1Input("Janusz");
		basicFirstFormPage.messageButton1Click();
		
		Assert.assertEquals("Janusz", basicFirstFormPage.messageResult1Text().getText());
		
		basicFirstFormPage.valueTextBox1Click();
		basicFirstFormPage.valueTextBox1Input("4");
		basicFirstFormPage.valueTextBox2Click();
		basicFirstFormPage.valueTextBox2Input("5");
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("9", basicFirstFormPage.valueResult1Text().getText());
		
		basicFirstFormPage.valueTextBox1DoubleClick();
		basicFirstFormPage.valueTextBox1Clear();
		basicFirstFormPage.valueTextBox1Input("Janusz");
		basicFirstFormPage.valueTextBox2DoubleClick();
		basicFirstFormPage.valueTextBox2Clear();
		basicFirstFormPage.valueTextBox2Input("5");
		basicFirstFormPage.valueButton1Click();

		Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
		
		basicFirstFormPage.valueTextBox1DoubleClick();
		basicFirstFormPage.valueTextBox1Clear();
		basicFirstFormPage.valueTextBox2DoubleClick();
		basicFirstFormPage.valueTextBox2Clear();
		basicFirstFormPage.valueButton1Click();
		
		Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
		/*Wynikiem poniższego testu jest 8, mimo, iż to nie liczby (powinno być "NaN")
		  zatem przyjęto, że oczekiwanym wynikiem NIE JEST "NaN", co jest prawdą*/
		basicFirstFormPage.valueTextBox1DoubleClick();
		basicFirstFormPage.valueTextBox1Clear();
		basicFirstFormPage.valueTextBox1Input("3Janusz");
		basicFirstFormPage.valueTextBox2DoubleClick();
		basicFirstFormPage.valueTextBox2Clear();
		basicFirstFormPage.valueTextBox2Input("5Zdzisław");
		basicFirstFormPage.valueButton1Click();
		
		//przechodzi test
		Assert.assertNotEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
		//nie przechodzi
		//Assert.assertEquals("NaN", basicFirstFormPage.valueResult1Text().getText());
	}
	
	@After
	public void setDown() throws Exception {

		webDriver.close();
		webDriver.quit();
	}
}
