package pages.womens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

public class WomenSandalsPage extends Header {
    public WomenSandalsPage(WebDriver driver) {
        super(driver);
    }

    public final static String WOMEN_SANDALS_PRICE = "//button[@aria-controls='refinement-price']";

    public WomenSandalsPage filteringByPrice(String parametrForFilterring) {
        waitClickableElement(WOMEN_SANDALS_PRICE).click();
        waitPresenceOfElement(parametrForFilterring).click();

        return this;
    }

    public List<Double> getProductPrices(String locator) {
        List<Double> prices = new ArrayList<>();
        List<WebElement> productPriceElements = waitPresenceOfAllElements(locator);
        for (WebElement element : productPriceElements) {
            String priceText = element.getText().replace("£", "");
            Double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        return prices;
    }

}
