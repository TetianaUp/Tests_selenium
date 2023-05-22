package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.HOME_URL;

public class LogInTest extends TestInit{
    public String email = "stanko.tanya.k@gmail.com";
    public String password = "LB%F*6y3Yk5k%cX";
    public String name = "Tania";
    public String lastName = "Stanko";


    @Test
    public void checkLogIn() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);


        homePage
                .acceptAllCookies()
                .choseLogIn();


        logInPage
                .enterLogInInfo(email,password)
                .clickLogIn();


        assertTrue(myAccountPage.getName().contains(name));
        assertTrue(myAccountPage.getLastName().contains(lastName));


    }

}
