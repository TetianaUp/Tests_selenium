package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MensBagsBackpacksPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.MensBagsBackpacksPage.PRODUCT_PRICE_b;

public class MenBagsBackpacksActivityFilterPriceSortTest extends TestInit {

    @Test
    public void checkMenBagsBackpacksActivityFilterPriceSortTest() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MensBagsBackpacksPage mensBagsBackpacksPage = new MensBagsBackpacksPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToMenBagsBackpacksCategory();

        mensBagsBackpacksPage
                .filteringByActivity();
        sleep(3000);

        assertTrue(mensBagsBackpacksPage.getNumberOfProductsInCategory() > 0);

        mensBagsBackpacksPage
                .sortByPriceLowToHigh();
        sleep(2000);

        List<Double> prices = mensBagsBackpacksPage.getProductPrices(PRODUCT_PRICE_b);
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Collections.sort(sortedPrices);
        //sortedPrices.sort(Collections.reverseOrder());

        assertEquals(prices, sortedPrices, "Products are not sorted by price from high to low");
    }
}
