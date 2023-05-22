package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Header {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public final static String myAccountUrl = "https://www.newbalance.co.uk/account-login?registration=false";


    public final static String WELCOME_BACK = "//div[@class=' row font-header-2 col-8 col-lg-6 mb-4 mb-lg-6']";
    public final static String LAST_NAME = "//dl[2]//dd[@class='fit-links font-body']";


    public String getName(){
        return waitVisibilityOfElement(WELCOME_BACK).getText();
    }


    public String getLastName(){
        return waitVisibilityOfElement(LAST_NAME).getText();
    }


}
