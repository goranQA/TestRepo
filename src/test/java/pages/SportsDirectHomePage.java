package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SportsDirectHomePage extends BaseHelper
{
    WebDriver driver;
    public SportsDirectHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="dvSearch")
    WebElement searchComponent;


    private void navigateToHomepage()
    {
        driver.get("https://www.sportsdirect.com/");
    }

    private void acceptCookiesIfPresent()
    {
        List<WebElement> acceptCookiesButton = driver.findElements(By.id("onetrust-accept-btn-handler"));
        System.out.println("Accept Cookies button preset?" + acceptCookiesButton.size());
        if (acceptCookiesButton.size() != 0) {
            wdWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton.get(0)));
            acceptCookiesButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(acceptCookiesButton.get(0)));
        }
    }

    private void closeCountrySelectionModalIfPresent()
    {
        List<WebElement> closeModalButton = driver.findElements(By.className("close"));
        System.out.println("Country selection close button preset?" + closeModalButton.size());
        if (closeModalButton.size() != 0) {
            wdWait.until(ExpectedConditions.elementToBeClickable(closeModalButton.get(0)));
            closeModalButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(closeModalButton.get(0)));
        }
    }


    private void inputSearchTermIntoSearchInputField(String searchTerm)
    {
        wdWait.until(ExpectedConditions.visibilityOf(searchComponent));
        WebElement searchInputField = searchComponent.findElement(By.id("txtSearch"));
        searchInputField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton()
    {
        WebElement searchButton = searchComponent.findElement(By.id("cmdSearch"));
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void search(String searchTerm)
    {
        navigateToHomepage();
        acceptCookiesIfPresent();
        //closeCountrySelectionModalIfPresent();
        inputSearchTermIntoSearchInputField(searchTerm);
        clickOnSearchButton();
    }

}
