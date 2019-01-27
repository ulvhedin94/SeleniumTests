package com.seleniumeasy.functionalTests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.data.Data;

import org.openqa.selenium.interactions.Actions;

public class DynamicDataLoadingDemo extends BasePage{
	private static String pageUrl = "/dynamic-data-loading-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public DynamicDataLoadingDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return Data.URL+pageUrl;
	}
	
	//Get Random User elements
	private WebElement buttonGetNewUser;
	private WebElement loadingArea;
	
	//Methods
	public DynamicDataLoadingDemo buttonGetNewUserClick() {
		buttonGetNewUser.click();
		return this;
	}
	
	public WebElement loadingAreaGet() {
		return loadingArea;
	}
	
	public DynamicDataLoadingDemo test(){
		return this;
	}
	
	//Initialize All Elements
	public DynamicDataLoadingDemo initializeElements(RemoteWebDriver webDriver) {
		buttonGetNewUser = webDriver.findElement(By.xpath("//*[@id=\"save\"]"));
		loadingArea = webDriver.findElement(By.xpath("//*[@id=\"loading\"]"));
		return this;
	}	
}