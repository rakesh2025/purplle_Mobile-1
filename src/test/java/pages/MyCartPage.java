package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage
{

    AndroidDriver apkDriver;

    public MyCartPage(AndroidDriver apkDriver)
    {
    	this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/toolbar_title")
    private MobileElement myCartPageTitle;

    public MobileElement getMyCartPageTitle() {
        return myCartPageTitle;
    }
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backbutton;

    public MobileElement getBackbutton() {
        return backbutton;
    }
}






