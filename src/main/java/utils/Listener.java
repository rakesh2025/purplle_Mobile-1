package utils;
import java.time.LocalDateTime;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
public class Listener implements ITestListener {
    public static ExtentTest test;

    public static ExtentReports report;

    public void onTestStart(ITestResult result)
    {

        test=report.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result)
    {

        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        //test.log(Status.PASS, result.getThrowable());

    }

    public void onTestFailure(ITestResult result)

    {
        test.log(Status.FAIL, result.getThrowable());
        test.log(Status.FAIL, result.getMethod().getMethodName()+"is Failed");
        String path=null;
        try {
            MobileUtils util=new MobileUtils();


        } catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP, result.getMethod().getMethodName());
        test.log(Status.SKIP, result.getThrowable());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
    }

    public void onStart(ITestContext context)
    {

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport/" + LocalDateTime.now().toString().replace(":", "-")+".html").viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY}).apply();
        htmlReporter.config().setReportName("Shop Cosmetics Products and Beauty Products Online on Purplle at Best Price");
        htmlReporter.config().setDocumentTitle("purplle Application");
        htmlReporter.config().setTheme(Theme.DARK);

        report=new ExtentReports();
        report.attachReporter(htmlReporter);
        report.setSystemInfo("OS", "Mac");
        report.setSystemInfo("Environment", "Testing Environment");
        report.setSystemInfo("URL", "https://www.purplle.com/");
        report.setSystemInfo("Reporter Name", "Rakesh");

    }

    public void onFinish(ITestContext context)
    {
        report.flush();
    }
}
