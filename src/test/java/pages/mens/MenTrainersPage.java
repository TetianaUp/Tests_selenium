package pages.mens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.refreshed;
import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollToElement;

public class MenTrainersPage extends Header {
    public MenTrainersPage(WebDriver driver) {
        super(driver);
    }

    public final String PRICE_FILTER = "//div[contains(@class,'card-header')]//button[@aria-controls='refinement-price']";

    public MenTrainersPage selectFilteringByPrice(String parameterForFiltering) {
        clickOnElement(driver, waitClickableElement(PRICE_FILTER));
        waitPresenceOfElement(parameterForFiltering).click();
        waitForLoaderToDisappear();

        return this;
    }

    public List<Double> getProductPrices(String locator) {
        List<Double> prices = new ArrayList<>();
        int currentIndex = 0;

        while (currentIndex < getProductPriceElementsCount(locator)) {
            WebElement element = wait.until(refreshed(presenceOfAllElementsLocatedBy(xpath(locator)))).get(currentIndex);
            scrollToElement(driver, element);

            Double price = extractPriceFromElement(element);
            prices.add(price);
            currentIndex++;
        }
        return prices;
    }

    private int getProductPriceElementsCount(String locator) {
        return waitPresenceOfAllElements(locator).size();
    }


    private List<WebElement> updateProductPriceElementsIfNewOnesAppear(List<WebElement> currentProductPriceElements, String locator) {
        List<WebElement> newProductPriceElements = waitPresenceOfAllElements(locator);
        if (newProductPriceElements.size() > currentProductPriceElements.size()) {
            return newProductPriceElements;
        }
        return currentProductPriceElements;
    }
}
