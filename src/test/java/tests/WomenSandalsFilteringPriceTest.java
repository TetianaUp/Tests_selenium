package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.WomenSandalsPage;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class WomenSandalsFilteringPriceTest extends TestInit {

    private final String PRICE_£25_£50 = "//ul[@class='values content price']//span[contains(text(),'£25 - £50')][1]";
    private final String SANDAL_PRICE = "//span[@class='sales font-body-large ']";

    @Test
    public void checkFilteringByPriceOver£25_£50() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        WomenSandalsPage womenSandalsPage = new WomenSandalsPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToWomenSandalsCategory();

        womenSandalsPage
                .filteringByPrice(PRICE_£25_£50);
        sleep(500);

        List<Double> prices = womenSandalsPage.getProductPrices(SANDAL_PRICE);
        for (Double priceElement : prices) {
            assertTrue(priceElement >= 25 && priceElement <= 50, "Filterring doesn't work");
        }
    }


}
