package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BaseHelper
{
    WebDriver driver;
    public GoogleHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "q")
    WebElement searchField;
    @FindBy(name = "btnK")
    WebElement searchButton;

    private void navigateToHomepage(String adresa)
    {
        driver.get(adresa);
    }

    private void inputSearchTerm(String trazeniPojam)
    {
        searchField.sendKeys(trazeniPojam);
    }

    private void clickOnSearchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void searchTest(String link, String pojam)
    {
        navigateToHomepage(link);
        inputSearchTerm(pojam);
        clickOnSearchButton();
    }
}
