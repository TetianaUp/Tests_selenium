package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.KidsOutletPage;

import static org.testng.AssertJUnit.assertTrue;
import static pages.HomePage.HOME_URL;

public class KidsOutletClothingFilteringTest extends TestInit {

    @Test
    public void checkPantsFilter() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        KidsOutletPage kidsOutletPage = new KidsOutletPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectKidsOutletClothing();

        kidsOutletPage
                .chosePans()
                .waitForLoaderToDisappear();

        assertTrue(kidsOutletPage.getProductNames() >= 2);
    }
}
