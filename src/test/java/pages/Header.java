package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.mens.*;
import pages.womens.*;

import static utils.ActionUtils.clickOnElement;
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

    public MenFootballPage selectToManCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getManFootballCategory());
        getManFootballCategory().click();

        return new MenFootballPage(driver);
    }

    public MenTrainersPage selectToMenTrainersCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrainersCategory());
        getMenTrainersCategory().click();

        return new MenTrainersPage(driver);
    }

    public MenTrousersAndTightsPage selectToMenTrousersAndTightsCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenTrousersAndTightsCategory());
        getMenTrousersAndTightsCategory().click();

        return new MenTrousersAndTightsPage(driver);
    }

    public MensBagsBackpacksPage selectToMenBagsBackpacksCategory() {
        moveToElement(driver, getManCategory());
        moveToElement(driver, getMenBagsBackpacksCategory());
        getMenBagsBackpacksCategory().click();

        return new MensBagsBackpacksPage(driver);
    }

    public MenSportGearPage selectToMenSportGearCategory() {
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


    public WebElement getWomenMoreShoesCategory() {
        return waitVisibilityOfElement("//a[@id='24240']");
    }

    public WebElement getWomenDressesCategory() {
        return waitVisibilityOfElement("//a[@id='251001']");
    }

    public WebElement getWomenSportsBrasCategory() {
        return waitVisibilityOfElement("//a[@id='259000']");
    }

    public RunningMidDistanceRunPage selectToMidDistanceRunCategory() {
        moveToElement(driver, getRunningCategory());
        moveToElement(driver, getMidDistanceRunCategory());
        getMidDistanceRunCategory().click();

        return new RunningMidDistanceRunPage(driver);
    }

    public WomenAllClothingPage selectToAllClothingPageCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenAllClothingCategory());
        getWomenAllClothingCategory().click();

        return new WomenAllClothingPage(driver);
    }

    public WomenSandalsPage selectToWomenSandalsCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenSandalsCategory());
        getWomenSandalsCategory().click();

        return new WomenSandalsPage(driver);
    }

    public WomenDressesPage selectWomenDressesCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenDressesCategory());
        getWomenDressesCategory().click();

        return new WomenDressesPage(driver);
    }

    public WebElement getCert() {
        return waitVisibilityOfElement("//div[@class='minicart-total']");
    }

    public WomenSportsBrasPage selectToWomenSportsBraCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenSportsBrasCategory());
        getWomenSportsBrasCategory().click();

        return new WomenSportsBrasPage(driver);
    }
    public WomenShopByStyleShoesPage selectToWomenMoreCategory() {
        moveToElement(driver, getWomenCategory());
        moveToElement(driver, getWomenMoreShoesCategory());
        getWomenMoreShoesCategory().click();

        return new WomenShopByStyleShoesPage(driver);
    }

    public CartPage clickCart(){
        clickOnElement(driver, waitVisibilityOfElement("//div[@class='minicart-total']"));

        return new CartPage(driver);
    }

    public WebElement getKidsCategory(){

        return waitVisibilityOfElement("//a[@id='3000']");
    }

    public WebElement getKidsOutletClothing(){

        return waitVisibilityOfElement("//a[@id='31002-3']");
    }

    public KidsOutletPage selectKidsOutletClothing(){
        moveToElement(driver, getKidsCategory());
        moveToElement(driver, getKidsOutletClothing());
        getKidsOutletClothing().click();

        return new KidsOutletPage(driver);
    }
}
