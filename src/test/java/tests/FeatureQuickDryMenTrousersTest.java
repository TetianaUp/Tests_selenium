package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenTrousersAndTightsPage;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class FeatureQuickDryMenTrousersTest extends TestInit {

    private String title = "Men’s Trousers & Tights";

    @Test
    public void checkFeatureQuickDryInMenTrousersCategory() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        MenTrousersAndTightsPage menTrousersAndTightsPage = new MenTrousersAndTightsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToMenTrousersAndTightsCategory();

        assertTrue(menTrousersAndTightsPage.getTitleCategory().contains(title));

        menTrousersAndTightsPage
                .filteringByFeature();
        sleep(5000);
        menTrousersAndTightsPage
                .getFirstProduct();

        productPage
                .clickProductDetails();

        assertTrue(productPage.getTextGromProductDetails().contains("fast-drying"));


    }
}
