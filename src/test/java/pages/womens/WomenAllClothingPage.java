package pages.womens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Header;

import java.util.List;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollToElement;

public class WomenAllClothingPage extends Header {
    public WomenAllClothingPage(WebDriver driver) {
        super(driver);
    }

    private final String FIT_FILTER = "//button[@aria-controls='refinement-fit']";
    private final String OVERSIZED_FILTER = "//span[contains(text(),'Oversized')]";
    private final String PRODUCT_TITLE = "//div[@class='pdp-link']";

    public WomenAllClothingPage filteringByFit() {
        scrollToElement(driver, waitPresenceOfElement(FIT_FILTER));
        waitClickableElement(FIT_FILTER).click();
        scrollToElement(driver, waitPresenceOfElement(OVERSIZED_FILTER));
        clickOnElement(driver, waitPresenceOfElement(OVERSIZED_FILTER));

        return this;
    }

    public int findProductTitleContainsOVersized() {
        int count = 0;
        List<WebElement> productTitleElements = waitPresenceOfAllElements(PRODUCT_TITLE);
        for (WebElement element : productTitleElements) {
            if (element.getText().contains("Oversized"))
                count++;
        }

        return count;
    }
}
