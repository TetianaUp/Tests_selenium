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

    public WebElement getMenTrainersCategory(){
        return waitVisibilityOfElement("//a[@id='106000']");
    }

    public WebElement getMenTrousersAndTightsCategory(){
        return waitVisibilityOfElement("//a[@id='158000']");
    }

    public MenFootballPage moveToManCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getManFootballCategory());
        getManFootballCategory().click();

        return new MenFootballPage(driver);
    }

    public MenTrainersPage moveToMenTrainersCategory(){
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrainersCategory());
        getMenTrainersCategory().click();

        return new MenTrainersPage(driver);
    }

    public MenTrainersPage moveToMenTrousersAndTightsCategory(){
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrousersAndTightsCategory());
        getMenTrousersAndTightsCategory().click();

        return new MenTrainersPage(driver);
    }
}
