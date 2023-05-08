package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.womens.WomenSportsBrasPage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class WomenSportsBrasFilteringBySizeTest extends TestInit {

    private final String SM0_SIZE = "//button[@data-href='/women/clothing/sports-bras/?prefn1=womensApparelSize&prefv1=SM0']";
    private boolean isSMOSize;
    private boolean isSMOSizeInAnotherColor;

    @Test
    public void checkSize_SMO_Available() throws InterruptedException {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        WomenSportsBrasPage womenSportsBras = new WomenSportsBrasPage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectToWomenSportsBraCategory();

        womenSportsBras
                .filteringBySize(SM0_SIZE);

        womenSportsBras
                .getProduct();

        isSMOSize = productPage.isSizeSMOAvailable();
        if (!isSMOSize) {
            productPage.getAnotherColorOfProduct();
            isSMOSizeInAnotherColor = productPage.isSizeSMOAvailable();
        }

        assertTrue(isSMOSize || isSMOSizeInAnotherColor, "This size isn't available");
    }

}
