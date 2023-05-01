package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.ActionUtils.scrollForElement;

public class HomePage extends Header {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public final static String HOME_URL = "https://www.newbalance.co.uk/";
    public final static String NEW_ARRIVAL_PART = "//div[@class='ml-lg-11 ml-3']";
    public final static String CATEGORY_550 = "//div[@class='flex flex-column'][descendant::span[text()='550']]";
    public final static String NEXT_ARROW = "//div[@class='ml-lg-11 ml-3']//button[@class='slide-arrow next-arrow slick-arrow']";

    public HomePage acceptAllCookies() {
        waitClickableElement("//button[@id='consent_prompt_submit']").click();

        return this;
    }

    public HomePage acceptPopUp() {
        waitClickableElement("//button[@id='discountPopUpCloseBtn']").click();

        return this;
    }

    public HomePage find550CategoryInNewArrivals() {
        scrollForElement(driver, waitPresenceOfElement(NEW_ARRIVAL_PART));
        getProductCategoryName();
        return this;
    }

    public void getProductCategoryName() {
        List<String> categoryName = new ArrayList();
        List<WebElement> productNameElementsNewArrival = waitPresenceOfAllElements(
                "//span[@class='product-name font-body font-weight-semibold mb-2 mb-lg-0']");
        for (WebElement element : productNameElementsNewArrival) {
            String nameCategoryNewArrival = element.getText();
            categoryName.add(nameCategoryNewArrival);
            if (nameCategoryNewArrival.equals("550")) {
                element.click();
                break;
            } else {
                waitPresenceOfElement(NEXT_ARROW).click();
            }
        }
    }
//    public HomePage moveToMenFootballCategory(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(waitPresenceOfElement(MEN_CATEGORY))
//                .moveToElement(waitPresenceOfElement(MEN_FOOTBALL_CATEGORY))
//                .click();
//
//        return this;
//    }
}
