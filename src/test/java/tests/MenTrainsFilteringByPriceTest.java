package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.mens.MenTrainersPage;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.mens.MenFootballPage.PRODUCT_PRICE;

public class MenTrainsFilteringByPriceTest extends TestInit {

    private String title = "Men’s Trainers";
    private String PRICE£51_£75 = "//div[@id='refinement-price']//span[contains(text(),'£51 - £75')][1]";

    @Test
    public void checkFilteringByPrice_£51_£75() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MenTrainersPage menTrainersPage = new MenTrainersPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectToMenTrainersCategory();

        assertTrue(menTrainersPage.getTitleCategory().contains(title));

        menTrainersPage.selectFilteringByPrice(PRICE£51_£75);
        menTrainersPage.waitForLoaderToDisappear();

        SoftAssert soft = new SoftAssert();
        int minPrice = 51;
        int maxPrice = 75;
        List<Double> prices = menTrainersPage.getProductPrices(PRODUCT_PRICE);
        for (Double price : prices) {
            soft.assertTrue(price >= minPrice, format("Filtering more or equal then %s", minPrice));
            soft.assertTrue(price <= maxPrice, format("Filtering less or equal then %s", maxPrice));
        }
        soft.assertAll();
    }
}
