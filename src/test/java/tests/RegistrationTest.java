package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.HOME_URL;

public class RegistrationTest extends TestInit {
    public String firstName = "Kara";
    public String lastName = "Stay";
    public String email = "karas_3478@ukr.net";
    public String password = "Pj5hdwB0GHMu";
    public String urlAfterRegistration = "https://www.newbalance.co.uk/account-login?registration=submitted";


    @Test
    public void checkRegistration() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);


        homePage
                .acceptAllCookies()
                .clickJoinToCreateAccount();


        registrationPage
                .enterYourPersonalDetails(firstName, lastName, email, password)
                .agreeTermsOfUse()
                .createAccount();


        String curentUrlAfterRegistration = getUrl();

        assertEquals(curentUrlAfterRegistration, urlAfterRegistration,
                "Актуальний URL Log in не співпадає з очікуваним");
    }
}
