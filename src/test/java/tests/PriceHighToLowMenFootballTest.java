package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManFootballPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.ManFootballPage.PRODUCT_PRICE;

public class PriceHighToLowMenFootballTest extends TestInit {
    private String title = "Football Boots";

    @Test
    public void checkSortingByPriceHighToLow() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        ManFootballPage manFootballPage = new ManFootballPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToManCategory();

        assertTrue(manFootballPage.getTitleCategory().contains(title));

        manFootballPage
                .sortByPriceHighToLow();

        sleep(500);
        List<Double> prices = manFootballPage.getProductPrices(PRODUCT_PRICE);
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());

        assertEquals(prices, sortedPrices, "Products are not sorted by price from high to low");
    }
}
