package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolovniAutomobiliLoginHomePage extends BaseHelper {
    WebDriver driver;

    public PolovniAutomobiliLoginHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='is-link button']")
    WebElement prijava;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='button is-primary button']")
    WebElement prijavise;

    private void navigateToHomepage() {
        driver.get("https://polovniautomobili.ba/");
    }

    private void clickOnPrijava() {
        prijava.click();
    }

    private void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    private void inputPass(String password) {
        passwordField.sendKeys(password);
    }

    private void clickOnPrijavise() {
        prijavise.click();

    }

    public void loginAutomobili(String email, String password) {
        navigateToHomepage();
        clickOnPrijava();
        inputEmail(email);
        inputPass(password);
        clickOnPrijavise();

    }

}
