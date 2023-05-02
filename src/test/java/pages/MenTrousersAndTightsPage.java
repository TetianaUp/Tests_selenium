package pages;

import org.openqa.selenium.WebDriver;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollForElement;

public class MenTrousersAndTightsPage extends Header {
    public MenTrousersAndTightsPage(WebDriver driver) {
        super(driver);
    }

    public final String PRICE_FILTER = "//button[@aria-controls='refinement-price']";
    public final String FEATURES_FILTER = "//button[@aria-controls='refinement-features']";
    //public final String FEATURES_FILTER = "//button[@aria-controls='refinement-features']";
    private final String QUICK_DRY_FEATURE = "//label[@for='primarytechnology-quick-dry-0']";
    public final String FIRST_PRODUCT = "//div[@class='pgptiles col-6 col-lg-4 px-1 px-lg-2'][1]";

    public MenTrousersAndTightsPage filteringByFeature() {
        scrollForElement(driver, waitPresenceOfElement(PRICE_FILTER));
        waitClickableElement(FEATURES_FILTER).click();
        clickOnElement(driver, waitPresenceOfElement(QUICK_DRY_FEATURE));
        //waitPresenceOfElement(QUICK_DRY_FEATURE).click();

        return this;
    }

    public ProductPage getFirstProduct() {
        waitClickableElement(FIRST_PRODUCT).click();

        return new ProductPage(driver);
    }

}
