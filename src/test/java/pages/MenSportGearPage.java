package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MenSportGearPage extends Header {
    public MenSportGearPage(WebDriver driver) {
        super(driver);
    }

    public final static String SPORT_GEAR_PRICE = "//span[@class='sales font-body-large ']";
    public final String PRICE_FILTER = "//button[@aria-controls='refinement-price']";

    //ul[@class='values content price']//span[contains(text(),'Over £100')][1]
    public MenSportGearPage filteringByPrice(String parametrForFilterring) {
        waitClickableElement(PRICE_FILTER).click();
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
