package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;
import pages.BlicSearchResultsPage;

public class BlickOpenSecondArticlePOMTest extends BaseTest
{
    @Test
    public void clickOnArticleInResults() throws InterruptedException {

        String searchTerm = "Veselin Jevrosimović";
        int numberOfArticle = 2;

        BlicHomePage homePage = new BlicHomePage(driver);
        homePage.searchGivenTerm(searchTerm);

        BlicSearchResultsPage searchResultsPage = new BlicSearchResultsPage(driver);

        String articleTitle = searchResultsPage.clickOnRequestedArticle(numberOfArticle);


        //wait for the article to show on the screen
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("article")));
        WebElement openedArticle = driver.findElement(By.className("article"));

        //check if Title from the article we clicked on is present on opened article
        Assert.assertTrue("Article titles don't match!",openedArticle.getText().toLowerCase().contains(articleTitle.toLowerCase()));

        Thread.sleep(6000);
    }
}
