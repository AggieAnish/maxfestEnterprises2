package POMPages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;


public class POMLogin {
	
		WebDriver driver;
		 WaitUtility wait;
		 DriverActions action;
		
		 public POMLogin(WebDriver driver) {
			 this.driver= driver;
			 PageFactory.initElements(driver, this);
			 wait =new WaitUtility(driver);
			 action = new DriverActions(driver);	

	}
		 @FindBy(xpath="//input[@id='username']")
		 public WebElement username;
		 
		 @FindBy(xpath="//input[@id='password']")
		 public WebElement password;
		 
		 @FindBy(xpath="//button[@type='submit']")
		 public WebElement loginBtn;
		 
		 @FindBy(xpath="//strong[text()='These credentials do not match our records.']")
		 public WebElement invalidMsg;
		// By invalidMsg1 = By.xpath("//strong[text()='These credentials do not match our records.']");
		 
		 @FindBy(xpath="//button[@data-role='end']")
		 public WebElement endTourBtn;
		 
		 public void clickLoginBtn() throws InterruptedException {				
			 action.click(loginBtn);
		}
		 
		 public void usernameSendKey(String expectedValue) throws IOException, InterruptedException {			
			action.sendkeys(username, expectedValue);
		 }
		 public void pwdSendKey(String expectedValue) throws IOException, InterruptedException {				
				action.sendkeys(password, expectedValue);
			 }	
		 
		 
		 public String getinvalidMsg() throws InterruptedException {				 		
				String msg= action.elementEnable(invalidMsg);				
				return msg;
			}		
		 
		 public void endTourBtnClick() throws InterruptedException {
				action.click(endTourBtn);
			}
		
}

