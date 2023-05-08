package pages.womens;

import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProductPage;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollToElement;

public class WomenDressesPage extends Header {
    public WomenDressesPage(WebDriver driver) {
        super(driver);
    }

    public final static String WOMEN_DRESSES_COLOR = "//button[@aria-controls='refinement-colour']";
    public final String DRESS_PRODUCT = "//div[@class='pgptiles col-6 col-lg-4 px-1 px-lg-2'][1]";

    public WomenDressesPage filteringByColor(String parameterForFiltering) {
        waitClickableElement(WOMEN_DRESSES_COLOR).click();
        scrollToElement(driver, waitPresenceOfElement("//button[@aria-controls='refinement-activity']"));
        clickOnElement(driver, waitClickableElement(parameterForFiltering));

        return this;
    }

    public ProductPage getProduct() {
        waitClickableElement(DRESS_PRODUCT).click();

        return new ProductPage(driver);
    }
}
