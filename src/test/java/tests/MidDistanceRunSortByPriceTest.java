package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.RunningMidDistanceRunPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.HOME_URL;
import static pages.RunningMidDistanceRunPage.MDRUN_PRODUCT_PRICE;

public class MidDistanceRunSortByPriceTest extends TestInit{

    @Test
    public void checkPriceFilteringLowHigh(){
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        RunningMidDistanceRunPage runningMidDistanceRunPage = new RunningMidDistanceRunPage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .selectToMidDistanceRunCategory();

        runningMidDistanceRunPage.sortByPriceLowToHigh();
        runningMidDistanceRunPage.waitForLoaderToDisappear();

        List<Double> prices = runningMidDistanceRunPage.getProductPrices(MDRUN_PRODUCT_PRICE);
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        assertEquals(prices, sortedPrices, "Products are not sorted by price from low to high");
    }
}
