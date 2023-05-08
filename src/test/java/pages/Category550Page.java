package pages;

import org.openqa.selenium.WebDriver;

import static utils.ActionUtils.clickOnElement;

public class Category550Page extends Header {

    public Category550Page(WebDriver driver) {
        super(driver);
    }

    public final String FIRST_PRODUCT = "//div[@data-product-position='1']";

    public ProductPage getFirstProduct() {
        clickOnElement(driver, waitClickableElement(FIRST_PRODUCT));

        return new ProductPage(driver);
    }

}
