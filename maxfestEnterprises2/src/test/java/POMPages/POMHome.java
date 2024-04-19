package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;

public class POMHome {
	public static WebDriver driver;
	WaitUtility wait;
	DriverActions action;

	public POMHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverActions(driver);

	}
	@FindBy(xpath="//button[@data-role='end']")
	 public WebElement endTourBtn;
	
	
	
	@FindBy(xpath="//span[text()='Products']")
	 public WebElement productMenu;
	
	
	
	
	public void endTourBtnClick() throws InterruptedException {
		 wait.waitUntil(2000);
		action.click(endTourBtn);
	}
	public void productMenuClick() throws InterruptedException {	
		 wait.waitUntil(2000);
		action.click(productMenu);
	}
	
}


