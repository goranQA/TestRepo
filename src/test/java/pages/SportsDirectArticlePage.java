package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportsDirectArticlePage extends BaseHelper
{
    WebDriver driver;
    public SportsDirectArticlePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ulSizes")
    WebElement sizeList;
    @FindBy(id = "ProductStandardAddToBag")
    WebElement addToBagButton;
    @FindBy(id = "bagQuantityContainer")
    WebElement openBagButton;

    private void selectSize()
    {
        List<WebElement> sizes = sizeList.findElements(By.tagName("li"));
        for (WebElement size: sizes)
        {
            String classes = size.getAttribute("class");
            if (!classes.contains("greyOut"))
            {
                size.click();
                break;
            }
        }
    }
    private void clickAddToBagButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        addToBagButton.click();
    }
    private void openBag()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(openBagButton));
        openBagButton.click();
    }

    public void addArticleAndOpenBag()
    {
        selectSize();
        clickAddToBagButton();
        openBag();
    }

}
