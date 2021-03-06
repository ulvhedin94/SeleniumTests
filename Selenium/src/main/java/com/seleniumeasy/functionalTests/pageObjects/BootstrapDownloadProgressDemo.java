package com.seleniumeasy.functionalTests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.seleniumeasy.functionalTests.data.Data;

import org.openqa.selenium.interactions.Actions;

public class BootstrapDownloadProgressDemo extends BasePage{
	private static String pageUrl = "/bootstrap-download-progress-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public BootstrapDownloadProgressDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return Data.URL+pageUrl;
	}
	
	//Progress Bar for Download elements
	private WebElement buttonDownload;
	private WebElement progressCircle;
	private WebElement downloadProgressResult;
	//Methods
	public BootstrapDownloadProgressDemo buttonDownloadClick() {
		buttonDownload.click();
		return this;
	}
	
	public WebElement buttonDownloadGet() {
		return buttonDownload;
	}
	
	public WebElement progressCircleGet() {
		return progressCircle;
	}
	
	public WebElement downloadProgressResultText() {
		return downloadProgressResult;
	}
	
	//Initialize All Elements
	public BootstrapDownloadProgressDemo initializeElements(RemoteWebDriver webDriver) {
		buttonDownload = webDriver.findElement(By.xpath("//*[@id=\"cricle-btn\"]"));
		progressCircle = webDriver.findElement(By.xpath("//*[@id=\"circle\"]"));
		downloadProgressResult = webDriver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]"));
		return this;
	}	
}