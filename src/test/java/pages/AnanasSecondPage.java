package pages;

import helpers.BaseHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AnanasSecondPage extends BaseHelper {

    WebDriver driver;
    public AnanasSecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "sc-1kcrxl6-1")
    WebElement priceContainer;
    @FindBy(className="sc-1q3guog-1")
    WebElement brandContainer;
    @FindBy(className="sc-3ghezf-1")
    WebElement resultsNumber;

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

    private void selectBrand(String brand)
    {
        wdWait.until(ExpectedConditions.visibilityOf(brandContainer));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));
        String numberOfResultsPriorFilter = resultsNumber.getText();
        List<WebElement> brandList = brandContainer.findElements(By.className("sc-run77q-0"));
        for(WebElement brandCheckboxItem : brandList)
        {
            if(brandCheckboxItem.getText().contains(brand))
            {
                brandCheckboxItem.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("sc-3ghezf-1"),numberOfResultsPriorFilter));
    }

    private void insertPrice(String minPrice, String maxPrice) {
        wdWait.until(ExpectedConditions.visibilityOf(priceContainer));
        List<WebElement> listOfPrice = priceContainer.findElements((By.className("MuiInputBase-root")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", priceContainer);
        wdWait.until(ExpectedConditions.visibilityOf(listOfPrice.get(0)));

        WebElement minInputField = listOfPrice.get(0).findElement(By.tagName("input"));
        while (!minInputField.getAttribute("value").equals("")) {
            minInputField.sendKeys(Keys.BACK_SPACE);
        }
        minInputField.sendKeys(minPrice);

        WebElement maxInputField = listOfPrice.get(1).findElement(By.tagName("input"));
        while (!maxInputField.getAttribute("value").equals("")) {
            maxInputField.sendKeys(Keys.BACK_SPACE);
        }
        maxInputField.sendKeys(maxPrice);


    }

    private void clickApplyButton()
    {
        WebElement correctButton = priceContainer.findElement(By.tagName("button"));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));
        String numberOfResultsPriorFilter = resultsNumber.getText();
        correctButton.click();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("sc-3ghezf-1"),numberOfResultsPriorFilter));
    }

    public void selectCategoryInsertPrice(String brand,String minPrice, String maxPrice) throws InterruptedException {
        acceptCookies();
        selectBrand(brand);
        insertPrice(minPrice, maxPrice);
        acceptCookies();
        clickApplyButton();
    }

}
