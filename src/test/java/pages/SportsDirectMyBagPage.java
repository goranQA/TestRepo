package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SportsDirectMyBagPage extends BaseHelper
{
    WebDriver driver;
    public SportsDirectMyBagPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "s-basket-quantity-text-box")
    WebElement quantityContainer;
    @FindBy(id = "lbtnUpdateQtyAndVariants")
    WebElement updateBagButton;
    @FindBy(className = "itemtotalprice")
    WebElement totalPrice;

    private void inputQuantity(String quantity)
    {
        wdWait.until(ExpectedConditions.visibilityOf(quantityContainer));
        WebElement inputField = quantityContainer.findElement(By.tagName("input"));
        inputField.clear();
        inputField.sendKeys(quantity);
    }
    private void clickUpdateBagButton()
    {
        String priceAll = totalPrice.getText();
        wdWait.until(ExpectedConditions.elementToBeClickable(updateBagButton));
        updateBagButton.click();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("itemtotalprice"),priceAll));

    }

    public void changeAmount(String quantity)
    {
        inputQuantity(quantity);
        clickUpdateBagButton();
    }
}
