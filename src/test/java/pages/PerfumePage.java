package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MobileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PerfumePage
{

    AndroidDriver apkDriver;
    MobileUtils mo=new MobileUtils();

    public PerfumePage(AndroidDriver apkDriver)
    {
    	this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/product_image")
    private MobileElement selectFirstPerfume;

    @AndroidFindBy(id = "com.manash.purplle:id/pdp_product_title")
    private MobileElement productName;

    @AndroidFindBy(id ="com.manash.purplle:id/pdp_product_our_price")
    private MobileElement productPrice;

    //@AndroidFindBy(id ="com.manash.purplle:id/blush_atc_or_notify_me_text")
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Add to cart']")
    private MobileElement addToCartButton;
    @AndroidFindBy(id = "com.manash.purplle:id/blush_atc_or_notify_me_text")
    private MobileElement goToCartButton;
    @AndroidFindBy(id = "com.manash.purplle:id/close_popup_iv")
    private MobileElement closeIconOnGoToCartPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement closeIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement BackButton;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement BackButtonOnProductlistingPage;
    

    public MobileElement getBackButtonOnProductlistingPage() {
		return BackButtonOnProductlistingPage;
	}
	public MobileElement getBackButton() {
		return BackButton;
	}
	public MobileElement getCloseIconOnGoToCartPopup() {
		return closeIconOnGoToCartPopup;
	}
	public MobileElement getCloseIcon() {
		return closeIcon;
	}
	public MobileElement getSelectFirstPerfume() {
		return selectFirstPerfume;
	}
    public MobileElement getProductLink(String ProductName) {
    	MobileElement ProductLink =(MobileElement) apkDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+ProductName+"') and @resource-id='com.manash.purplle:id/product_name']"));
    	return ProductLink;
    	}
    public MobileElement getBrandLink(String BrandName) {
    	MobileElement BrandLink =(MobileElement) apkDriver.findElement(By.xpath("//android.widget.TextView[@text='"+BrandName+"']"));
    	return BrandLink;
    	}

	


	@AndroidFindBy(id ="com.manash.purplle:id/view_cart_btn")
    private MobileElement viewCartButton;

//    @AndroidFindAll({@AndroidFindBy(id = "com.manash.purplle:id/rl_add_to_cart") , @AndroidFindBy(id ="com.manash.purplle:id/view_cart_btn")})
//    private MobileElement viewCartButtonAndAddToCartButton;
    public MobileElement getProductName() {
        return productName;
    }

    public void setProductName(MobileElement productName) {
        this.productName = productName;
    }

    public MobileElement getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(MobileElement productPrice) {
        this.productPrice = productPrice;
    }

    public MobileElement getAddToCartButton() {
        return addToCartButton;
    }
    public MobileElement getGoToCartButton() {
        return goToCartButton;
    }
    
    
    public void clickOnProduct(String BrandName,String ProductName)
    {
        //selectFirstPerfume.click();
    	getBrandLink(BrandName).click();
    	getProductLink(ProductName).click();
	
    }

    public MobileElement getViewCartButton() {
        return viewCartButton;
    }
    
    public void clickOnAddToCartButton(AndroidDriver apkDriver) {
     try {
     	mo.waitAndClick(apkDriver,addToCartButton );

	} catch (Exception e) {
		// TODO: handle exception
	}
    }
    public void clickOnGoToCartButton(AndroidDriver apkDriver) {
        mo.waitAndClick(apkDriver,goToCartButton );
    }
    public void clickOncloseIconOnGoToCartPopup(AndroidDriver apkDriver) {
        mo.waitAndClick(apkDriver,closeIconOnGoToCartPopup );
    }
    public void clickOnBackButton(AndroidDriver apkDriver) {
        mo.waitAndClick(apkDriver,BackButton );
    }
    public void clickOnBackButtonOnProductlistingPage(AndroidDriver apkDriver) {
        mo.waitAndClick(apkDriver,BackButtonOnProductlistingPage );
    }
    

    public void clickOnAddToCartAndViewCartButton()
    {
       getAddToCartButton().click();
        try
        {
        	getViewCartButton().click();
        }
        catch (Exception e)
        {
            getAddToCartButton().click();
        }
   
    }



}
