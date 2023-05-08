package pages.mens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.scrollToElement;

public class MensBagsBackpacksPage extends Header {
    public MensBagsBackpacksPage(WebDriver driver) {
        super(driver);
    }

    private final String PRICE_FILTER = "//button[@aria-controls='refinement-price']";
    private final String ACTIVITY_FILTER = "//button[@aria-controls='refinement-activity']";
    private final String FOOTBALL_FILTER = "//span[contains(text(),'Football')][1]";
    public final static String PRODUCT_PRICE_b = "//span[@class='sales font-body-large ']";

    public MensBagsBackpacksPage filteringByActivity() {
        scrollToElement(driver, waitPresenceOfElement(PRICE_FILTER));
        waitClickableElement(ACTIVITY_FILTER).click();
        clickOnElement(driver, waitPresenceOfElement(FOOTBALL_FILTER));

        return this;
    }

    public int getNumberOfProductsInCategory() {
        String numberStr = driver.findElement(By
                        .xpath("//div[@class='pgp-grids col-12 col-lg-9 pr-lg-0 pl-lg-7']//span[@class='pgp-count']"))
                .getText();
        int numbInStr = Integer.parseInt(numberStr);
        return numbInStr;
    }

    public MensBagsBackpacksPage sortByPriceLowToHigh() {
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
            String priceText = element.getText().replace(".", "").replace("£", "");
            Double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        return prices;
    }
}
