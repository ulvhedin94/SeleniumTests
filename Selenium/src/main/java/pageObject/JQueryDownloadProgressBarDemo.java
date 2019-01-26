package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryDownloadProgressBarDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public JQueryDownloadProgressBarDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//JQuery UI Progress Bar elements
	private WebElement buttonDownload;
	private WebElement buttonClose;
	private WebElement downloadDialog;
	private WebElement downloadProgressResult;
	
	//Methods
	public JQueryDownloadProgressBarDemo buttonDownloadClick() {
		buttonDownload.click();
		return this;
	}
	
	public JQueryDownloadProgressBarDemo buttonCloseClick() {
		buttonClose.click();
		return this;
	}
	
	public WebElement buttonCloseText() {
		return buttonClose;
	}
	
	public WebElement downloadDialogDisplay() {
		return downloadDialog;
	}
	
	public WebElement downloadProgressResultDisplay() {
		return downloadProgressResult;
	}
	
	public JQueryDownloadProgressBarDemo resetCancelButton(RemoteWebDriver webDriver) {
		buttonClose = webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
		downloadDialog = webDriver.findElement(By.xpath("/html/body/div[3]"));
		return this;
	}
	
	//Initialize All Elements
	public JQueryDownloadProgressBarDemo initializeElements(RemoteWebDriver webDriver) {
		buttonDownload = webDriver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
		buttonClose = webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
		downloadDialog = webDriver.findElement(By.xpath("/html/body/div[3]"));
		downloadProgressResult = webDriver.findElement(By.xpath("//*[@id=\"dialog\"]/div[1]"));
		return this;
	}	
}