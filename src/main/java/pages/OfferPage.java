package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OfferPage
{

    //AndroidDriver apkDriver;

    public OfferPage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.manash.purplle:id/app_bar_")
    private MobileElement offerTitle;

    public MobileElement getOfferTitle() {
        return offerTitle;
    }
}






