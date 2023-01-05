package tests;

import com.aventstack.extentreports.Status;


import generic.ReusableMethodes;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CategoriesPage;
import pages.HomePage;
import pages.PerfumePage;
import utils.BaseClass;
import utils.ExcelFileUtil;
import utils.JavaUtils;
import utils.Listener;
import utils.MobileUtils;

/**
 * @Description Opening the app , Adding  product to cart & Verifying the price , product in cart page .
 * 
 *
 */

@Listeners(utils.Listener.class)
public class ProductGeneric extends BaseClass {
	public MobileUtils mo=new MobileUtils();

	@Test(dataProvider = "ReadVariant1", dataProviderClass = ExcelFileUtil.class)
	public void addProductToCartTest(String Category, String SubCategory, String ProductCategory, String BrandName,
			String ProductName) throws Throwable {

		
		  HomePage hp = new HomePage(driver); 
		  //Clicked on Categories
		  hp.getCategories().click();
		  Listener.test.log(Status.INFO,"Clicked on category."); 
		  CategoriesPage catPage= new CategoriesPage(driver);
		  //Select the Category,Sub Category , Product Category
		  //catPage.chooseCategories(driver, Category,SubCategory , ProductCategory);
		  //catPage.ScrollToMan(driver);
		  //mo.scrollToElementAndClick(driver, "Skin Care ");
		  catPage.ClickOnCategory(driver, Category);
		  mo.scrollToElementAndClick(driver, SubCategory);
		  mo.scrollToElementAndClick(driver, ProductCategory);
		  Thread.sleep(2000);
		  //(MobileElement)driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(new UiSelector().textContains(\"WOW\").instance(1))").click();
		 //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WOW\").instance(1))"));
		  //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(new UiSelector().resourceId(\"com.manash.purplle:id/quick_link\").text(\"WOW\"))")).click();
		  
		  // mo.scrollToElementAndClick(driver, "WOW");
		  Listener.test.log(Status.INFO,"Select Category,subCategory,productCategory");
		  PerfumePage pp = new PerfumePage(driver);
		  Thread.sleep(5000);
		  //Blue Heaven
		 pp.selectBrand(driver,BrandName) ;
		  //pp.chooseBrand(driver);
		  //pp.swipeToRightSelectBrand(driver,pp.getBrandLink(driver,"Blue Heaven" ) );
		  
		  Thread.sleep(5000);
		  //Select the brand name & product
		  
		  //pp.clickOnProduct(driver, BrandName,ProductName);
		  mo.scrollToElementAndClick(driver, ProductName);
		  Listener.test.log(Status.INFO,"Select the Brand & Product");

		String actualProductName = pp.getProductName().getText();
		String actualProductPrice = pp.getProductPrice().getText();
		// Adding the product to cart
		pp.clickOnAddToCartButton(driver);
		
		pp.clickOnGoToCartButton(driver);
		CartPage cp = new CartPage(driver);
		mo.scrollToElement(driver, ProductName);
		String expectedName = cp.getProductNameLink(driver, ProductName).getText();
		String cartProductPrice = cp.getPriceOfProductLink(driver, ProductName).getText();
		JavaUtils jUtils = new JavaUtils();
		String expectedPrice = jUtils.convertCartPageProductPrice(cartProductPrice);
		//Verifying the product name & price in cart page
		Assert.assertEquals(actualProductName, expectedName);
		Listener.test.log(Status.INFO, "Verified the product name.");
		Assert.assertEquals(actualProductPrice, expectedPrice);
		Listener.test.log(Status.INFO, "Verified the product price.");
		cp.getRemoveOfaProductLink(driver, ProductName).click();
		

	}
	
	@Test
	public void checkRightSwipe() throws InterruptedException
	{
		Thread.sleep(8000);
		 WebElement me = driver.findElement(By.xpath("(//android.view.View[contains(@text, 'FEATURED')]//android.view.View//android.widget.ImageView/..)[last()]"));
		 Dimension location = driver.manage().window().getSize();
	    	location.getHeight();
	    	int x = location.getWidth();
	    	System.out.println("x : => " + x);
	    	x = (int)(x*(0.5));
//	    	while (true) {
//	            try {
//	            	System.out.println("Currently in try");
//	                if (false) {
//	                    //System.out.println("conditon passed so clicking on element");
////	                    break;
//	                }
//	            } catch (Exception e) {
	            	Point locationFrom = me.getLocation();
	            	System.out.println(locationFrom.getX() + " & " + locationFrom.getY());
	                System.out.println("Catch block activated and performing scrolling down");
	                TouchAction touch = new TouchAction(driver);
	                touch.press(PointOption.point(locationFrom.getX(), locationFrom.getY()))
	                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	                        .moveTo(PointOption.point(500, locationFrom.getY())).release().perform();
	                Thread.sleep(5000);
//	            }
//	        }
	}
	@Test
	public void checkRightSwipeonCategory() throws Throwable
	{
		HomePage hp = new HomePage(driver); 
		  //Clicked on Categories
		  hp.getCategories().click();
		  CategoriesPage catPage= new CategoriesPage(driver);
		  //Select the Category,Sub Category , Product Category
		  catPage.chooseCategories(driver, "Makeup","Face Makeup" , "Primer");
		  Listener.test.log(Status.INFO,"Select Category,subCategory,productCategory");
		  Thread.sleep(8000);
		  while(true) {
		 WebElement ElementFrom = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.manash.purplle:id/quick_link'])[last()]"));
		 WebElement ElementTO = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.manash.purplle:id/quick_link'])[1]"));
		 WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='Blue Heaven']"));
try {
	
	if(element.isDisplayed())
		break;
}catch (Exception e) {
	// TODO: handle exception

		
		TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(ElementFrom.getLocation().getX(),ElementFrom.getLocation().getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(ElementTO.getLocation().getX(),ElementTO.getLocation().getY())).release().perform();
		Thread.sleep(8000);
		  }
		  }
//	        }
	}
	

}
