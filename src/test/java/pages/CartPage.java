package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends Header{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public final String SIZE_IN_CART =
            "//p[contains(@class,'size-b5e9c61ffdf18cacf7cea39664')]//span[@class='attribute-value regular pl-1']";
    public final String PRODUCT_IN_CART = "//a[@href='/pd/550/BBW550BD-B-065.html']";

    public String nameOfProductInCart(){
        return waitVisibilityOfElement(PRODUCT_IN_CART).getText();
    }

}
