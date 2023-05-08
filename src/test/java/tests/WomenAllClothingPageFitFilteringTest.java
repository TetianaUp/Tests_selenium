package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.womens.WomenAllClothingPage;

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
                .selectToAllClothingPageCategory();

        allClothingPage.filteringByFit();
        allClothingPage.waitForLoaderToDisappear();

        assertTrue(allClothingPage.findProductTitleContainsOVersized() > 0);
    }
}
