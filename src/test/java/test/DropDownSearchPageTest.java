package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownSearchPage;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class DropDownSearchPageTest {
    DropDownSearchPage dropdownSearchPage = new DropDownSearchPage();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlDropDown"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    /*

    In real life we wouldn't waste precious seconds to mouse nav, sorry to make you do that.
    The next test is working with selectors but it would be far too easy to use native selects.
    My final test for you is to work with jquery selects.
        1. From this URL: https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html
        2. Under the country select Japan & assert the field value is Japan
        3. Under the multi select select Delaware & Vermont & assert the field values
        4. Under US Outlying Territories assert that Guam & United States Minor Outlying Islands are disabled
    */

    @Test
    public void selectJapanTest() {
        dropdownSearchPage.dropdownWithSearchBoxClick("Japan");
        Assert.assertTrue(dropdownSearchPage.isCountrySelected("Japan"));
    }

    @Test
    public void multiSelectDelewareAndVermont() {
        dropdownSearchPage.selectMultipleStates("Delaware");
        dropdownSearchPage.selectMultipleStates("Vermont");
        Assert.assertTrue(dropdownSearchPage.isStateSelected("Delaware"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }



}
