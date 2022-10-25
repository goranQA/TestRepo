package pages;

import helpers.BaseHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class AnanasHomePage extends BaseHelper {

    WebDriver driver;
    public AnanasHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (className="aa-Input")
    WebElement insertTerm;
    @FindBy (className= "sc-1fne4lr-1")
    WebElement magnifierButton;
    
    private void navigateToHomePage(String url)
    {
        driver.get(url);
    }

    private void acceptCookies() throws InterruptedException {
        //Thread.sleep(1000);
        List<WebElement> cookiesAcceptButton = driver.findElements(By.className("sc-1rhklln-0"));
        if (cookiesAcceptButton.size() != 0) {
            wdWait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton.get(0)));
            cookiesAcceptButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookiesAcceptButton.get(0)));
        }
        System.out.println("Accept cookies list size:"+cookiesAcceptButton.size());
    }
    
    private void insertSearchTerm(String searchTerm)
    {
        insertTerm.sendKeys(searchTerm);
    }
    
    private void clickOnMagnifierButton()
    {
        magnifierButton.click();
    }
    
    public void searchInsertedTerm(String url, String searchTerm) throws InterruptedException {
        navigateToHomePage(url);
        acceptCookies();
        insertSearchTerm(searchTerm);
        clickOnMagnifierButton();
    }
}
