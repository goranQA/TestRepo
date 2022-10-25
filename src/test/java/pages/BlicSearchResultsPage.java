package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlicSearchResultsPage extends BaseHelper
{
    WebDriver driver;
    public BlicSearchResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="news-box")
    WebElement results;

    public String clickOnRequestedArticle(int numberOfElement)
    {
        wdWait.until(ExpectedConditions.visibilityOf(results));
        List<WebElement> articleList = results.findElements(By.tagName("article"));
        WebElement article = articleList.get(numberOfElement-1).findElement(By.tagName("h2"));
        String articleTitle = article.getText();
        article.click();
        return articleTitle;
    }
}
