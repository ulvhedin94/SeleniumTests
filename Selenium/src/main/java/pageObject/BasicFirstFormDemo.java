package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicFirstFormDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
	
	protected RemoteWebDriver webDriver;
	
	public BasicFirstFormDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	protected Actions action;
	
	//Single Input Field elements
	private WebElement messageTextBox1;
	private WebElement messageButton1;
	private WebElement messageResult1;
	
	//Two Input Fields elements
	private WebElement valueTextBox1;
	private WebElement valueTextBox2;
	private WebElement valueButton1;
	private WebElement valueResult1;
	
	//Methods - Single Input Field
	public BasicFirstFormDemo messageTextBox1Click() {
		messageTextBox1.click();
		return this;
	}
	
	public BasicFirstFormDemo messageTextBox1Input(String someText) {
		messageTextBox1.sendKeys(someText);
		return this;
	}
	
	public BasicFirstFormDemo messageButton1Click() {
		messageButton1.click();
		return this;
	}
	
	public WebElement messageResult1Text() {
		return messageResult1;
	}
	
	//Methods - Two Input Fields
	public BasicFirstFormDemo valueTextBox1Click() {
		valueTextBox1.click();
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox1Input(String value1) {
		valueTextBox1.sendKeys(value1);
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox2Click() {
		valueTextBox2.click();
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox2Input(String value2) {
		valueTextBox2.sendKeys(value2);
		return this;
	}
	
	public BasicFirstFormDemo valueButton1Click() {
		valueButton1.click();
		return this;
	}
	
	public WebElement valueResult1Text() {
		return valueResult1;
	}
	
	public BasicFirstFormDemo valueTextBox1DoubleClick() {
		action.doubleClick(valueTextBox1);
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox2DoubleClick() {
		action.doubleClick(valueTextBox2);
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox1Clear() {
		valueTextBox1.clear();
		return this;
	}
	
	public BasicFirstFormDemo valueTextBox2Clear() {
		valueTextBox2.clear();
		return this;
	}
	
	//initialization of all elements
	public BasicFirstFormDemo initializeElements(RemoteWebDriver webDriver) {
		messageTextBox1 = webDriver.findElement(By.xpath("//*[@id=\"user-message\"]"));
		messageButton1 = webDriver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
		messageResult1 = webDriver.findElement(By.xpath("//*[@id=\"display\"]"));
		valueTextBox1 = webDriver.findElement(By.xpath("//*[@id=\"sum1\"]"));
		valueTextBox2 = webDriver.findElement(By.xpath("//*[@id=\"sum2\"]"));
		valueButton1 = webDriver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
		valueResult1 = webDriver.findElement(By.xpath("//*[@id=\"displayvalue\"]"));
		return this;
	}
}
