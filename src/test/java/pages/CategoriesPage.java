package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.MobileUtils;

import java.util.List;

public class CategoriesPage
{
    AndroidDriver apkDriver;
    String CategoryName="";
    String SubCategory="";
    String product="";
    


    public CategoriesPage(AndroidDriver apkDriver)
    {
        this.apkDriver = apkDriver;
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver)apkDriver), this);
    }
    @AndroidFindBy(id = "com.manash.purplle:id/toolbar_title")
    private MobileElement categoriesTitle;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.webkit.WebView//android.view.View/android.widget.TextView")
    private List<MobileElement> allCategories;
    
    //@AndroidFindBy(xpath = "//android.widget.TextView[@text='Makeup ']")
    //private List<MobileElement> CategoriesGeneric;

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

    public void setMomAndBabyCategories(MobileElement momAndBabyCategories) {
        this.momAndBabyCategories = momAndBabyCategories;
    }
    
    
    public MobileElement getCategoryLink(String category) {
    	MobileElement categoryLink =(MobileElement) apkDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+category+"')]"));
    	return categoryLink;
    	}
    public MobileElement getSubCategoryLink(String Subcategory) {
    	MobileElement SubCategoryLink =(MobileElement) apkDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+Subcategory+"')]"));
    	return SubCategoryLink;
    	}
    public MobileElement getProdCategoryLink(String ProdCategory) {
    	MobileElement ProdCategoryLink =(MobileElement) apkDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+ProdCategory+"')]"));
    	return ProdCategoryLink;
    	}


    public void chooseCategories()
    {
        MobileUtils mUtil = new MobileUtils();
        mUtil.scrollToElementAndClick(apkDriver, men);
        mUtil.scrollToElementAndClick(apkDriver, fragrance);
        mUtil.scrollToElementAndClick(apkDriver, perfume);
    }
    public void chooseCategories(String Categories,String SubCategories,String ProductCategories) throws Throwable
    {
    	Thread.sleep(2000);
        MobileUtils mUtil = new MobileUtils();
        mUtil.scrollToElementAndClick(apkDriver, getCategoryLink(Categories));
        mUtil.scrollToElementAndClick(apkDriver, getSubCategoryLink(SubCategories));
        mUtil.scrollToElementAndClick(apkDriver, getProdCategoryLink(ProductCategories));
    }
    public void ScrollToMaternity() throws Throwable
    {
    	Thread.sleep(1000);
        MobileUtils mUtil = new MobileUtils();

        mUtil.scrollToElementAndClick(apkDriver, getMaternitySubCategory());
    }



}
