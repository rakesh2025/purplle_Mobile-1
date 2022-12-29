package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MobileUtils;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

public class BrandsPage
{
	MobileUtils mo=new MobileUtils();
    public BrandsPage(AndroidDriver apkDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    }

    @AndroidFindBy(id = "android:id/search_src_text")
    private MobileElement searchFiled;
    
   
    
    
	/*
	 * public void clickOnGoToCartButton(AndroidDriver apkDriver) {
	 * mo.waitAndClick(apkDriver,goToCartButton ); }
	 */

	public MobileElement getBrandPageTitle() {
		return brandPageTitle;
	}

	public List<MobileElement> getProductListInBrandPage() {
		return ProductListInBrandPage;
	}

	public MobileElement getBackButton() {
		return backButton;
	}

	@AndroidFindBy(id = "com.manash.purplle:id/brand_item_root")
    private MobileElement brandName;
    @AndroidFindBy(id = "com.manash.purplle:id/toolbar_title")
    private MobileElement brandPageTitle;
    @AndroidFindBy(id = "com.manash.purplle:id/product_name")
    private List<MobileElement> ProductListInBrandPage;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backButton;

    public MobileElement getSearchFiled() {
        return searchFiled;
    }
    

	public MobileElement getBrandName() {
		return brandName;
	}
	public void clickOnBrandName(AndroidDriver apkDriver) {
    	mo.waitAndClick(apkDriver,brandName );
		
	}
	public void clickOnBackButton() throws Throwable {
		backButton.click();
		Thread.sleep(2000);
		
	}
}
