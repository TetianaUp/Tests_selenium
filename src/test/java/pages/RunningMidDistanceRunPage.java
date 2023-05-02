package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RunningMidDistanceRunPage extends Header{
    public RunningMidDistanceRunPage(WebDriver driver) {
        super(driver);
    }
    public final static String MDRUN_PRODUCT_PRICE = "//span[@class='sales font-body-large ']";

    public RunningMidDistanceRunPage sortByPriceLowToHigh() {
        Select selectByHighLowPrice = new Select(getSortDropdownMenu());
        selectByHighLowPrice.selectByVisibleText("\n" +
                "                    Price (Low-High)\n" +
                "                ");

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
