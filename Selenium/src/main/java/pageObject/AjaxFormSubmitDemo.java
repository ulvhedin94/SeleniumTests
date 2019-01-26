package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxFormSubmitDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public AjaxFormSubmitDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//Ajax Form Submit elements
	private WebElement textboxNameInput;
	private WebElement textboxCommentInput;
	private WebElement submitResult;
	private WebElement buttonSubmit;
	private WebElement validationError;
	
	//Methods
	public AjaxFormSubmitDemo textboxNameInputClick() {
		textboxNameInput.click();
		return this;
	}
	
	public AjaxFormSubmitDemo textboxCommentInputClick() {
		textboxCommentInput.click();
		return this;
	}
	
	public AjaxFormSubmitDemo textboxNameInputText(String name) {
		textboxNameInput.sendKeys(name);
		return this;
	}
	
	public AjaxFormSubmitDemo textboxCommentInputText(String comment) {
		textboxCommentInput.sendKeys(comment);
		return this;
	}
	
	public AjaxFormSubmitDemo buttonSubmitClick() {
		buttonSubmit.click();
		return this;
	}
	
	public WebElement submitResultText() {
		return submitResult;
	}
	
	public WebElement buttonSubmitDisplay() {
		return buttonSubmit;
	}
	
	public WebElement validationErrorDisplay() {
		return validationError;
	}
	
	//Initialize All Elements
	public AjaxFormSubmitDemo initializeElements(RemoteWebDriver webDriver) {
		textboxNameInput = webDriver.findElement(By.xpath("//*[@id=\"title\"]"));
		textboxCommentInput = webDriver.findElement(By.xpath("//*[@id=\"description\"]"));
		submitResult = webDriver.findElement(By.xpath("//*[@id=\"submit-control\"]"));
		buttonSubmit = webDriver.findElement(By.xpath("//*[@id=\"btn-submit\"]"));
		validationError = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/span"));
		return this;
	}	
}