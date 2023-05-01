package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenTrainersPage;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.MenFootballPage.PRODUCT_PRICE;

public class MenTrainsFilteringByPriceTest extends TestInit {

    private String title = "Men’s Trainers";
    private String PRICE£51_£75 = "//div[@id='refinement-price']//span[contains(text(),'£51 - £75')][1]";

    @Test
    public void checkfilteringByPrice_£51_£75() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MenTrainersPage menTrainersPage = new MenTrainersPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToMenTrainersCategory();

        assertTrue(menTrainersPage.getTitleCategory().contains(title));

        menTrainersPage
                .filteringByPrice(PRICE£51_£75);

        sleep(500);
        List<Double> prices = menTrainersPage.getProductPrices(PRODUCT_PRICE);
        for (Double priceElement : prices) {
            assertTrue(priceElement >= 51 && priceElement <= 75, "Filterring doesn't work");
        }
    }
}
