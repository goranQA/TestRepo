package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportsDirectSearchResultsPage extends BaseHelper
{
    WebDriver driver;
    public SportsDirectSearchResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ProductContainer")
    WebElement resultsList;
    @FindBy(id = "filterlist")
    WebElement filterList;
    @FindBy(className = "totalProducts")
    WebElement numberOfProducts;
    @FindBy(id = "navlist")
    WebElement articlesList;

    private void selectGenderFilter(String gender)
    {
        wdWait.until(ExpectedConditions.visibilityOf(resultsList));
        wdWait.until(ExpectedConditions.visibilityOf(numberOfProducts));
        String productsNumber = numberOfProducts.getText();
        List<WebElement> filterListOptions = filterList.findElements(By.className("FilterListItem"));
        for(WebElement filter:filterListOptions)
        {
            if(filter.getText().contains(gender))
                filter.click();
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("totalProducts"),productsNumber));

    }
    private void selectCategoryFilter(String category)
    {
        wdWait.until(ExpectedConditions.visibilityOf(resultsList));
        wdWait.until(ExpectedConditions.visibilityOf(numberOfProducts));
        String productsNumber = numberOfProducts.getText();
        List<WebElement> filterListOptions = filterList.findElements(By.className("FilterListItem"));
        for(WebElement filter:filterListOptions)
        {
            if(filter.getText().contains(category))
                filter.click();
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("totalProducts"),productsNumber));
    }

    private void clickOnArticle(int articleNumber)
    {
        List<WebElement> articleList = articlesList.findElements(By.tagName("li"));
        articleList.get(articleNumber-1).click();
    }

    public void applyFilterAndSelectArticle(String gender,String category,int articleNumber)
    {
        selectGenderFilter(gender);
        selectCategoryFilter(category);
        clickOnArticle(articleNumber);
    }

}
