package demoQA.webTable;

import demoQA.AbstractTestInit;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTable extends AbstractTestInit {
    public WebTable() {
    }

    @Test
    public void checkWebTable() throws InterruptedException {
            this.driver.get("https://demoqa.com/links");
            this.driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
            String actualURL = this.driver.getCurrentUrl();
            Assert.assertEquals(actualURL, "https://demoqa.com/webtables", "URL isn't correct");
            this.driver.findElement(By.xpath("//input[@placeholder='Type to search']")).sendKeys(new CharSequence[]{"Vega"});
            Assert.assertTrue(this.getInformation("Vega"));
            this.driver.findElement(By.xpath("//span[@class='mr-2']")).click();
            Thread.sleep(2000L);
            String headerRegistrationForm = this.driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
            Assert.assertEquals(headerRegistrationForm, "Registration Form");
            this.driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
            this.driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(new CharSequence[]{"Simona"});
            this.driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
            this.driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(new CharSequence[]{"Venturo"});
            this.driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).clear();
            this.driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys(new CharSequence[]{"simona@example.com"});
            this.driver.findElement(By.xpath("//input[@placeholder='Age']")).clear();
            this.driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys(new CharSequence[]{"105"});
            this.driver.findElement(By.xpath("//input[@placeholder='Department']")).clear();
            this.driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys(new CharSequence[]{"cleaner"});
            this.driver.findElement(By.xpath("//button[@id='submit']")).click();
            this.driver.findElement(By.xpath("//input[@placeholder='Type to search']")).clear();

    }

    public boolean getInformation(String parameter) {
        List<WebElement> tableRows = this.driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        boolean flag = true;
        Iterator var4 = tableRows.iterator();

        while(var4.hasNext()) {
            WebElement element = (WebElement)var4.next();
            if (!element.getText().contains(parameter)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
