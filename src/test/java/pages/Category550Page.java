package pages;

import org.openqa.selenium.WebDriver;

import static utils.ActionUtils.clickOnElement;

public class Category550Page extends Header {

    public Category550Page(WebDriver driver) {
        super(driver);
    }

    public final String PRODUCT_NAME = "//h1[@class='product-name hidden-sm-down']";
    public final String FIRST_PRODUCT = "//div[@data-product-position='1']";


    public String getNameCategory() {
        return waitVisibilityOfElement(PRODUCT_NAME).getText();
    }

    public ProductPage getFirstProduct() {
        clickOnElement(driver, waitClickableElement(FIRST_PRODUCT));

        return new ProductPage(driver);
    }

}
