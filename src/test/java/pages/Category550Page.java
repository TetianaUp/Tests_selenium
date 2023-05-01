package newBalance.pages;

import org.openqa.selenium.WebDriver;

public class Category550Page extends BasePage {

    public Category550Page(WebDriver driver) {
        super(driver);
    }

    public final static String PRODUCT_NAME = "//h1[@class='product-name hidden-sm-down']";

    public String getNameCategory() {
        return waitVisibilityOfElement(PRODUCT_NAME).getText();
    }

}
