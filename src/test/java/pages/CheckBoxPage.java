package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class CheckBoxPage {
    public void selectFromAllExamplesDropdown(String value) {
        Driver.getDriver().findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'" + value + "')]")).click();
    }

    public void selectFromSubMenuDropdown(String value) {
        Driver.getDriver().findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'" + value + "')]")).click();
    }

    public String selectSingleCheckListAndGetText() {
        WebElement singleCheckbox = Driver.getDriver().findElement(By.id("isAgeSelected"));
        WebElement message = Driver.getDriver().findElement(By.id("txtAge"));
        if (!singleCheckbox.isSelected()) {
            singleCheckbox.click();
        }
        return message.getText();

    }

    public void selectFromMultipleCheckList(String value) {
        Driver.getDriver().findElement(By.xpath("//label[text()='" + value + "']")).click();
    }


    public void clickOnCheckAllButton(){
        WebElement checkAllButton =   Driver.getDriver().findElement(By.xpath("//input[@id='check1']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkAllButton);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", checkAllButton);
    }


}