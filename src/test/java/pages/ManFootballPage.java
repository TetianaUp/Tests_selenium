package newBalance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ManFootballPage extends AbstractHeader {

    public ManFootballPage(WebDriver driver) {
        super(driver);
    }

    public final static String PRODUCT_PRICE = "//span[@class='sales font-body-large ']";

    public ManFootballPage moveToMenFootballCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getManCategory())
                .moveToElement(getManFootballCategory())
                .click();

        return this;
    }

    public String TITLE_CATEGORY =
            waitVisibilityOfElement("//h1[contains(@class, 'js-griddisplay-name page-category')]")
                    .getText();
}
