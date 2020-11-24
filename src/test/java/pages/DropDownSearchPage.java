package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class DropDownSearchPage {
    public void dropdownWithSearchBoxClick(String countryName) {
        Driver.getDriver().findElement(By.xpath("//option[contains(text(),'" + countryName + "')]")).click();
    }

    public boolean isCountrySelected(String countryName) {
        WebElement selectedCountry = Driver.getDriver().findElement(By.id("select2-country-container"));
        return selectedCountry.getAttribute("title").equals(countryName);
    }

    public void selectMultipleStates(String stateName) {
        List<WebElement> states = Driver.getDriver().findElements(By.xpath("//li[@class='select2-results__option']"));
        for (WebElement each : states) {
            if (each.getText().equals(stateName)) {
                each.click();
                break;
            }
        }
    }

    public boolean isStateSelected(String stateName) {
        List<WebElement> selectedStates = Driver.getDriver().findElements(By.xpath("//li[@class = 'select2-selection__choice']"));
        boolean isSelected = true;
        for (WebElement each : selectedStates) {
            if (each.getText().equals(stateName)) {
                isSelected = true;

            } else {
                isSelected = false;

            }
        }
        return isSelected;
    }

    public boolean isDisabled(String territory) {

        List<WebElement> territories = Driver.getDriver().findElements(By.cssSelector("[class='select2-results__option']"));
        boolean isEnabled = true;
        for (WebElement each : territories) {
            if (each.getText().equals(territory)) {
                if (each.isEnabled()) {
                    isEnabled = true;
                }
                else isEnabled = false;
            }
        }
        return isEnabled;
    }
}
