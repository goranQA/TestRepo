package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.OlxSearchResultsPage;
import pages.OlxWelcomePage;

import java.util.List;

public class OlxFilterSearchResultsTest extends BaseTest
{
    @Test
    public void olxFilterSearchResultsTest() throws InterruptedException {
        String url = "https://www.olx.ba/";
        String searchTerm = "NVidia";
        String from = "100";
        String to = "100";

        OlxWelcomePage searchOnWelcomePage = new OlxWelcomePage(driver);
        searchOnWelcomePage.searchOlx(url,searchTerm);

        OlxSearchResultsPage selectArticles = new OlxSearchResultsPage(driver);
        selectArticles.selectArticlesWithinPriceRange(from,to);

        WebElement filterResults = driver.findElement(By.id("rezultatipretrage"));
        List<WebElement> results = filterResults.findElements(By.className("listitem"));

        System.out.println("Number of items on page: "+results.size());

        results.removeIf(result -> result.findElement(By.className("cijena")).getText().contains("DOGOVORU"));

        System.out.println(results.size());

        for (WebElement result:results)
        {
            String title = result.findElement(By.className("naslov")).getText();
            System.out.println("Article title is: "+title);
            String price = result.findElement(By.className("cijena")).getText();
            System.out.println("Article price is: "+price);

            Assert.assertTrue("Article: \n"+ title + "\n does NOT contain Search Term in the tittle!",title.toUpperCase().contains(searchTerm.toUpperCase()));
            Assert.assertTrue("Article  \n"+ title + "\n does NOT have given price!",price.contains(from));
        }


        Thread.sleep(6000);
    }
}
