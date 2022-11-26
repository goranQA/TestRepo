package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PolovniAutomobiliSecondArticlePage;

import java.util.List;

public class PolovniAutomobiliSecondArticleTest extends BaseTest {

    @Test
    public void openSecondArticle() throws InterruptedException {
        String term = "Volkswagen Golf 2";
        PolovniAutomobiliSecondArticlePage searchResult = new PolovniAutomobiliSecondArticlePage(driver);
        searchResult.automobiliSearchResult(term);

        Thread.sleep(1000);
        WebElement articles = driver.findElement(By.className("box-content"));
        List<WebElement> vehicles = articles.findElements(By.className("card-image"));
        vehicles.get(1).click();

        Thread.sleep(1000);
        WebElement header = driver.findElement(By.className("title"));
        Assert.assertTrue(header.getText().contains(term));
    }
}
