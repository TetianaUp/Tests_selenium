package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.AssertJUnit.assertTrue;
import static pages.HomePage.*;

public class CrossingToSocialNetworksTest extends TestInit {
    private final String INSTAGRAM_LINK = "https://www.instagram.com/newbalance/";
    private final String FACEBOOK_LINK = "https://www.facebook.com/Newbalance";
    private final String TWITTER_LINK = "https://twitter.com/NewBalance";
    private final String YOUTUBE_LINK = "https://www.youtube.com/user/newbalance";
    private final String PINTEREST_LINK = "https://www.pinterest.com/newbalance/";

    @Test
    public void checkSocialNetworksLinks() {
        openUrl(HOME_URL);
        HomePage homePage = new HomePage(driver);

        homePage
                .acceptAllCookies()
                .acceptPopUp()
                .scrollToFooter();

        homePage.clickAndSwitchToFollowingPage(INSTAGRAM);
        String instaPage = getUrl();

        assertTrue(instaPage == INSTAGRAM_LINK);

        homePage
                .closeAndSwitchToHomePage()
                .clickAndSwitchToFollowingPage(FACEBOOK);
        String facebookPage = getUrl();

        assertTrue(facebookPage == FACEBOOK_LINK);

        homePage
                .closeAndSwitchToHomePage()
                .clickAndSwitchToFollowingPage(TWITTER);
        String twitterPage = getUrl();

        assertTrue(twitterPage == TWITTER_LINK);

        homePage
                .closeAndSwitchToHomePage()
                .clickAndSwitchToFollowingPage(YOUTUBE);
        String youtubePage = getUrl();

        assertTrue(youtubePage == YOUTUBE_LINK);

        homePage
                .closeAndSwitchToHomePage()
                .clickAndSwitchToFollowingPage(PINTEREST);
        String pinterestPage = getUrl();

        assertTrue(pinterestPage == PINTEREST_LINK);
    }
}
