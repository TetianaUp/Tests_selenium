package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.mens.MensBagsBackpacksPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.mens.MensBagsBackpacksPage.PRODUCT_PRICE_b;

public class MenBagsBackpacksActivityFilterPriceSortTest extends TestInit {

    @Test
    public void checkMenBagsBackpacksActivityFilterPriceSortTest() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MensBagsBackpacksPage mensBagsBackpacksPage = new MensBagsBackpacksPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectToMenBagsBackpacksCategory();

        mensBagsBackpacksPage.filteringByActivity();
        mensBagsBackpacksPage.waitForLoaderToDisappear();

        assertTrue(mensBagsBackpacksPage.getNumberOfProductsInCategory() > 0);

        mensBagsBackpacksPage.sortByPriceLowToHigh();
        mensBagsBackpacksPage.waitForLoaderToDisappear();

        List<Double> prices = mensBagsBackpacksPage.getProductPrices(PRODUCT_PRICE_b);
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        assertEquals(prices, sortedPrices, "Products are not sorted by price from low to high");
    }
}
