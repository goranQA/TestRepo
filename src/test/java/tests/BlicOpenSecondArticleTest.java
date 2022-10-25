package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlicOpenSecondArticleTest extends BaseTest{

    @Test
    public void searchTest() throws InterruptedException {
        String url = "https://www.blic.rs/";
        String searchTerm= "Veselin Jevrosimović";

        //navigate to Blic homepage
        driver.get(url);
        Thread.sleep(1000);

        //click on magnifier button to open search field
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("search-open")));
        WebElement searchButton = driver.findElement(By.id("search-open"));
        searchButton.click();

        //enter searchTerm into search field
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-input")));
        WebElement searchField = driver.findElement(By.id("search-input"));
        searchField.sendKeys(searchTerm);

        //again click on magnifier button
        WebElement searchComponent = driver.findElement(By.id("search"));
        WebElement secondSearchButton = searchComponent.findElement(By.tagName("button"));
        secondSearchButton.click();

        //find all articles on the page
        WebElement allArticles = driver.findElement(By.className("news-box"));
        List<WebElement> listOfArticles = allArticles.findElements(By.className("news"));

        //get Title from the second article in the list
        String articleTitle = listOfArticles.get(1).findElement(By.tagName("h2")).getText();

        //click on second article in the list
        listOfArticles.get(1).findElement(By.tagName("h2")).click();

        //wait for the article to show on the screen
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("article")));
        WebElement openedArticle = driver.findElement(By.className("article"));

        //check if Title from the article we clicked on is present on opened article
        Assert.assertTrue("Headers don't match!",openedArticle.getText().toLowerCase().contains(articleTitle.toLowerCase()));


        Thread.sleep(6000);
    }
}
