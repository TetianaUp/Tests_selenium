package newBalance.tests;

import newBalance.TestInit;
import newBalance.pages.Category550Page;
import newBalance.pages.HomePage;
import org.testng.annotations.Test;

import static newBalance.pages.HomePage.HOME_URL;

public class CrossingFromManePageToAnotherCategoryPageTest extends TestInit {
    @Test
    public void checkCrossingTo550Category() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        Category550Page category550Page = new Category550Page(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp();

        homePage
                .find550CategoryInNewArrivals();

        category550Page.getNameCategory();
    }
}
