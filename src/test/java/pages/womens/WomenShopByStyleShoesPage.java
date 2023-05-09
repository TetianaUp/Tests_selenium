package pages.womens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Header;

import java.util.List;

public class WomenShopByStyleShoesPage extends Header {
    public WomenShopByStyleShoesPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfShoesCategoriesInBackMenu() {
        WebElement blockElement = waitPresenceOfElement("//ul[@class='values content d-flex']");
        Actions actions = new Actions(driver);
        actions.moveToElement(blockElement).perform();

        List<WebElement> menuItems = waitPresenceOfAllElements("//ul[@class='values content d-flex']//button[@class='tl_filter_categories pl-0']");
        return menuItems.size();
    }

    public int getNumberOfShoesCategoriesInHeader() {

        List<WebElement> menuItems = waitPresenceOfAllElements("//li[@data-testid='category-Women']//li[contains(@class,'Shop by model')]//li[contains(@class,'dropdown-item') and not(contains(@class,'More'))]");
        return menuItems.size();
    }


}
