package com.seleniumeasy.functionalTests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.data.Data;

import org.openqa.selenium.interactions.Actions;

public class TableRecordsFilterDemo extends BasePage{
	private static String pageUrl = "/table-records-filter-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public TableRecordsFilterDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return Data.URL+pageUrl;
	}
	
	//Filter Records elements
	private WebElement checkbox1;
	private WebElement star1;
	private WebElement checkbox2;
	private WebElement star2;
	private WebElement checkbox3;
	private WebElement star3;
	private WebElement checkbox4;
	private WebElement star4;
	private WebElement checkbox5;
	private WebElement star5;
	private WebElement buttonGreen;
	private WebElement buttonOrange;
	private WebElement buttonRed;
	private WebElement buttonAll;
	private WebElement container1;
	private WebElement container2;
	private WebElement container3;
	private WebElement container4;
	private WebElement container5;
	
	//Methods
	public TableRecordsFilterDemo checkbox1Click() {
		checkbox1.click();
		return this;
	}
	
	public TableRecordsFilterDemo checkbox2Click() {
		checkbox2.click();
		return this;
	}
	
	public TableRecordsFilterDemo checkbox3Click() {
		checkbox3.click();
		return this;
	}
	
	public TableRecordsFilterDemo checkbox4Click() {
		checkbox4.click();
		return this;
	}
	
	public TableRecordsFilterDemo checkbox5Click() {
		checkbox5.click();
		return this;
	}
	
	public TableRecordsFilterDemo star1Click() {
		star1.click();
		return this;
	}
	
	public TableRecordsFilterDemo star2Click() {
		star2.click();
		return this;
	}
	
	public TableRecordsFilterDemo star3Click() {
		star3.click();
		return this;
	}
	
	public TableRecordsFilterDemo star4Click() {
		star4.click();
		return this;
	}
	
	public TableRecordsFilterDemo star5Click() {
		star5.click();
		return this;
	}
	
	public TableRecordsFilterDemo buttonGreenClick() {
		buttonGreen.click();
		return this;
	}
	
	public TableRecordsFilterDemo buttonOrangeClick() {
		buttonOrange.click();
		return this;
	}
	
	public TableRecordsFilterDemo buttonRedClick() {
		buttonRed.click();
		return this;
	}
	
	public TableRecordsFilterDemo buttonAllClick() {
		buttonAll.click();
		return this;
	}
	
	public WebElement container1Display() {
		return container1;
	}
	
	public WebElement container2Display() {
		return container2;
	}
	
	public WebElement container3Display() {
		return container3;
	}
	
	public WebElement container4Display() {
		return container4;
	}
	
	public WebElement container5Display() {
		return container5;
	}
	
	public WebElement star1IsChecked() {
		return star1;
	}
	
	public WebElement star2IsChecked() {
		return star2;
	}
	
	public WebElement star3IsChecked() {
		return star3;
	}
	
	public WebElement star4IsChecked() {
		return star4;
	}
	
	public WebElement star5IsChecked() {
		return star5;
	}
	
	//Initialize All Elements
	public TableRecordsFilterDemo initializeElements(RemoteWebDriver webDriver) {
		star1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a"));
		star2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/a"));
		star3 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[3]/td[2]/a"));
		star4 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[4]/td[2]/a"));
		star5 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[5]/td[2]/a"));
		checkbox1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/div"));
		checkbox2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]/div"));
		checkbox3 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[3]/td[1]/div"));
		checkbox4 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[4]/td[1]/div"));
		checkbox5 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[5]/td[1]/div"));
		buttonGreen = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[1]/div/button[1]"));
		buttonOrange = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[1]/div/button[2]"));
		buttonRed = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[1]/div/button[3]"));
		buttonAll = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[1]/div/button[4]"));
		container1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[1]"));
		container2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[2]"));
		container3 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[3]"));
		container4 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[4]"));
		container5 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table/tbody/tr[5]"));
		return this;
	}	
}