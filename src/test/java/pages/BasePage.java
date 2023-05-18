package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    final static int BASE_WAIT = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofSeconds(BASE_WAIT));
    }

    protected WebElement waitClickableElement(String locator) {
        return wait.until(elementToBeClickable(xpath(locator)));
    }

    protected WebElement waitVisibilityOfElement(String locator) {
        return wait.until(visibilityOfElementLocated(xpath(locator)));
    }

    protected List<WebElement> waitPresenceOfAllElements(String locator) {
        return wait.until(presenceOfAllElementsLocatedBy(xpath(locator)));
    }

    protected WebElement waitPresenceOfElement(String locator) {
        return wait.until(presenceOfElementLocated(xpath(locator)));
    }

    public WebElement getSortDropdownMenu() {
        return driver.findElement(name("sort-order"));
    }

    public String getTitleCategory() {
        return waitVisibilityOfElement("//h1[contains(@class, 'js-griddisplay-name page-category')]")
                .getText();
    }

    public Double extractPriceFromElement(WebElement element) {
        String priceText = element.getText().replace("£", "");
        return Double.parseDouble(priceText);
    }

    public void waitForLoaderToDisappear() {
        wait.until(invisibilityOfElementLocated(xpath("//div[@class='veil']")));
    }

    public void goToNextTab(int tabNumber) {
        waitUntilNumberOfTabToBe(tabNumber);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber - 1));
    }

    public void waitUntilNumberOfTabToBe(int tabNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabNumber));
    }
}
