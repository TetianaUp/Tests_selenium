package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Header {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage enterYourPersonalDetails(String firstName, String secondName,
                                                     String email, String password) {
        waitVisibilityOfElement("//input[@id='registration-form-fname']").sendKeys(firstName);
        waitVisibilityOfElement("//input[@id='registration-form-lname']").sendKeys(secondName);
        waitVisibilityOfElement("//input[@id='registration-form-email']").sendKeys(email);
        waitVisibilityOfElement("//input[@id='registration-form-password']").sendKeys(password);
        return this;
    }


    public RegistrationPage agreeTermsOfUse() {
        driver.findElement(By.id("terms-conditions")).click();
        return this;
    }


    public RegistrationPage createAccount() {
        waitClickableElement("//button[@class='nb-button button-primary submit-button col-12  mb-0 create-account-nb ']").click();
        return this;
    }

}
