package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLoginPage extends BaseHelper
{
    WebDriver driver;
    public HerokuAppLoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(tagName = "button")
    WebElement loginButton;

    private void navigateToLoginPage()
    {
        driver.get("https://the-internet.herokuapp.com/login");
    }
    private void enterUsername(String username)
    {
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password)
    {
        passwordField.sendKeys(password);
    }

    private void clickOnLoginButton()
    {
        loginButton.click();
    }

    public void login(String username, String password)
    {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }

}
