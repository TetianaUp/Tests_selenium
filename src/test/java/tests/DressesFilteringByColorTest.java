package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.WomenDressesPage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class DressesFilteringByColorTest extends TestInit {
    private final String DRESSES_COLOR = "//span[@id='color-swatch-circle-black-assistive-0']";

    @Test
    public void checkFilteringByBlueColor() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        WomenDressesPage womenDressesPage = new WomenDressesPage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToWomenDressesCategory();

        womenDressesPage
                .filteringByColor(DRESSES_COLOR);

        womenDressesPage
                .getProduct();


        assertTrue(productPage.getColorFromProduct().contains("black"));
    }
}
