package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenSportGearPage;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;
import static pages.MenSportGearPage.SPORT_GEAR_PRICE;

public class MenSportsGearPriceFilteringTest extends TestInit {

    private String title = "Sports Gear";
    private String PRICE£100 = "//ul[@class='values content price']//span[contains(text(),'Over £100')][1]";

    @Test
    public void checkFilteringByPriceOver£100() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MenSportGearPage menSportGearPage = new MenSportGearPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToMenSportGearCategory();

        assertTrue(menSportGearPage.getTitleCategory().contains(title));

        menSportGearPage
                .filteringByPrice(PRICE£100);

        sleep(500);
        List<Double> prices = menSportGearPage.getProductPrices(SPORT_GEAR_PRICE);
        for (Double priceElement : prices) {
            assertTrue(priceElement >= 100, "Filterring doesn't work");
        }

    }
}
