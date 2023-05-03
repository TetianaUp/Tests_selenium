package pages;

import org.openqa.selenium.WebDriver;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollForElement;

public class WomenDressesPage extends Header {
    public WomenDressesPage(WebDriver driver) {
        super(driver);
    }

    public final static String WOMEN_DRESSES_COLOR = "//button[@aria-controls='refinement-colour']";
    public final String DRESS_PRODUCT = "//div[@class='pgptiles col-6 col-lg-4 px-1 px-lg-2'][3]";

    public WomenDressesPage filteringByColor(String parametrForFilterring) {
        waitClickableElement(WOMEN_DRESSES_COLOR).click();
        scrollForElement(driver, waitPresenceOfElement("//button[@aria-controls='refinement-activity']"));
        clickOnElement(driver, waitClickableElement(parametrForFilterring));

        return this;
    }

    public ProductPage getProduct() {
        waitClickableElement(DRESS_PRODUCT).click();

        return new ProductPage(driver);
    }

}
