package demoQA.checkBox;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox extends AbstractTestInit {
    public CheckBox() {
    }

    @Test
    public void checkCheckBox() {
            driver.get("https://demoqa.com/links");
            driver.findElement(By.xpath("//span[text()='Check Box']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Toggle']")).click();
            driver.findElement(By.xpath("//label[@for='tree-node-desktop']/preceding-sibling::button")).click();
            driver.findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button")).click();
            driver.findElement(By.xpath("//label[@for='tree-node-workspace']/preceding-sibling::button")).click();
            driver.findElement(By.xpath("//label[@for='tree-node-office']/preceding-sibling::button")).click();
            scrollToElement(driver, driver.findElement(By.xpath("//label[@for='tree-node-office']/preceding-sibling::button")));
            driver.findElement(By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button")).click();
            driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
            WebElement result = driver.findElement(By.xpath("//div[@id='result']"));
            Assert.assertEquals(result.getText(), "You have selected :\nhome\ndesktop\nnotes\ncommands\ndocuments\nworkspace\nreact\nangular\nveu\noffice\npublic\nprivate\nclassified\ngeneral\ndownloads\nwordFile\nexcelFile");

            driver.findElement(By.xpath("//label[@for='tree-node-notes']")).click();

            Assert.assertEquals(result.getText(), "You have selected :\ncommands\ndocuments\nworkspace\nreact\nangular\nveu\noffice\npublic\nprivate\nclassified\ngeneral\ndownloads\nwordFile\nexcelFile");

            driver.findElement(By.xpath("//label[@for='tree-node-workspace']")).click();

            Assert.assertEquals(result.getText(), "You have selected :\ncommands\noffice\npublic\nprivate\nclassified\ngeneral\ndownloads\nwordFile\nexcelFile");

    }
}