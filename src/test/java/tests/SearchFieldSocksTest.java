package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SocksPage;

import static org.testng.AssertJUnit.assertTrue;
import static pages.HomePage.HOME_URL;

public class SearchFieldSocksTest extends TestInit {

    @Test
    public void checkSearchFieldWithSocks() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        SocksPage socksPage = new SocksPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .searchProduct("socks");

        assertTrue(socksPage.getProductNames() >= 1);
    }
}
