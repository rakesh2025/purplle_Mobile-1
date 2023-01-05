package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MobileUtils;

public class HomePage
{
	//AndroidDriver apkDriver;
	MobileUtils mo=new MobileUtils();
    public HomePage(AppiumDriver driver)
    {
    	//this.apkDriver = apkDriver;
       // PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    	
    }

	//@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id = 'com.manash.purplle:id/flutter_view_main']//android.widget.Button[@text = 'Open navigation menu']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Open navigation menu']")
    private MobileElement menuButton;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Show menu']")
    private MobileElement profileButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private MobileElement homeButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Brands']")
    private MobileElement brandButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Offers']")
    private MobileElement offersButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Studio']")
    private MobileElement studioButton;
    @AndroidFindBy(xpath = "//android.view.View[@text='What are you looking for?']")
    private MobileElement searchButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc= 'Categories']/android.widget.ImageView")
    private MobileElement categories;
    @AndroidFindBy(id = "com.manash.purplle:id/menu_cart_bag")
    private MobileElement homeButtonInMenu;
    @AndroidFindBy(xpath="//android.view.View[@text='Home']")
    private MobileElement HomeoptionInMenu;
    @AndroidFindBy(xpath="//android.widget.Button[@text='Open navigation menu']/following-sibling::android.view.View[@class='android.view.View'][2]")
    private MobileElement myCartbutton;
    //android.widget.Button[@text='Open navigation menu']/following-sibling::android.view.View[@class='android.view.View'][2]


    public MobileElement getHomeoptionInMenu() {
        return HomeoptionInMenu;
    }

    public MobileElement getMyCartbutton() {
        return myCartbutton;
    }

    public MobileElement getMenuButton() {
        return menuButton;
    }

    public MobileElement getProfileButton() {
        return profileButton;
    }

    public MobileElement getHomeButton() {
        return homeButton;
    }

    public MobileElement getBrandButton() {
        return brandButton;
    }

    public MobileElement getOffersButton() {
        return offersButton;
    }

    public MobileElement getStudioButton() {
        return studioButton;
    }

    public MobileElement getSearchButton() {
        return searchButton;
    }

    public MobileElement getCategories() {
        return categories;
    }
    public void clickOnhomeButton(AppiumDriver driver) {
        mo.waitAndClick(driver,homeButton );
    }
    public void clickOnCategories(AppiumDriver driver)
    {
     //getCategories().click();
     mo.waitAndClick(driver,getHomeButton() );
    }
}
