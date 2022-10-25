package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GarminHomePage extends BaseHelper {

    WebDriver driver;
    public GarminHomePage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "c0149")
    WebElement signInButton;

    private void navigateToPage(String url)
    {
        driver.get(url);
    }

    private void clickOnSignInBtn (){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", signInButton);
        wdWait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

    }

    public void openSignInPage(String url){
        navigateToPage(url);
        clickOnSignInBtn();
    }
}
