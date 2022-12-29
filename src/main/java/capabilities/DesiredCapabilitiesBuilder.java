package capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DesiredCapabilitiesBuilder
{
    public AppiumDriver<MobileElement> aDriver;
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @Test
    public DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities dCap = new DesiredCapabilities();
        dCap.setCapability("platformName","Android");
        dCap.setCapability("deviceName", "Pixel 4");
        dCap.setCapability("udid", "emulator-5554");
        dCap.setCapability("platformVersion", "12");
        dCap.setCapability("appPackage", "com.manash.purplle");
        dCap.setCapability("appActivity", "activity.SplashActivity");
        dCap.setCapability("noReset", true);

        return dCap;
    }




    public void startServer()
    {
        service = AppiumDriverLocalService.buildDefaultService().buildService(new AppiumServiceBuilder().withLogFile(new File("./logs/appiumLogs.txt")));
        service.start();
    }

    public void stopServer()
    {

        service.stop();
    }
}
