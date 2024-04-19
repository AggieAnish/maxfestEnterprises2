package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMPages.POMBrand;
import POMPages.POMHome;
import POMPages.POMProductAdd;
import POMPages.POMProductList;
import WaitUtility.WaitUtility;
import WebDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AddProduct extends BrowserUtility{
	 public  static WebDriver driver;	
	SoftAssert objassert ; 
  public POMProductAdd prodObj;
  POMProductList prodList;
  WaitUtility wait;

	

	
  @Test (priority = 1)
  public void addProduct() throws InterruptedException {
	  //prodObj = new POMProductAdd(driver);
	 this.driver= baseDriver();
	 wait= new WaitUtility(driver);
	 prodObj = new POMProductAdd(driver);
	
	  prodObj.productMenuClick();
	 // System.out.println(driver);
	  prodObj.addproductName("ProductNew");	 	  
	  prodObj.selectBrand();	  
	  prodObj.selectUnit();		  
	  prodObj.selectBarcodeType();	  
	  prodObj.addselectAlertQty("10");	 
	  prodObj.addpurchaseIncTax("5");	 
	  prodObj.addexpiry("10");
	  prodObj.productSaveBtnClick();
	  
	  String toastValue = "Product added successfully";	 
	  String data =  prodObj.getSaveToastValue();	
	 // System.out.println(data);
		objassert = new SoftAssert();
		objassert.assertEquals(toastValue, data);
		objassert.assertAll();
 
  }
  @Test (priority = 2)
  public void searchProduct() throws InterruptedException {
	  prodList = new POMProductList(driver);
	   prodList.productSearchClick();	   
		String searchValue = "ProductNew";
		prodList.productSearch(searchValue);		
		String data = prodList.getTablevalue();		
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();

	}
  @Test (priority = 3)
	 public void deleteproduct() throws InterruptedException {
	  prodList = new POMProductList(driver);
	  prodList.actionBtnClick();	
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,4500)");
	  prodList.prodDeleteBtnClick();	 
	  prodList.prodDeleteConfirmBtnClick();
	  String searchValue = "Product deleted successfully";	 
	  String data =  prodList.getDeleteToastValue();		
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();
	  
  } 
  
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterTest (alwaysRun = true)
	public void afterTest() {
		driver.close();
	}
 

}
