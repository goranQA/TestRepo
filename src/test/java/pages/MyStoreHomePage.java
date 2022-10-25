package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyStoreHomePage extends BaseHelper {

    WebDriver driver;
    public MyStoreHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "blockbestsellers")
    WebElement bestSelersButton;

    @FindBy (id = "blockbestsellers")
    WebElement allBestSelers;



    private void navigateToHomePage(String url) {
        driver.get(url);
    }

    private void clickOnBestSelers () {

        wdWait.until(ExpectedConditions.visibilityOf(bestSelersButton));
        js.executeScript("arguments[0].scrollIntoView();",bestSelersButton);
        bestSelersButton.click();
    }


    public void search (String url){

        navigateToHomePage(url);
        clickOnBestSelers();

    }

}



