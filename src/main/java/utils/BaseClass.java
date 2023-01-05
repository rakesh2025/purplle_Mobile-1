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
    //public  static AppiumDriver aDriver;
    public  AppiumDriver driver;
    public static AppiumDriver sDriver;
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

        driver = new AndroidDriver(url, dbuild.getDesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       sDriver=driver;
    }



    @AfterMethod(alwaysRun = true)
    public void logoutApp()
    {
    	driver.quit();
    }


    @AfterClass(alwaysRun = true)
    public void closeApp() throws InterruptedException {

    }

    @AfterSuite(alwaysRun = true)
    public void stopingServer()
    {
        dbuild.stopServer();
    }


}
