package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class CheckBoxPageTest {
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlCheckBox"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
    }

    /*
    From this URL: https://www.seleniumeasy.com/test/basic-first-form-demo.html
                1. Set the value of id user-message to "QA assessment trial #1"
                2. Click 'Show Message'
                3. Assert that "Your Message" matches "QA assessment trial #1"
*/
    @Test
    public void shoudHaveCorrectMessage() {
        WebElement txtfield = Driver.getDriver().findElement(By.id("user-message"));
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Show Message')]"));
        WebElement yourMessage = Driver.getDriver().findElement(By.xpath("//span[@id='display']"));
        txtfield.sendKeys("QA assessment trial #1");
        button.click();
        Assert.assertEquals(yourMessage.getText(), "QA assessment trial #1");
    }

    //    /*
//    From this URL: https://www.seleniumeasy.com/test/basic-first-form-demo.html.
//     Your next test should:
//        1. Interact with the menu on the left of the page and click "Input Forms"
//        2. On the sub-menu, click "Checkbox Demo"
//        3. Under "Multiple Checkbox Demo" there are "product requirements" for check/uncheck all,
//           come up with a test assertion to test this functionality.
//*/
    @Test
    public void checkboxTest() {
        checkBoxPage.selectFromAllExamplesDropdown("Input Forms");
        checkBoxPage.selectFromSubMenuDropdown("Checkbox Demo");
        Assert.assertEquals(checkBoxPage.selectSingleCheckListAndGetText(), "Success - Check box is checked");
    }

    @Test
    public void multiCheckBoxTest() {
        checkBoxPage.selectFromAllExamplesDropdown("Input Forms");
        checkBoxPage.selectFromSubMenuDropdown("Checkbox Demo");
        checkBoxPage.clickOnCheckAllButton();
        checkBoxPage.selectFromMultipleCheckList("Option 1");
        WebElement button = Driver.getDriver().findElement(By.xpath("//input[@id='check1']"));
        Assert.assertTrue(button.getAttribute("value").equals("Check All"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }
}
