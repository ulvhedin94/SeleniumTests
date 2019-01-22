package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDualListBoxDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public BootstrapDualListBoxDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//Bootstrap Dual List Box elements
	private WebElement searchInput1;
	private WebElement searchInput2;
	List <WebElement> listGroup1;
	List <WebElement> listGroup2;
	private WebElement buttonToLeftBox;
	private WebElement buttonToRightBox;
	private WebElement buttonSelectAllBox1;
	private WebElement buttonSelectAllBox2;
	
	//Methods
	public BootstrapDualListBoxDemo searchInput1Click() {
		searchInput1.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo searchInput2Click() {
		searchInput2.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo buttonToLeftBoxClick() {
		buttonToLeftBox.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo buttonToRightBoxClick() {
		buttonToRightBox.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo buttonSelectAllBox1Click() {
		buttonSelectAllBox1.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo buttonSelectAllBox2Click() {
		buttonSelectAllBox2.click();
		return this;
	}
	
	public BootstrapDualListBoxDemo searchInput1Text(String someText) {
		searchInput1.sendKeys(someText);
		return this;
	}
	
	public BootstrapDualListBoxDemo searchInput2Text(String someText) {
		searchInput2.sendKeys(someText);
		return this;
	}
	
	public WebElement searchBoxTextResult() {
		return searchInput1;
	}
	
	public BootstrapDualListBoxDemo listGroup1ElementClick(int someNumber) {
		listGroup1.get(someNumber).click();
		return this;
	}
	
	public WebElement listGroup1Element(int someNumber) {
		return listGroup1.get(someNumber);	 
	}
	
	public BootstrapDualListBoxDemo listGroup2ElementClick(int someNumber) {
		listGroup2.get(someNumber).click();
		return this;
	}
	
	public WebElement listGroup2Element(int someNumber) {
		return listGroup2.get(someNumber);	 
	}
	
	public int listGroup1Size() {
		return listGroup1.size();
	}
	
	public int listGroup2Size() {
		return listGroup2.size();
	}
	
	public boolean listGroup1IsEmpty() {
		return listGroup1.isEmpty();
	}
	
	public boolean listGroup2IsEmpty() {
		return listGroup2.isEmpty();
	}
	
	//Initialize listGroup1 and listGroup 2 elements For Actual Position
	public BootstrapDualListBoxDemo getActualListBoxesXpath(RemoteWebDriver webDriver) {
		listGroup1 = webDriver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li"));
		listGroup2 = webDriver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li"));
		return this;
	}

	//Initialize All Elements
	public BootstrapDualListBoxDemo initializeElements(RemoteWebDriver webDriver) {
		searchInput1 = webDriver.findElement(By.xpath("//*[@id=\"listhead\"]/div[1]/div/input"));
		searchInput2 = webDriver.findElement(By.xpath("//*[@id=\"listhead\"]/div[2]/div/input"));
		listGroup1 = webDriver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li"));
		listGroup2 = webDriver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li"));
		buttonSelectAllBox1 = webDriver.findElement(By.xpath("//*[@id=\"listhead\"]/div[2]/div/a"));
		buttonSelectAllBox2 = webDriver.findElement(By.xpath("//*[@id=\"listhead\"]/div[1]/div/a"));
		buttonToLeftBox = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]"));
		buttonToRightBox = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]"));
		return this;
	}
	
}