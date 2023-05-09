package pages.kids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

public class KidsOutletPage extends Header {
    public KidsOutletPage(WebDriver driver) {
        super(driver);
    }

    public final String PRODUCT_TYPE = "//button[@aria-controls='refinement-product-type']";
    public final String PANTS = "//span[contains(text(),'Pants')]";

    public KidsOutletPage chosePans() {
        waitPresenceOfElement(PRODUCT_TYPE).click();
        waitPresenceOfElement(PANTS).click();

        return this;
    }

    public int getProductNames() {
        int count = 0;
        List<String> names = new ArrayList<>();
        List<WebElement> productNameElements = waitPresenceOfAllElements("//a[@class='link font-weight-bold pname text-underline no-underline-lg']");
        for (WebElement element : productNameElements) {
            String nameText = element.getText();
            names.add(nameText);
        }
        for (String element : names) {
            if (element.contains("Legging")) {
                ++count;
            }
        }

        return count;
    }
}
