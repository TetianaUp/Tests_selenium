package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MenFootballPage extends Header {

    public MenFootballPage(WebDriver driver) {
        super(driver);
    }

    public final static String PRODUCT_PRICE = "//span[@class='sales font-body-large ']";


    public MenFootballPage sortByPriceHighToLow() {
        Select selectByHighLowPrice = new Select(getSortDropdownMenu());
        selectByHighLowPrice.selectByVisibleText("\n" +
                "                    Price (High-Low)\n" +
                "                ");

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
