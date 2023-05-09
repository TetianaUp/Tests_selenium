package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SocksPage extends Header {
    public SocksPage(WebDriver driver) {
        super(driver);
    }

    public int getProductNames() {
        int count = 0;
        List<WebElement> productNameElements = waitPresenceOfAllElements("//a[@class='link font-weight-bold pname text-underline no-underline-lg']");
        for (WebElement element : productNameElements) {
            String nameText = element.getText();
            if (nameText.contains("Sock")) {
                count++;
            }
        }

        return count;
    }
}
