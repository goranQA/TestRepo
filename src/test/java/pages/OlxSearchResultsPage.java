package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OlxSearchResultsPage extends BaseHelper
{
    WebDriver driver;
    public OlxSearchResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "od")
    WebElement odInputField;
    @FindBy(id = "do")
    WebElement doInputField;
    @FindBy(className = "brojrezultata")
    WebElement resultsNumber;
    @FindBy(className = "osvjezirezultate")
    WebElement applyButton;


    private void inputFrom(String from)
    {
        //js.executeScript("arguments[0].scrollIntoView();",odInputField);
        odInputField.sendKeys(from);
    }
    private void inputTo(String to)
    {
        doInputField.sendKeys(to);
    }
    private void applyButton()
    {
        applyButton.click();
    }
    public void selectArticlesWithinPriceRange(String from, String to)
    {
        String numberOfSecondResults = resultsNumber.getText();
        inputFrom(from);
        inputTo(to);
        applyButton();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("brojrezultata"),numberOfSecondResults));

    }
}
