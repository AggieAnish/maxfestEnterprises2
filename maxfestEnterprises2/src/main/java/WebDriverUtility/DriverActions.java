package WebDriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import WaitUtility.WaitUtility;

public class DriverActions {
	public static WebDriver driver;
	private String iframe;
	WaitUtility wait;

	public DriverActions(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtility(driver);

	}

//Common method implementation for By
	public void click(By value) throws InterruptedException {
		wait.waitUntil(2000);
		driver.findElement(value).click();
	}

	public void sendkeys(By value, String value1) throws InterruptedException {
		wait.waitUntil(2000);
		driver.findElement(value).clear();
		driver.findElement(value).sendKeys(value1);
	}

	public String getText(By value) throws InterruptedException {
		wait.waitUntil(2000);
		String Value = driver.findElement(value).getText();
		return Value;
	}

	public void DropdownselectByvalue(By dropdown, String value) throws InterruptedException {
		wait.waitUntil(2000);
		WebElement drop = driver.findElement(dropdown);
		Select objSelect = new Select(drop);
		objSelect.selectByValue(value);

	}

	public void DropdownselectByIndex(By dropdown, int value) throws InterruptedException {

		WebElement drop = driver.findElement(dropdown);
		Select objSelect = new Select(drop);
		objSelect.selectByIndex(value);
	}

	public void Alertaccept() throws InterruptedException {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void Alertdismiss() throws InterruptedException {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();
	}

	public void iframes(By value) throws InterruptedException {

		driver.findElement(value);
		driver.switchTo().frame(iframe);
	}

	public void Javascripttestcase(WebElement Inputform) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Inputform);
		js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public void Actiontestcase(WebElement element, Actions action) throws InterruptedException {

		action.moveToElement(element).contextClick().perform();

	}

	public void click(WebElement value) throws InterruptedException {
		wait.waitUntil(2000);
		value.click();
	}

	public void sendkeys(WebElement value, String value1) throws InterruptedException {

		value.clear();
		value.sendKeys(value1);
	}

	public void DropdownselectByvalue(WebElement dropdown, String value) throws InterruptedException {

		Select objSelect = new Select(dropdown);
		objSelect.selectByValue(value);
	}

	public void DropdownselectByIndex(WebElement dropdown, int value) throws InterruptedException {

		Select objSelect = new Select(dropdown);
		objSelect.selectByIndex(value);
	}

	public String elementEnable(WebElement element) throws InterruptedException {

		String value = element.getText();
		return value;
	}

	public String getText(WebElement element) throws InterruptedException {

		String value = element.getText();
		return value;
	}

}