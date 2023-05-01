package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MenTrainersPage extends Header {
    public MenTrainersPage(WebDriver driver) {
        super(driver);
    }

    public final String PRICE_FILTER = "//button[@aria-controls='refinement-price']";

    public String getTitleCategory() {
        return waitVisibilityOfElement("//h1[contains(@class, 'js-griddisplay-name page-category')]")
                .getText();
    }

    public MenTrainersPage filteringByPrice(String parametrForFilterring) {
        waitClickableElement(PRICE_FILTER).click();
        waitClickableElement(parametrForFilterring).click();

        return this;
    }

    public List<Double> getProductPrices(String locator) {
        List<Double> prices = new ArrayList<>();
        List<WebElement> productPriceElements = waitPresenceOfAllElements(locator);
        for (WebElement element : productPriceElements) {
            String priceText = element.getText().replace(".", "").replace("£", "");
            Double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        return prices;
    }
}
