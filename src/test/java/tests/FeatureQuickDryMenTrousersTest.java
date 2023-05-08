package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.mens.MenTrousersAndTightsPage;
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
                .selectToMenTrousersAndTightsCategory();
        homePage.waitForLoaderToDisappear();

        assertTrue(menTrousersAndTightsPage.getTitleCategory().contains(title));

        menTrousersAndTightsPage
                .filteringByFeature();
        menTrousersAndTightsPage.waitForLoaderToDisappear();

        menTrousersAndTightsPage.getFirstProduct();

        productPage
                .clickProductDetails();

        assertTrue(productPage.getTextFromProductDetails().contains("fast-drying"));
    }
}
