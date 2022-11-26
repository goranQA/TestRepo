package pages;

import helpers.BaseHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolovniAutomobiliSearchPage extends BaseHelper {
    WebDriver driver;

    public PolovniAutomobiliSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    WebElement searchField;

    private void navigateToHomepage() {
        driver.get("https://polovniautomobili.ba/");
    }

    private void inputSearch(String term) {
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchAutomobili(String term) {
        navigateToHomepage();
        inputSearch(term);


    }

}