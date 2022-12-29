package utils;

import capabilities.DesiredCapabilitiesBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import org.testng.annotations.*;

import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass extends MobileUtils
{
    public  static AppiumDriver aDriver;
    public AndroidDriver apkDriver;
    public DesiredCapabilitiesBuilder dbuild = new DesiredCapabilitiesBuilder();
    

    @BeforeSuite(alwaysRun = true)
    public void staringServer()
    {
        dbuild.startServer();
    }

    @BeforeClass(alwaysRun = true)
    public void openApp()
    {

    }


    @BeforeMethod(alwaysRun = true)
    public void loginApp() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

        apkDriver = new AndroidDriver(url, dbuild.getDesiredCapabilities());
        apkDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }



    @AfterMethod(alwaysRun = true)
    public void logoutApp()
    {
        apkDriver.quit();
    }


    @AfterClass(alwaysRun = true)
    public void closeApp() throws InterruptedException {
        Thread.sleep(5000);
        apkDriver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopingServer()
    {
        dbuild.stopServer();
    }


}
