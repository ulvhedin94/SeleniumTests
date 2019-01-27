package com.seleniumeasy.functionalTests.pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage 
{
    private RemoteWebDriver rwd;
    
    public BasePage(RemoteWebDriver rwd) {
    	this.rwd = rwd;
    }
    
    public BasePage openUrl(String url) {
    	rwd.get(url);
    	return this;
    }
}
