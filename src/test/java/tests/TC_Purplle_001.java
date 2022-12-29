package tests;


import com.aventstack.extentreports.Status;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseClass;
import utils.Listener;
import utils.MobileUtils;

/**
 * @Description Opening the app  & verified all pages are opening or not ..
 * 
 *
 */
@Listeners(utils.Listener.class)
public class TC_Purplle_001 extends BaseClass
{

    @Test
    public void checkAllPages() throws Throwable
    {
        HomePage hp = new HomePage(apkDriver);
        Thread.sleep(2000);
        Assert.assertTrue(hp.getSearchButton().isDisplayed(),"Home page is not displaying");
        Listener.test.log(Status.INFO,"Verified Home page.");
        //Clicking on Category
        hp.getCategories().click();
        CategoriesPage catPage = new CategoriesPage(apkDriver);
        Assert.assertEquals(catPage.getCategoriesTitle().isDisplayed(),true);
        Listener.test.log(Status.INFO,"Verified Category page.");
        MobileUtils mUtils = new MobileUtils();
        mUtils.scrollToElementAndClick(apkDriver, catPage.getMomAndBabyCategories());
        catPage.ScrollToMaternity();
        //Thread.sleep(2000);
        //mUtils.scrollToElementAndClick(apkDriver, catPage.getCategoryLink("Mom & Baby "));
        
        //Clicked on brand button
        hp.getBrandButton().click();
        BrandsPage brandPage = new BrandsPage(apkDriver);
        Listener.test.log(Status.INFO,"Verified Brand page.");
        brandPage.getSearchFiled().sendKeys("Lakme");
        Assert.assertTrue(brandPage.getSearchFiled().isDisplayed(),"Search field is not displaying.");
        //apkDriver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        brandPage.clickOnBrandName(apkDriver);
        Assert.assertTrue(brandPage.getBrandPageTitle().isDisplayed(),"Brand page is opening.");
        List<MobileElement> li = brandPage.getProductListInBrandPage();
        for(MobileElement ele:li) {
        	System.out.println(ele);
        	Assert.assertTrue(ele.getText().contains("Lakme"),"List showing differnt brand product.");
        }
        Listener.test.log(Status.INFO,"Verified the product.");
        brandPage.clickOnBackButton();
        apkDriver.hideKeyboard();
        //Thread.sleep(2000);
        //Clicked on offer button
        hp.getOffersButton().click();
        OfferPage op=new OfferPage(apkDriver);
        Assert.assertTrue(op.getOfferTitle().isDisplayed(),"Offer Page is not displaying");
        Listener.test.log(Status.INFO,"Verified offer page.");
        
        
        //Clicked on studio button
        hp.getStudioButton().click();
        Thread.sleep(3000);
        BeautyStudioPage bsp=new BeautyStudioPage(apkDriver);
        Assert.assertTrue(bsp.getBeautyStudioPageTitle().isDisplayed(),"Beauty Studio page is not dispolaying");
        Listener.test.log(Status.INFO,"Verified Beauty Studio page.");
    }
}
