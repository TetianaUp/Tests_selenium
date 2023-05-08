package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.HOME_URL;

public class CrossingFromManePageToAnotherCategoryPageTest extends TestInit {
    @Test(description = "назови меня нормальн ов соотвецтвии с тем что делает твой тест")
    public void checkMyNameToRename() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp();

        var categoryName = homePage
                .findRandomCategoryInNewArrivals();
        //TODO: нужно починить логику, изза того что пропадает NewArrival переделать логику на BestSellers
        assertEquals(productPage.getNameCategory(), categoryName);
    }
}
