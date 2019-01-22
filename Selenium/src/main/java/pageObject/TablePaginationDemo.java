package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class TablePaginationDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/table-pagination-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public TablePaginationDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//Bootstrap Dual List Box elements
	List <WebElement> listGroup;
	private WebElement buttonPreviousPage;
	private WebElement buttonNextPage;
	private WebElement buttonPage1;
	private WebElement buttonPage2;
	private WebElement buttonPage3;
	
	//Methods
	public TablePaginationDemo buttonPreviousPageClick() {
		buttonPreviousPage.click();
		return this;
	}
	
	public TablePaginationDemo buttonNextPageClick() {
		buttonNextPage.click();
		return this;
	}
	
	public TablePaginationDemo buttonPage1Click() {
		buttonPage1.click();
		return this;
	}
	
	public TablePaginationDemo buttonPage2Click() {
		buttonPage2.click();
		return this;
	}
	
	public TablePaginationDemo buttonPage3Click() {
		buttonPage3.click();
		return this;
	}
	
	public WebElement buttonPreviousPageDisplay() {
		return buttonPreviousPage;
	}
	
	public WebElement buttonNextPageDisplay() {
		return buttonNextPage;
	}
	
	public TablePaginationDemo listGroupElementClick(int someNumber) {
		listGroup.get(someNumber).click();
		return this;
	}
	
	public WebElement listGroupElement(int someNumber) {
		return listGroup.get(someNumber);	 
	}
	
	public int listGroupSize() {
		return listGroup.size();
	}
	
	public boolean listGroupIsEmpty() {
		return listGroup.isEmpty();
	}
	
	//Initialize All Elements
	public TablePaginationDemo initializeElements(RemoteWebDriver webDriver) {
		buttonNextPage = webDriver.findElement(By.xpath("//*[@id=\"myPager\"]/li[5]/a"));
		buttonPreviousPage = webDriver.findElement(By.xpath("//*[@id=\"myPager\"]/li[1]/a"));
		buttonPage1 = webDriver.findElement(By.xpath("//*[@id=\"myPager\"]/li[2]/a"));
		buttonPage2 = webDriver.findElement(By.xpath("//*[@id=\"myPager\"]/li[4]/a"));
		buttonPage3 = webDriver.findElement(By.xpath("//*[@id=\"myPager\"]/li[4]/a"));
		listGroup = webDriver.findElements(By.xpath("//*[@id=\"myTable\"]/tr"));
		return this;
	}
	
}