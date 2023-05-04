package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollForElement;

public class WomenAllClothingPage extends Header {
    public WomenAllClothingPage(WebDriver driver) {
        super(driver);
    }

    private final String FIT_FILTER = "//button[@aria-controls='refinement-fit']";
    private final String OVERSIZED_FILTER = "//span[contains(text(),'Oversized')]";
    private final String PRODUCT_TITLE = "//div[@class='pdp-link']";

    public WomenAllClothingPage filteringByFit() {
        scrollForElement(driver, waitPresenceOfElement(FIT_FILTER));
        waitClickableElement(FIT_FILTER).click();
        scrollForElement(driver, waitPresenceOfElement(OVERSIZED_FILTER));
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
