package newBalance.tests;

import newBalance.TestInit;
import newBalance.pages.HomePage;
import newBalance.pages.ManFootballPage;
import org.testng.annotations.Test;

import static newBalance.pages.HomePage.HOME_URL;

public class PriceHighToLowMenFootballTest extends TestInit {
//    public String title = "Football Boots";

    @Test
    public void checkSortingByPriceHighToLow() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp();

        ManFootballPage manFootballPage = new ManFootballPage(driver);
        manFootballPage
                .moveToMenFootballCategory();

//        assertTrue(TITLE_CATEGORY.contains(title));

//        ManFootballPage menFootballPage = new ManFootballPage(driver);
//        menFootballPage
//                .sortByPriceHighToLow();
//
//        List<Double> prices = menFootballPage.getProductPrices(PRODUCT_PRICE);
//        List<Double> sortedPrices = new ArrayList<>(prices);
//        sortedPrices.sort(Collections.reverseOrder());
//
//        assertEquals(prices, sortedPrices, "Products are not sorted by price from high to low");
    }
}
