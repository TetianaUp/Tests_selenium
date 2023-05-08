package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.ActionUtils.scrollToElement;
import static utils.RandomUtils.randomNum;

public class HomePage extends Header {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public final static String HOME_URL = "https://www.newbalance.co.uk/";
    public final static String BEST_SELLERS_PART = "//div[contains(@class, 'row category-carousel')]";
    public final String FIRST_CATEGORY_BS = "//a[@href='/550/']";
    public final static String NEW_ARRIVAL_PART = "//div[@class='ml-lg-11 ml-3']";
    public final static String NEXT_ARROW_BEST_SELLERS_RIGHT = "//div[contains(@class, 'row category-carousel')]//button[@class='slide-arrow next-arrow slick-arrow']";
    public final static String NEXT_ARROW_BEST_SELLERS_LEFT = "//div[contains(@class, 'row category-carousel')]//button[@class='slide-arrow prev-arrow slick-arrow']";

    public HomePage acceptAllCookies() {
        waitClickableElement("//button[@id='consent_prompt_submit']").click();

        return this;
    }

    public HomePage acceptPopUp() {
        waitClickableElement("//button[@id='discountPopUpCloseBtn']").click();

        return this;
    }

    public String findRandomCategoryInNewArrivals() {
        scrollToElement(driver, waitPresenceOfElement(NEW_ARRIVAL_PART));

        return getProductCategoryName();
    }

    public String getProductCategoryName() {
        List<String> categoryNames = getCategoryNames();
        String randomCategoryName = getRandomCategoryName(categoryNames);
        clickOnRandomCategoryName(randomCategoryName);

        return randomCategoryName;
    }

    private List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        Set<String> uniqueCategoryNames = new HashSet<>();

        while (isElementPresent(NEXT_ARROW_BEST_SELLERS_RIGHT)) {
            List<WebElement> productNameElementsNewArrival = waitPresenceOfAllElements("//span[contains(@class, 'product-name')]");
            for (WebElement element : productNameElementsNewArrival) {
                String categoryName = element.getText();
                if (!categoryName.isEmpty()) {
                    uniqueCategoryNames.add(categoryName);
                }
            }
            waitPresenceOfElement(NEXT_ARROW_BEST_SELLERS_RIGHT).click();
        }

        categoryNames.addAll(uniqueCategoryNames);
        return categoryNames;
    }

    private boolean isElementPresent(String locator) {
        try {
            waitPresenceOfElement(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private String getRandomCategoryName(List<String> categoryNames) {
        var randomIndex = randomNum(categoryNames.size());
        return categoryNames.get(randomIndex);
    }

    private void clickOnRandomCategoryName(String randomCategoryName) {
        boolean clicked = false;
        List<WebElement> productNameElementsNewArrival;

        while (!clicked && isElementPresent(NEXT_ARROW_BEST_SELLERS_LEFT)) {
            productNameElementsNewArrival = waitPresenceOfAllElements("//span[contains(@class, 'product-name')]");
            for (WebElement element : productNameElementsNewArrival) {
                String nameCategoryNewArrival = element.getText();
                if (nameCategoryNewArrival.equals(randomCategoryName)) {
                    element.click();
                    clicked = true;
                    break;
                }
            }

            if (!clicked) {
                waitPresenceOfElement(NEXT_ARROW_BEST_SELLERS_RIGHT).click();
            }
        }
    }

    public Category550Page get550CategoryInBestSellers() {
        scrollToElement(driver, waitPresenceOfElement(BEST_SELLERS_PART));
        waitClickableElement(FIRST_CATEGORY_BS).click();
        return new Category550Page(driver);
    }

    public HomePage scrollToItemsCounter() {
        scrollToElement(driver, waitPresenceOfElement("//div[contains(@class, 'products-viewed')]"));

        return this;
    }

//    public RegistrationPage clickJoinToCreateAccount() {
//        waitClickableElement("//div[contains(@class, 'navbar-header')]//span[@title='Join']").click();
//
//
//        return new RegistrationPage(driver);
//    }


//    public RegistrationPage choseLogIn() {
//        waitClickableElement("//div[@data-copy-from='account-header']//span[@title='Log in']").click();
//        return new RegistrationPage(driver);
//    }

}
