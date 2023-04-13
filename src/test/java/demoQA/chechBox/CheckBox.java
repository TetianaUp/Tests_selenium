package demoQA.chechBox;

import demoQA.AbstractTestInit;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox extends AbstractTestInit {

    @Test()
    @SneakyThrows
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
//        List<WebElement> list = new ArrayList<>();
//        List<WebElement> selectedCheckBoxesList = driver.findElements(By.xpath("//div[@id='result']/span[@class='text-success']"));
//        selectedCheckBoxesList.stream().anyMatch(list.);

        Assert.assertEquals(result.getText(), "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");

        driver.findElement(By.xpath("//label[@for='tree-node-notes']")).click();
        Assert.assertEquals(result.getText(), "You have selected :\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");

        driver.findElement(By.xpath("//label[@for='tree-node-workspace']")).click();
        Assert.assertEquals(result.getText(), "You have selected :\n" +
                "commands\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
    }
}
