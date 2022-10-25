package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleHomePage;

public class BrowserTest extends BaseTest
{
    @Test
    public void googleSearchTest() throws InterruptedException
    {
        String url = "https://www.google.com/";
        String searchTerm = "QA Revealed";

        GoogleHomePage googleHomePOMPage = new GoogleHomePage(driver);
        googleHomePOMPage.searchTest(url,searchTerm);

        // confirm search term is on Google result page
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        WebElement searchResults = driver.findElement(By.id("rcnt"));

        Assert.assertTrue(searchResults.getText().contains("QA Revealed"));

        Thread.sleep(3000);
    }

    @Test
    public void yahooSearchTest() throws InterruptedException
    {
        String url ="https://www.yahoo.com/";
        String searchTerm = "QA Revealed";

        // navigate to https://www.yahoo.com/
        driver.get(url);

        // enter search term in search field
        WebElement searchField = driver.findElement(By.name("p"));
        searchField.sendKeys(searchTerm);

        // click on search button
        WebElement searchButton = driver.findElement(By.id("ybar-search"));
        searchButton.click();

        // confirm search term is on Yahoo result page
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement searchResults = driver.findElement(By.id("results"));

        Assert.assertTrue("Search term not found on results page.",searchResults.getText().contains(searchTerm));

        Thread.sleep(6000);

    }

}
