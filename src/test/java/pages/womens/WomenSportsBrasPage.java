package pages.womens;

import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProductPage;

import static utils.ActionUtils.clickOnElement;

public class WomenSportsBrasPage extends Header {
    public WomenSportsBrasPage(WebDriver driver) {
        super(driver);
    }

    private final String SIZE_FILTER = "//div[@class='refinement-womensapparelsize']";
    private final String FIRST_PRODUCT = "//div[@class='pgptiles col-6 col-lg-4 px-1 px-lg-2']";

    public WomenSportsBrasPage filteringBySize(String size) throws InterruptedException {
        waitClickableElement(SIZE_FILTER).click();
        clickOnElement(driver, waitPresenceOfElement(size));
        wait(3000);

        return this;
    }

    public ProductPage getProduct() throws InterruptedException {
        clickOnElement(driver, waitPresenceOfElement(FIRST_PRODUCT));
        wait(2000);

        return new ProductPage(driver);
    }

}
