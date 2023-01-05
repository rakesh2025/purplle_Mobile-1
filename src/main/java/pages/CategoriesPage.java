package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MobileUtils;

public class CategoriesPage
{
   // AndroidDriver apkDriver;

    //String SubCategory="";
   // String product="";



    public CategoriesPage(AppiumDriver driver)
    {
      //  this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

	@AndroidFindBy(id = "com.manash.purplle:id/toolbar_title")
    private MobileElement categoriesTitle;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.webkit.WebView//android.view.View/android.widget.TextView")
    private List<MobileElement> allCategories;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Men')]")
    private MobileElement men;
    @AndroidFindBy(xpath = "//android.view.View[@text = 'Fragrance']")
    private MobileElement fragrance;
    @AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Perfumes')]")
    private MobileElement perfume;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Mom & Baby ']")
    private MobileElement momAndBabyCategories;
    @AndroidFindBy(xpath = "//android.view.View[contains(@text,'Maternity')]")
    private MobileElement MaternitySubCategory;
    
   
	public MobileElement getCategoriesTitle() {
        return categoriesTitle;
    }
    public MobileElement getMaternitySubCategory() {
		return MaternitySubCategory;
	}
	public MobileElement getMomAndBabyCategories() {
        return momAndBabyCategories;
    }

	/*
	 * public void setMomAndBabyCategories(MobileElement momAndBabyCategories) {
	 * this.momAndBabyCategories = momAndBabyCategories; }
	 */
	public MobileElement getCategory(AppiumDriver driver,String categoryName) {
		MobileElement category = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().textContains(\""+categoryName+"\"))"));
		return category;
    	}
	
    public MobileElement getCategoryLink(AppiumDriver driver,String category) {
    	MobileElement categoryLink =(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+category+"')]"));
    	return categoryLink;
    	}
    public MobileElement getSubCategoryLink(AppiumDriver driver,String Subcategory) {
    	MobileElement SubCategoryLink =(MobileElement) driver.findElement(By.xpath("//android.view.View[contains(@text,'"+Subcategory+"')]"));
    	return SubCategoryLink;
    	}
    public MobileElement getProdCategoryLink(AppiumDriver driver,String ProdCategory) {
    	MobileElement ProdCategoryLink =(MobileElement) driver.findElement(By.xpath("//android.view.View[contains(@text,'"+ProdCategory+"')]"));
    	return ProdCategoryLink;
    	}



    public void chooseCategories(AppiumDriver driver)
    {
        MobileUtils mUtil = new MobileUtils();
        mUtil.scrollToElementAndClick(driver, men);
        mUtil.scrollToElementAndClick(driver, fragrance);
        mUtil.scrollToElementAndClick(driver, perfume);
    }
    public void chooseCategories(AppiumDriver driver,String Categories,String SubCategories,String ProductCategories) throws Throwable
    {
    	Thread.sleep(2000);
        MobileUtils mUtil = new MobileUtils();
        //mUtil.scrollToElementAndClick(driver, getCategoryLink(driver, Categories));
        mUtil.scrollToElementAndClick(driver,getCategoryLink(driver, Categories) );
        mUtil.scrollToElementAndClick(driver, getSubCategoryLink(driver, SubCategories));
        mUtil.scrollToElementAndClick(driver, getProdCategoryLink(driver, ProductCategories));
    }
   
	public void ScrollToMaternity(AppiumDriver driver) throws Throwable
    {
    	Thread.sleep(1000);
        MobileUtils mUtil = new MobileUtils();

        mUtil.scrollToElementAndClick(driver, getMaternitySubCategory());
    }
	public void ClickOnCategory(AppiumDriver driver,String categoryName) throws Throwable
    {
		getCategory(driver, categoryName).click();
    }


}
