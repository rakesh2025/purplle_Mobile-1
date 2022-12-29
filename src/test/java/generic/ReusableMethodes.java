package generic;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import pages.CategoriesPage;
import pages.HomePage;
import pages.PerfumePage;
import utils.BaseClass;
import utils.Listener;

public class ReusableMethodes extends BaseClass{
	//AndroidDriver apkDriver;

	public void selectAProductFromCategory(String Category, String SubCategory, String ProductCategory,String BrandName,String ProductName) throws Throwable {
		HomePage hp = new HomePage(apkDriver);
    	//Clicked on Categories
        hp.getCategories().click();
        Listener.test.log(Status.INFO,"Clicked on category.");
        CategoriesPage catPage = new CategoriesPage(apkDriver);
        catPage.chooseCategories(Category,SubCategory , ProductCategory);
        Listener.test.log(Status.INFO,"Select Category,subCategory,productCategory");
        PerfumePage pp = new PerfumePage(apkDriver);
        pp.clickOnProduct(BrandName,ProductName);
        Listener.test.log(Status.INFO,"Select the Brand & Product");
	}
}
