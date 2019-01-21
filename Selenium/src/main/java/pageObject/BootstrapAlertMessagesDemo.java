package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapAlertMessagesDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public BootstrapAlertMessagesDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//Bootstrap alert messages elements
	private WebElement buttonAutocloseableSuccess;
	private WebElement buttonNormalSuccess;
	private WebElement buttonAutocloseableWarning;
	private WebElement buttonNormalWarning;
	private WebElement buttonAutocloseableDanger;
	private WebElement buttonNormalDanger;
	private WebElement buttonAutocloseableInfo;
	private WebElement buttonNormalInfo;
	private WebElement alertAutocloseableSuccess;
	private WebElement alertNormalSuccess;
	private WebElement alertAutocloseableWarning;
	private WebElement alertNormalWarning;
	private WebElement alertAutocloseableDanger;
	private WebElement alertNormalDanger;
	private WebElement alertAutocloseableInfo;
	private WebElement alertNormalInfo;
	private WebElement exitNormalSuccess;
	private WebElement exitNormalWarning;
	private WebElement exitNormalDanger;
	private WebElement exitNormalInfo;
	
	//BootstrapAlertMessagesDemo Methods
	//Success:
	public BootstrapAlertMessagesDemo buttonAutoSuccessClick() {
		buttonAutocloseableSuccess.click();
		return this;
	}
	
	public BootstrapAlertMessagesDemo buttonNormalSuccessClick() {
		buttonNormalSuccess.click();
		return this;
	}
	
	public WebElement alertAutoSuccessText() {
		return alertAutocloseableSuccess;
	}
	
	public WebElement alertNormalSuccessText() {
		return alertNormalSuccess;
	}
	
	public boolean exitNormalSuccessIsDisplayed() {
		return exitNormalSuccess.isDisplayed();
	}
	
	public boolean alertAutoSuccessIsDisplayed() {
		return alertAutocloseableSuccess.isDisplayed();
	}
	
	public boolean buttonAutoSuccessIsEnabled() {
		return buttonAutocloseableSuccess.isEnabled();
	}
	
	public BootstrapAlertMessagesDemo exitNormalSuccessClick() {
		exitNormalSuccess.click();
		return this;
	}
	
	//Warning:
	public BootstrapAlertMessagesDemo buttonAutoWarningClick() {
		buttonAutocloseableWarning.click();
		return this;
	}
	
	public BootstrapAlertMessagesDemo buttonNormalWarningClick() {
		buttonNormalWarning.click();
		return this;
	}
	
	public WebElement alertAutoWarningText() {
		return alertAutocloseableWarning;
	}
	
	public WebElement alertNormalWarningText() {
		return alertNormalWarning;
	}
	
	public boolean exitNormalWarningIsDisplayed() {
		return exitNormalWarning.isDisplayed();
	}
	
	public boolean alertAutoWarningIsDisplayed() {
		return alertAutocloseableWarning.isDisplayed();
	}
	
	public boolean buttonAutoWarningIsEnabled() {
		return buttonAutocloseableWarning.isEnabled();
	}
	
	public BootstrapAlertMessagesDemo exitNormalWarningClick() {
		exitNormalWarning.click();
		return this;
	}
	
	//Danger:
	public BootstrapAlertMessagesDemo buttonAutoDangerClick() {
		buttonAutocloseableDanger.click();
		return this;
	}
		
	public BootstrapAlertMessagesDemo buttonNormalDangerClick() {
		buttonNormalDanger.click();
		return this;
	}
	
	public WebElement alertAutoDangerText() {
		return alertAutocloseableDanger;
	}
	
	public WebElement alertNormalDangerText() {
		return alertNormalDanger;
	}
	
	public boolean exitNormalDangerIsDisplayed() {
		return exitNormalDanger.isDisplayed();
	}
	
	public boolean alertAutoDangerIsDisplayed() {
		return alertAutocloseableDanger.isDisplayed();
	}
	
	public boolean buttonAutoDangerIsEnabled() {
		return buttonAutocloseableDanger.isEnabled();
	}
	
	public BootstrapAlertMessagesDemo exitNormalDangerClick() {
		exitNormalDanger.click();
		return this;
	}
	
	//Info:
	public BootstrapAlertMessagesDemo buttonAutoInfoClick() {
		buttonAutocloseableInfo.click();
		return this;
	}
		
	public BootstrapAlertMessagesDemo buttonNormalInfoClick() {
		buttonNormalInfo.click();
		return this;
	}
	
	public WebElement alertAutoInfoText() {
		return alertAutocloseableInfo;
	}
	
	public WebElement alertNormalInfoText() {
		return alertNormalInfo;
	}
	
	public boolean exitNormalInfoIsDisplayed() {
		return exitNormalInfo.isDisplayed();
	}
	
	public boolean alertAutoInfoIsDisplayed() {
		return alertAutocloseableInfo.isDisplayed();
	}
	
	public boolean buttonAutoInfoIsEnabled() {
		return buttonAutocloseableInfo.isEnabled();
	}
	
	public BootstrapAlertMessagesDemo exitNormalInfoClick() {
		exitNormalInfo.click();
		return this;
	}
	
	//Initialize All Elements
	public BootstrapAlertMessagesDemo initializeElements(RemoteWebDriver webDriver) {
		buttonAutocloseableSuccess = webDriver.findElement(By.xpath("//*[@id=\"autoclosable-btn-success\"]"));
		buttonNormalSuccess = webDriver.findElement(By.xpath("//*[@id=\"normal-btn-success\"]"));
		buttonAutocloseableWarning = webDriver.findElement(By.xpath("//*[@id=\"autoclosable-btn-warning\"]"));
		buttonNormalWarning = webDriver.findElement(By.xpath("//*[@id=\"normal-btn-warning\"]"));
		buttonAutocloseableDanger = webDriver.findElement(By.xpath("//*[@id=\"autoclosable-btn-danger\"]"));
		buttonNormalDanger = webDriver.findElement(By.xpath("//*[@id=\"normal-btn-danger\"]"));
		buttonAutocloseableInfo = webDriver.findElement(By.xpath("//*[@id=\"autoclosable-btn-info\"]"));
		buttonNormalInfo = webDriver.findElement(By.xpath("//*[@id=\"normal-btn-info\"]"));
		alertAutocloseableSuccess = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]"));
		alertNormalSuccess = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]"));
		alertAutocloseableWarning = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]"));
		alertNormalWarning = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]"));
		alertAutocloseableDanger = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]"));
		alertNormalDanger = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]"));
		alertAutocloseableInfo = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]"));
		alertNormalInfo = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]"));
		exitNormalSuccess = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"));
		exitNormalWarning = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button"));
		exitNormalDanger = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button"));
		exitNormalInfo = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/button"));
		return this;
	}
	
}