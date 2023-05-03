package tests;

import org.testng.annotations.Test;
import pages.AllClothingPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class AllClothingPageFitFilteringTest extends TestInit {
    @Test
    public void checkOversizedFiltering() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        AllClothingPage allClothingPage = new AllClothingPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .moveToAllClothingPageCategory();

        allClothingPage
                .filteringByFit();
        sleep(5000);

        assertTrue(allClothingPage.findProductTitleContainsOVersized() > 0);
    }
}
