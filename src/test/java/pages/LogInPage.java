package pages;

import org.openqa.selenium.WebDriver;

public class LogInPage extends Header{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage enterLogInInfo(String email, String password){
        waitVisibilityOfElement("//input[@id='login-form-email']").sendKeys(email);
        waitVisibilityOfElement("//input[@id='login-form-password']").sendKeys(password);


        return this;
    }
    public LogInPage clickLogIn(){
        waitClickableElement("//button[contains(@class,'login-submit')]").click();
        return this;
    }
}
