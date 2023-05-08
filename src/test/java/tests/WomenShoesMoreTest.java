package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.womens.WomenShopByStyleShoesPage;

import static org.testng.AssertJUnit.assertTrue;
import static pages.HomePage.HOME_URL;

public class WomenShoesMoreTest extends TestInit {
    @Test
    public void checkNumbOfShoesCategories() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        WomenShopByStyleShoesPage womenShopByStyleShoesPage = new WomenShopByStyleShoesPage(driver);


        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectToWomenMoreCategory()
                .waitForLoaderToDisappear();

        assertTrue(womenShopByStyleShoesPage.getNumberOfShoesCategoriesInBackMenu()
                > 12);
    }

}
