package pages.womens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Header;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static utils.ActionUtils.scrollToElement;

public class WomenShopByStyleShoesPage extends Header {
    public WomenShopByStyleShoesPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfShoesCategoriesInBackMenu() {
        //waitClickableElement("//button[@aria-controls='refinement-model']");
       // scrollToElement(driver, waitPresenceOfElement("//button[@aria-controls='refinement-technology']"));
        WebElement blockElement = waitPresenceOfElement("//ul[@class='values content d-flex']");
        Actions actions = new Actions(driver);
        actions.moveToElement(blockElement).perform();

        List<WebElement> menuItems = waitPresenceOfAllElements("//ul[@class='values content d-flex']//button[@class='tl_filter_categories pl-0']");
        return menuItems.size();
    }
//    public int getNumberOfShoesCategoriesInBackMenu() {
//
//
//        int count = 0;
//        List<WebElement> menuItems = new ArrayList<>();
//        for (WebElement element : menuItems) {
//            moveToElement(driver, waitPresenceOfElement("//button[contains(@data-href,'/women/shop-by-model/')]"));
//            count++;
//        }
//
//        return count;
//    }

}
