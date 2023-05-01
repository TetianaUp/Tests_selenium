package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.ActionUtils.moveToElement;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    public WebElement getManCategory() {
        return waitVisibilityOfElement("//a[@id='1000']");
    }

    public WebElement getManFootballCategory() {
        return waitVisibilityOfElement("//a[@id='110000']");
    }

    public ManFootballPage moveToManCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getManFootballCategory());
        getManFootballCategory().click();

        return new ManFootballPage(driver);
    }
}
