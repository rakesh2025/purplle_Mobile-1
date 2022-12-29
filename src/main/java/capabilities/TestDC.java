package capabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class TestDC
{

    @Test
    public void desiredCapability() throws Exception
    {
        DesiredCapabilities dCap = new DesiredCapabilities();

        dCap.setCapability("platformName", "Android");
        dCap.setCapability("deviceName", "Pixel 4 API 31");
        dCap.setCapability("udid", "emulator-5554");
        dCap.setCapability("platformVersion", "12");
        dCap.setCapability("appPackage", "com.manash.purplle");
        dCap.setCapability("appActivity", "activity.SplashActivity");
        dCap.setCapability("noReset", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

        AndroidDriver<MobileElement> apkDriver = new AndroidDriver<MobileElement>(url, dCap);
//        apkDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

}