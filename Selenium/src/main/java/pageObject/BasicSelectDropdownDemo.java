package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicSelectDropdownDemo extends BasePage{
	private final static String pageUrl = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
	protected RemoteWebDriver webDriver;
	protected Actions action;
	
	public BasicSelectDropdownDemo(RemoteWebDriver webDriver, Actions action) {
		super(webDriver);
		this.action = action;
	}
	
	public static String getUrl() {
		return pageUrl;
	}
	
	//Select List Demo elements
	private WebElement dropdownList;
	private WebElement optionSunday;
	private WebElement optionMonday;
	private WebElement optionTuesday;
	private WebElement optionWednesday;
	private WebElement optionThursday;
	private WebElement optionFriday;
	private WebElement optionSaturday;
	private WebElement messageResult1;
	
	//Multi Select List Demo elements
	private WebElement optionCalifornia;
	private WebElement optionFlorida;
	private WebElement optionNewJersey;
	private WebElement optionNewYork;
	private WebElement optionOhio;
	private WebElement optionTexas;
	private WebElement optionPennsylvania;
	private WebElement optionWashington;
	private WebElement buttonFirstSelected;
	private WebElement buttonGetAllSelected;
	private WebElement messageResult2;
	
	//Select List Demo methods
	
	public BasicSelectDropdownDemo dropdownListClick() {
		dropdownList.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectSundayClick() {
		optionSunday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectMondayClick() {
		optionMonday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectTuesdayClick() {
		optionTuesday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectWednesdayClick() {
		optionWednesday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectThursdayClick() {
		optionThursday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectFridayClick() {
		optionFriday.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectSaturdayClick() {
		optionSaturday.click();
		return this;
	}
	
	public WebElement messageResult1Text() {
		return messageResult1;
	}
	
	//Multi Select List Demo methods
	public BasicSelectDropdownDemo selectCaliforniaClick() {
		optionCalifornia.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectFloridaClick() {
		optionFlorida.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectNewJerseyClick() {
		optionNewJersey.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectNewYorkClick() {
		optionNewYork.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectOhioClick() {
		optionOhio.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectTexasClick() {
		optionTexas.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectPennsylvaniaClick() {
		optionPennsylvania.click();
		return this;
	}
	
	public BasicSelectDropdownDemo selectWashingtonClick() {
		optionWashington.click();
		return this;
	}
	
	public BasicSelectDropdownDemo buttonFirstSelectedClick() {
		buttonFirstSelected.click();
		return this;
	}
	
	public BasicSelectDropdownDemo buttonGetAllSelectedClick() {
		buttonGetAllSelected.click();
		return this;
	}
	
	public WebElement messageResult2Text() {
		return messageResult2;
	}
	
	public BasicSelectDropdownDemo selectAllStatesWithClickAndRelease() {
		action.clickAndHold(optionCalifornia).moveToElement(optionWashington).release(optionWashington).build().perform();
		return this;
	}
	
	public BasicSelectDropdownDemo selectAllStatesWithClickAndReleaseAfterClick() {
		optionCalifornia.click();
		action.clickAndHold(optionCalifornia).moveToElement(optionWashington).release(optionWashington).build().perform();
		return this;
	}
	
	public BasicSelectDropdownDemo selectAllStatesWithShiftKey() {
		optionCalifornia.click();
		action.keyDown(Keys.SHIFT).moveToElement(optionWashington).click().keyUp(Keys.SHIFT).build().perform();
		return this;
	}
	
	public BasicSelectDropdownDemo selectAllStatesWithCtrlKey(){
		optionCalifornia.click();
		action.keyDown(Keys.CONTROL);
		action.click(optionFlorida);
		action.click(optionNewJersey);
		action.click(optionNewYork);
		action.click(optionOhio);
		action.click(optionTexas);
		action.click(optionPennsylvania);
		action.click(optionWashington);
		action.keyUp(Keys.CONTROL).build().perform();
		return this;
	}
	
	
	//initialization of all elements
	public BasicSelectDropdownDemo initializeElements(RemoteWebDriver webDriver) {		
		//Select List Demo
		dropdownList = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
		optionSunday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[2]"));
		optionMonday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[3]"));
		optionTuesday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[4]"));
		optionWednesday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[5]"));
		optionThursday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[6]"));
		optionFriday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[7]"));
		optionSaturday = webDriver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[8]"));
		messageResult1 = webDriver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]"));
		
		//Multi Select List
		optionCalifornia = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[1]"));
		optionFlorida = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[2]"));
		optionNewJersey = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[3]"));
		optionNewYork = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[4]"));
		optionOhio = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[5]"));
		optionTexas = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[6]"));
		optionPennsylvania = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[7]"));
		optionWashington = webDriver.findElement(By.xpath("//*[@id=\"multi-select\"]/option[8]"));
		buttonFirstSelected = webDriver.findElement(By.xpath("//*[@id=\"printMe\"]"));
		buttonGetAllSelected = webDriver.findElement(By.xpath("//*[@id=\"printAll\"]"));
		messageResult2 = webDriver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]"));
		return this;
	}
}
