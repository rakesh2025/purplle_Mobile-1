package tests;

import com.aventstack.extentreports.Status;


import generic.ReusableMethodes;

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
 * @Description Opening the app , Adding  product to cart & Verifying the price , product in cart page .
 * 
 *
 */

@Listeners(utils.Listener.class)
public class ProductGeneric extends BaseClass {

	@Test(dataProvider = "ReadVariant1", dataProviderClass = ExcelFileUtil.class)
	public void addProductToCartTest(String Category, String SubCategory, String ProductCategory, String BrandName,
			String ProductName) throws Throwable {

		
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

		String actualProductName = pp.getProductName().getText();
		String actualProductPrice = pp.getProductPrice().getText();
		// Adding the product to cart
		pp.clickOnAddToCartButton(apkDriver);
		
		pp.clickOnGoToCartButton(apkDriver);
		CartPage cp = new CartPage(apkDriver);
		String expectedName = cp.getProductNameLink(ProductName).getText();
		String cartProductPrice = cp.getPriceOfProductLink(ProductName).getText();
		JavaUtils jUtils = new JavaUtils();
		String expectedPrice = jUtils.convertCartPageProductPrice(cartProductPrice);
		//Verifying the product name & price in cart page
		Assert.assertEquals(actualProductName, expectedName);
		Listener.test.log(Status.INFO, "Verified the product name.");
		Assert.assertEquals(actualProductPrice, expectedPrice);
		Listener.test.log(Status.INFO, "Verified the product price.");
		cp.getRemoveOfaProductLink(ProductName).click();

	}

}
