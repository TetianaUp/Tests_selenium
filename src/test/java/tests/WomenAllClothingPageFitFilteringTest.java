package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.WomenAllClothingPage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class WomenAllClothingPageFitFilteringTest extends TestInit {
    @Test
    public void checkOversizedFiltering() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        WomenAllClothingPage allClothingPage = new WomenAllClothingPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToAllClothingPageCategory();

        allClothingPage
                .filteringByFit();
        sleep(2000);

        assertTrue(allClothingPage.findProductTitleContainsOVersized() > 0);
    }
}
