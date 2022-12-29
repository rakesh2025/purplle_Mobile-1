package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OfferPage
{

    //AndroidDriver apkDriver;

    public OfferPage(AndroidDriver apkDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/app_bar_")
    private MobileElement offerTitle;

    public MobileElement getOfferTitle() {
        return offerTitle;
    }
}






