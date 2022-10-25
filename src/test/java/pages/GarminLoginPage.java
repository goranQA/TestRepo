package pages;

import helpers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class GarminLoginPage extends BaseHelper
{
    WebDriver driver;
    public GarminLoginPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement usernameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "gauth-widget")
    WebElement loginPopUpContainer;
    @FindBy (id = "gauth-widget-frame-gauth-widget")
    WebElement loginFrame;


    private void inputUsername (String user)
    {
        wdWait.until(ExpectedConditions.visibilityOf(loginPopUpContainer));
        wdWait.until(ExpectedConditions.visibilityOf(loginFrame));

        driver.switchTo().frame(loginFrame); // this line changes frames, so that we can use elements that are in loginFrame

        wdWait.until(ExpectedConditions.elementToBeClickable(usernameInputField));
        usernameInputField.sendKeys(user);
    }

    private void inputPassword (String password)
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(passwordInputField));
        passwordInputField.sendKeys(password);
    }

    public void inputCredentials(String user, String password)
    {
        inputUsername(user);
        inputPassword(password);
    }
}
