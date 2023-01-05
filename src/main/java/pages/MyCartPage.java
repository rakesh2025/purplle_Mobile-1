package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyCartPage
{

    //AndroidDriver apkDriver;

    public MyCartPage(AppiumDriver driver)
    {
    	//this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/toolbar_title")
    private MobileElement myCartPageTitle;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backbutton;

    public MobileElement getMyCartPageTitle() {
        return myCartPageTitle;
    }


    public MobileElement getBackbutton() {
        return backbutton;
    }
}






