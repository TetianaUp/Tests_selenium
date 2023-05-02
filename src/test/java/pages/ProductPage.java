package pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends Header {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final String PRODUCT_DETAILS = "//a[@href='#collapseDetails2']";

    public ProductPage clickProductDetails() {
        waitClickableElement(PRODUCT_DETAILS).click();

        return this;
    }

    public String getTextGromProductDetails() {
        String text = waitVisibilityOfElement("//div[@class='ecom-bullets ml-3 mt-0'][1]").getText();

        return text;
    }

}
