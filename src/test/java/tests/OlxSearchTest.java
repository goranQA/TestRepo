package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OlxSearchTest extends BaseTest
{
    @Test
    public void searchTest() throws InterruptedException {
        String url = "https://www.olx.ba/";
        String searchTerm= "Xiaomi";

        driver.get(url);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("trazilica")));
        WebElement searchField = driver.findElement(By.name("trazilica"));
        searchField.sendKeys(searchTerm);

        WebElement searchComponent = driver.findElement(By.name("searchform"));
        WebElement searchButton = searchComponent.findElement(By.tagName("button"));
        searchButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rezultatipretrage")));
        WebElement searchResults = driver.findElement(By.id("rezultatipretrage"));
        Assert.assertTrue("Search term not found on results page.",searchResults.getText().toLowerCase().contains(searchTerm.toLowerCase()));

        Thread.sleep(6000);
    }
}
