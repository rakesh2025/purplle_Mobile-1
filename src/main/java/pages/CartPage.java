package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MobileUtils;

public class CartPage
{
	 //AndroidDriver apkDriver;
	 MobileUtils mo=new MobileUtils();
    public CartPage(AppiumDriver driver)
    {
    	//this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/item_title")
    private MobileElement productName;
    @AndroidFindBy(id = "com.manash.purplle:id/item_title")
    private List<MobileElement> productNameList;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView/../android.widget.RelativeLayout/android.widget.TextView[contains(@text , '₹')]")
    private MobileElement productPrice;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView/../android.widget.RelativeLayout/android.widget.TextView[contains(@text , '₹')]")
    private List<MobileElement> productPriceList;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backButton;
    @AndroidFindBy(id = "com.manash.purplle:id/view_detailed_view")
    private MobileElement ViewDetailViewLink;
    @AndroidFindBy(id = "com.manash.purplle:id/total_mrp")
    private MobileElement TotalMRP;
    @AndroidFindBy(id = "com.manash.purplle:id/remove_item")
    private MobileElement RemoveItem;
	@AndroidFindBy(id = "com.manash.purplle:id/saving_on_mrp")
    private MobileElement SavingOnMRP;
    @AndroidFindBy(id = "com.manash.purplle:id/sub_total")
    private MobileElement SubTotal;
    @AndroidFindBy(id = "com.manash.purplle:id/shipping_charges")
    private MobileElement ShippingCharge;  
    @AndroidFindBy(id = "com.manash.purplle:id/pin_code_edit_text")
    private MobileElement PinCodeTextBox;
	@AndroidFindBy(id = "com.manash.purplle:id/order_total")
    private MobileElement OrderTotal;
    
    
    
    
    public MobileElement getPinCodeTextBox() {
		return PinCodeTextBox;
	}
	public MobileElement getRemoveItem() {
		return RemoveItem;
	}
	public List<MobileElement> getProductNameList() {
		return productNameList;
	}
	public List<MobileElement> getProductPriceList() {
		return productPriceList;
	}
    public MobileElement getTotalMRP() {
		return TotalMRP;
	}
	public MobileElement getSavingOnMRP() {
		return SavingOnMRP;
	}
	public MobileElement getSubTotal() {
		return SubTotal;
	}
	public MobileElement getShippingCharge() {
		return ShippingCharge;
	}
	public MobileElement getOrderTotal() {
		return OrderTotal;
	}
    public MobileElement getProductName() {
        return productName;
    }
    public MobileElement getBackButton() {
		return backButton;
	}
	public MobileElement getViewDetailViewLink() {
		return ViewDetailViewLink;
	}
	public void setProductName(MobileElement productName) {
        this.productName = productName;
    }
    public MobileElement getProductPrice() {
        return productPrice;
    }
    public void clickOnBackbutton(AppiumDriver driver) {
        mo.waitAndClick(driver, backButton);
    }
    public void clickOnViewDetailViewLink(AppiumDriver driver) {
        mo.waitAndClick(driver,ViewDetailViewLink );
    }
    public void setProductPrice(MobileElement productPrice) {
        this.productPrice = productPrice;
    }
    public MobileElement getProductNameLink(AppiumDriver driver,String ProductName) throws Throwable {
    	Thread.sleep(1000);
    	MobileElement ProductNameLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+ProductName+"')]"));
    	return ProductNameLink;
    	}
    public MobileElement getPriceOfProductLink(AppiumDriver driver,String ProductName) throws Throwable {
    	Thread.sleep(1000);
    	MobileElement PriceOfProductLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+ProductName+"')]/following-sibling::android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id='com.manash.purplle:id/item_price']"));
    	return PriceOfProductLink;
    	}
    public MobileElement getRemoveOfaProductLink(AppiumDriver driver,String ProductName) {
    	MobileElement RemoveOfaProductLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+ProductName+"')]/following-sibling::android.widget.LinearLayout[1]/descendant::android.widget.LinearLayout[@resource-id='com.manash.purplle:id/remove_item']"));
    	return RemoveOfaProductLink;
    	}  
    public void removeAllOrder(AppiumDriver driver) {
    	mo.scrollUpToElement(driver, getPinCodeTextBox());
    	for(int i = 0; i < 2; i++)
    	{
    		try {
        		if(RemoveItem.isDisplayed()) {
        			RemoveItem.click();
        		}
        	}catch (Exception e) 
    		{
    			
    		}
    	}
    	} 
    
    
}
