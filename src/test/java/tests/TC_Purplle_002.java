package tests;

import com.aventstack.extentreports.Status;

import generic.ReusableMethodes;
import io.appium.java_client.MobileElement;

import java.util.List;

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
/**
 * @Description Opening the app , Adding 2 product to cart & Verifying the price , product in cart page .
 * 
 *
 */
@Listeners(utils.Listener.class)
public class TC_Purplle_002 extends BaseClass {

	@Test(dataProvider = "ReadVariant2", dataProviderClass = ExcelFileUtil.class)
	public void addProductToCartTest(String Category, String SubCategory, String ProductCategory, String BrandName,
			String ProductName,String Category2, String SubCategory2, String ProductCategory2, String BrandName2,
			String ProductName2) throws Throwable {

		
		  HomePage hp = new HomePage(apkDriver); 
		  //Clicked on Categories
		  hp.getCategories().click();
		  Listener.test.log(Status.INFO,"Clicked on category."); CategoriesPage
		  catPage= new CategoriesPage(apkDriver);
		  //Select the Category,Sub Category , Product Category
		  catPage.chooseCategories(Category,SubCategory , ProductCategory);
		  Listener.test.log(Status.INFO,"Select Category,subCategory,productCategory");
		  PerfumePage pp = new PerfumePage(apkDriver);
		  //Select the brand name & product
		  pp.clickOnProduct(BrandName,ProductName);
		  Listener.test.log(Status.INFO,"Select the Brand & Product");

		String expProductName = pp.getProductName().getText();
		String expProductPrice = pp.getProductPrice().getText();
		// Adding the product to cart
		pp.clickOnAddToCartButton(apkDriver);
		
		pp.clickOnGoToCartButton(apkDriver);
		Listener.test.log(Status.INFO,"Added the first product to cart.");
		CartPage cp = new CartPage(apkDriver);
		String expectedName = cp.getProductNameLink(ProductName).getText();
		String cartProductPrice = cp.getPriceOfProductLink(ProductName).getText();
		cp.clickOnBackbutton(apkDriver);
		pp.clickOncloseIconOnGoToCartPopup(apkDriver);
		pp.clickOnBackButton(apkDriver);
		Thread.sleep(2000);
		pp.clickOnBackButtonOnProductlistingPage(apkDriver);
		
		hp.clickOnhomeButton(apkDriver);
		//2nd product
		hp.getCategories().click();
		//Select the Category,Sub Category , Product Category
		  catPage.chooseCategories(Category2,SubCategory2 , ProductCategory2);
		  Listener.test.log(Status.INFO,"Select Category,subCategory,productCategory for second product .");
		  //Select the brand name & product
		  pp.clickOnProduct(BrandName2,ProductName2);
		  Listener.test.log(Status.INFO,"Select the Brand & Product for second product .");

		String expProductName2 = pp.getProductName().getText();
		String expProductPrice2 = pp.getProductPrice().getText();
		// Adding the product to cart
		pp.clickOnAddToCartButton(apkDriver);
		pp.clickOnGoToCartButton(apkDriver);
		Listener.test.log(Status.INFO,"Added second product to cart.");
		
		List<MobileElement> ActualPriceList = cp.getProductPriceList();
		List<MobileElement> ActualNameList = cp.getProductNameList();
		
		
		JavaUtils jUtils = new JavaUtils();
		String ActualPrice1String = jUtils.convertCartPageProductPrice(ActualPriceList.get(0).getText());
		String ActualPrice2String = jUtils.convertCartPageProductPrice(ActualPriceList.get(1).getText());
		//Verifying the product name & price in cart page
		Assert.assertEquals(ActualNameList.get(0).getText(), expProductName);
		Listener.test.log(Status.INFO, "Verified the first product name.");
		Assert.assertEquals(ActualNameList.get(1).getText(), expProductName2);
		Listener.test.log(Status.INFO, "Verified the second product name.");
		Assert.assertEquals(ActualPrice1String, expProductPrice);
		Listener.test.log(Status.INFO, "Verified the First product price.");
		Assert.assertEquals(ActualPrice2String, expProductPrice2);
		Listener.test.log(Status.INFO, "Verified the second product price.");

		
		cp.clickOnViewDetailViewLink(apkDriver);
		Listener.test.log(Status.INFO, "Clicked on Detail view link .");
		
		String TotalMRPText = cp.getTotalMRP().getText();
		String SavingOnMRPText = cp.getSavingOnMRP().getText();
		String SubTotalText = cp.getSubTotal().getText();
		int CalculatedSubTotal = Integer.parseInt(TotalMRPText.substring(1))-Integer.parseInt(SavingOnMRPText.substring(2));
		Assert.assertEquals(Integer.parseInt(SubTotalText.substring(1)), CalculatedSubTotal);
		Listener.test.log(Status.INFO, "Verified subtotal price .");
		
		String ShippingChargesText = cp.getShippingCharge().getText();
		String OrderTotalText = cp.getOrderTotal().getText();
		int CalculatedOrderTotal = Integer.parseInt(SubTotalText.substring(1))+Integer.parseInt(ShippingChargesText.substring(1));
		Assert.assertEquals(Integer.parseInt(OrderTotalText.substring(1)), CalculatedOrderTotal);
		Listener.test.log(Status.INFO, "Verified the order total price.");
		cp.removeAllOrder();

	}

}
