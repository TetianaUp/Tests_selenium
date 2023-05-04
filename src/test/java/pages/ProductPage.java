package pages;

import org.openqa.selenium.WebDriver;

import static utils.ActionUtils.clickOnElement;

public class ProductPage extends Header {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public final String PRODUCT_DETAILS = "//a[@href='#collapseDetails2']";
    public final String PRODUCT_SIZE_4_5 = "//button[@aria-label='Select UK Size 4.5']";
    public final String ADD_TO_CART_BTN = "//button[@class=' add-to-cart nb-button button-primary button-full-width']";

    public ProductPage clickProductDetails() {
        waitClickableElement(PRODUCT_DETAILS).click();

        return this;
    }

    public String getTextFromProductDetails() {
        String text = waitVisibilityOfElement("//div[@class='ecom-bullets ml-3 mt-0'][1]").getText();

        return text;
    }

    public String getColorFromProduct() {
        String color = waitVisibilityOfElement(
                "//div[@class='col-12 color-display-name order-0 d-none d-lg-block mt-2 px-0']")
                .getText();

        return color;
    }

    public ProductPage choseSizeOf550Shoes() {
        clickOnElement(driver, waitClickableElement(PRODUCT_SIZE_4_5));

        return this;
    }

    public ProductPage clickAddToCart() {
        if (waitClickableElement(ADD_TO_CART_BTN).isEnabled() == true) {
            System.out.println("The cart is empty");

        } else
            waitClickableElement(ADD_TO_CART_BTN).click();

        return this;
    }


    public boolean isSizeSMOAvailable() {
        boolean flag = waitClickableElement("//button[@data-attrid='size']//span[@id='SM0']").isEnabled();

        return flag;
    }

    public ProductPage getAnotherColorOfProduct() {
        clickOnElement(driver, waitVisibilityOfElement("//button[@aria-label='Select Style NEON DRAGONFLY']"));

        return this;
    }

}
