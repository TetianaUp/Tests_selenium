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

    public WebElement getMenTrainersCategory() {
        return waitVisibilityOfElement("//a[@id='106000']");
    }

    public WebElement getMenTrousersAndTightsCategory() {
        return waitVisibilityOfElement("//a[@id='158000']");
    }

    public WebElement getMenBagsBackpacksCategory() {
        return waitVisibilityOfElement("//a[@id='19800']");
    }

    public WebElement getMenSportsGearCategory() {
        return waitVisibilityOfElement("//a[@id='29005-1']");
    }

    public MenFootballPage moveToManCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getManFootballCategory());
        getManFootballCategory().click();

        return new MenFootballPage(driver);
    }

    public MenTrainersPage moveToMenTrainersCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrainersCategory());
        getMenTrainersCategory().click();

        return new MenTrainersPage(driver);
    }

    public MenTrousersAndTightsPage moveToMenTrousersAndTightsCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrousersAndTightsCategory());
        getMenTrousersAndTightsCategory().click();

        return new MenTrousersAndTightsPage(driver);
    }

    public MensBagsBackpacksPage moveToMenBagsBackpacksCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenBagsBackpacksCategory());
        getMenBagsBackpacksCategory().click();

        return new MensBagsBackpacksPage(driver);
    }

    public MenSportGearPage moveToMenSportGearCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenSportsGearCategory());
        getMenSportsGearCategory().click();

        return new MenSportGearPage(driver);
    }

    public WebElement getRunningCategory() {
        return waitVisibilityOfElement("//a[@id='6000']");
    }

    public WebElement getMidDistanceRunCategory() {
        return waitVisibilityOfElement("//a[@id='70602']");
    }

    public WebElement getWomenCategory() {
        return waitVisibilityOfElement("//a[@id='2000']");
    }

    public WebElement getWomenAllClothingCategory() {
        return waitVisibilityOfElement("//a[@id='25110']");
    }

    public WebElement getWomenSandalsCategory() {
        return waitVisibilityOfElement("//a[@id='50421-2']");
    }


    public WebElement getWomenMoreCategory() {
        return waitVisibilityOfElement("//a[@id='24240']");
    }

    public WebElement getWomenDressesCategory() {
        return waitVisibilityOfElement("//a[@id='251001']");
    }

    public WebElement getWomenSportsBrasCategory() {
        return waitVisibilityOfElement("//a[@id='259000']");
    }

    public RunningMidDistanceRunPage moveToMidDistanceRunCategory() {
        moveToElement(driver, getRunningCategory());
        moveToElement(driver, getMidDistanceRunCategory());
        getMidDistanceRunCategory().click();

        return new RunningMidDistanceRunPage(driver);
    }

    public WomenAllClothingPage moveToAllClothingPageCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenAllClothingCategory());
        getWomenAllClothingCategory().click();

        return new WomenAllClothingPage(driver);
    }

    public WomenSandalsPage moveToWomenSandalsCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenSandalsCategory());
        getWomenSandalsCategory().click();

        return new WomenSandalsPage(driver);
    }

    public WomenDressesPage moveToWomenDressesCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenDressesCategory());
        getWomenDressesCategory().click();

        return new WomenDressesPage(driver);
    }

    public WebElement getCert() {
        return waitVisibilityOfElement("//div[@class='minicart-total']");
    }

    public WomenSportsBrasPage moveToWomenSportsBraCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenSportsBrasCategory());
        getWomenSportsBrasCategory().click();

        return new WomenSportsBrasPage(driver);
    }

}
