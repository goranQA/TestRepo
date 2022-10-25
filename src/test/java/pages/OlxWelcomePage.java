package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OlxWelcomePage extends BaseHelper
{

    WebDriver driver;
    public OlxWelcomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchinput")
    WebElement searchInputField;
    @FindBy (className = "btn-mainsearch")
    WebElement searchButton;


    private void navigateToPage(String url)
    {
        driver.get(url);
    }
    private void inputSearchTerm(String searchTerm)
    {
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("searchinput")));
        searchInputField.sendKeys(searchTerm);
    }
    private void clickSearchButton()
    {
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("btn-mainsearch")));
        searchButton.click();
    }

    public void searchOlx(String url, String searchTerm)
    {
        navigateToPage(url);
        inputSearchTerm(searchTerm);
        clickSearchButton();
    }
}
