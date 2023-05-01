package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ManFootballPage extends Header {

    public ManFootballPage(WebDriver driver) {
        super(driver);
    }

    public final static String PRODUCT_PRICE = "//span[@class='sales font-body-large ']";

//    public ManFootballPage moveToMenFootballCategory() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(getManCategory())
//                .moveToElement(getManFootballCategory())
//                .click();
//
//        return this;
//    }

    public String getTitleCategory() {
        return waitVisibilityOfElement("//h1[contains(@class, 'js-griddisplay-name page-category')]")
                .getText();
    }

    public ManFootballPage sortByPriceHighToLow() {
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
