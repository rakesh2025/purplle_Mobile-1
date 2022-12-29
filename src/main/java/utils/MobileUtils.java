package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

public class MobileUtils
{

    AppiumDriver apkDriver;
    public static Logger logger;
    public WebDriver wait;


    public static void logger()
    {
        logger = logger == null ? Logger.getLogger(MobileUtils.class) : logger;
    }

    public void scrollToElementAndClick(AndroidDriver apkDriver, MobileElement me) {
        while (true) {
            try {


                if (me.isDisplayed()) {
                    //System.out.println("conditon passed so clicking on element");
                    me.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Catch block activated and performing scrolling down");
                TouchAction touch = new TouchAction(apkDriver);
                touch.press(PointOption.point(500, 1600))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(500, 500)).release().perform();
            }
        }
    }


    public void softValidation(String x, String y)
    {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(x,y);

    }

    public void hardValidation(String x, String y)
    {
        Assert.assertEquals(x,y);
    }

    public void clickOnMobileElement(AndroidDriver apkDriver, MobileElement me)
    {
        me.click();
    }
    public String TakesScreenShots(AppiumDriver apkDriver,String screenshotName)
    {
String localDateTime= LocalDateTime.now().toString().replace(":","-");
String filePath = "./errorshots"+screenshotName+localDateTime+".png";
TakesScreenshot ts = (TakesScreenshot) apkDriver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        try {
            FileUtils.copyFile(scrFile, dest);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dest.getAbsolutePath();

    }
    public void waitAndClick(AppiumDriver apkDriver,WebElement ele) {
    	
    	WebDriverWait wait =new WebDriverWait(apkDriver, 10);
    	wait.until(ExpectedConditions.visibilityOf(ele));     
    	ele.click();
    }
    public void scrollUpToElement(AndroidDriver apkDriver, MobileElement me) {
        while (true) {
            try {


                if (me.isDisplayed()) {
                    //System.out.println("conditon passed so clicking on element");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Catch block activated and performing scrolling down");
                TouchAction touch = new TouchAction(apkDriver);
                touch.press(PointOption.point(500, 500))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(500, 1500)).release().perform();
            }
        }
    }



}
