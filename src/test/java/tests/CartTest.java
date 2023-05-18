package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.Category550Page;
import pages.HomePage;
import pages.ProductPage;

import static org.testng.AssertJUnit.assertTrue;
import static pages.HomePage.HOME_URL;

public class CartTest extends TestInit{
//    @Test
//    public void checkAddProductInCart(){
//        openUrl(HOME_URL);
//        HomePage homePage = new HomePage(driver);
//        Category550Page category550Page = new Category550Page(driver);
//        ProductPage productPage = new ProductPage(driver);
//        CartPage cartPage = new CartPage(driver);
//
//        homePage
//                .acceptAllCookies()
//                .acceptPopUp();
//        homePage
//                .get550CategoryInBestSellers();
//
//        category550Page.getFirstProduct();
//
//        productPage
//                .choseSizeOf550Shoes()
//                .clickAddToCart()
//                .clickCart();
//
//        assertTrue(cartPage.nameOfProductInCart().contains("550"));
//    }
}
