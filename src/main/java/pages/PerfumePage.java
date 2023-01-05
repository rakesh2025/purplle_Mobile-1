package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.MobileUtils;

public class PerfumePage
{

    //AndroidDriver apkDriver;
    MobileUtils mo=new MobileUtils();

    public PerfumePage(AppiumDriver driver)
    {
    	//this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/product_image")
    private MobileElement selectFirstPerfume;
    @AndroidFindBy(id = "com.manash.purplle:id/pdp_product_title")
    private MobileElement productName;
    @AndroidFindBy(id ="com.manash.purplle:id/pdp_product_our_price")
    private MobileElement productPrice;
	@AndroidFindBy(id ="com.manash.purplle:id/view_cart_btn")
    private MobileElement viewCartButton;
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
	  @AndroidFindBy(id ="com.manash.purplle:id/quick_link") 
	  private List<MobileElement> BrandList;
	  
		 @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.manash.purplle:id/quick_link'])[1]")
		    private MobileElement FirstBrand;
		 @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.manash.purplle:id/quick_link'])[last()]")
		    private MobileElement LastBrand;
			/*
			 * @AndroidFindBy(xpath =
			 * "(//androidx.recyclerview.widget.RecyclerView/android.widget.TextView)[last()]")
			 * private MobileElement lastBrand;
			 */
	
	public MobileElement getlastBrand() {
		return LastBrand;
	}  
	public MobileElement getFirstBrand() {
		return FirstBrand;
	}


    public List<MobileElement> getBrandList() {
		return BrandList;
	}
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
    public MobileElement getViewCartButton() {
        return viewCartButton;
    }
    public MobileElement getProductLink(AppiumDriver driver,String ProductName) {
    	MobileElement ProductLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+ProductName+"') and @resource-id='com.manash.purplle:id/product_name']"));
    	return ProductLink;
    	}
    public MobileElement getBrandLink(AppiumDriver driver,String BrandName) {
    	MobileElement BrandLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='"+BrandName+"']"));
		return BrandLink;
    	
		}
		
    	

	




//    @AndroidFindAll({@AndroidFindBy(id = "com.manash.purplle:id/rl_add_to_cart") , @AndroidFindBy(id ="com.manash.purplle:id/view_cart_btn")})
//    private MobileElement viewCartButtonAndAddToCartButton;
    public MobileElement getProductName() {
        return productName;
    }
    public MobileElement getProductPrice() {
        return productPrice;
    }
    public MobileElement getAddToCartButton() {
        return addToCartButton;
    }
    public MobileElement getGoToCartButton() {
        return goToCartButton;
    }

	/*
	 * public void setProductName(MobileElement productName) { this.productName =
	 * productName; }
	 */

    

	/*
	 * public void setProductPrice(MobileElement productPrice) { this.productPrice =
	 * productPrice; }
	 */

    
    
    public void clickOnProduct(AppiumDriver driver,String BrandName,String ProductName)
    {
        //selectFirstPerfume.click();
    	getBrandLink(driver, BrandName).click();
    	getProductLink(driver,ProductName).click();
	
    }


    
    public void clickOnAddToCartButton(AppiumDriver apkDriver) {
     try {
     	mo.waitAndClick(apkDriver,addToCartButton );

	} catch (Exception e) {
		// TODO: handle exception
	}
    }
    public void clickOnGoToCartButton(AppiumDriver driver) {
        mo.waitAndClick(driver,goToCartButton );
    }
    public void clickOncloseIconOnGoToCartPopup(AppiumDriver driver) {
        mo.waitAndClick(driver,closeIconOnGoToCartPopup );
    }
    public void clickOnBackButton(AppiumDriver driver) {
        mo.waitAndClick(driver,BackButton );
    }
    public void clickOnBackButtonOnProductlistingPage(AppiumDriver driver) {
        mo.waitAndClick(driver,BackButtonOnProductlistingPage );
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
    
    public void chooseBrand(AppiumDriver driver) throws Throwable
    {
    	Thread.sleep(2000);
    	//mo.LeftSwipeToAElement(driver, getlastBrand(), getFirstBrand(), getBrandLink(driver, "Blue Heaven"));
    	mo.scrollToElementAndClick(driver, getBrandLink(driver, "Blue Heaven"));
    }
    
    public  void selectBrand(AppiumDriver driver,String BrandName) throws Exception {
    	int count = 0;
    	MobileElement BrandLink = null;
    	while (true) {
    		
            try {          
            	
            		 BrandLink = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='"+BrandName+"']"));
                if (BrandLink.isDisplayed()) {
                	BrandLink.click();
                    //System.out.println("conditon passed so clicking on element");
                    break;
                }
            } catch (Exception e) {
            	//MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
            	Point locationTo = getFirstBrand().getLocation();
            	Point locationFrom = getlastBrand().getLocation();
            	//location.getX()
                System.out.println("Catch block activated and performing scrolling down");
                TouchAction touch = new TouchAction(driver);
                touch.press(PointOption.point(locationFrom.getX(), locationFrom.getY()))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(locationTo.getX(), locationTo.getY())).release().perform();
                count++;
                if(count>=5)
                	throw new Exception("Element was not visible", e);
            }
        }
    }


 
    
    	
    

}
