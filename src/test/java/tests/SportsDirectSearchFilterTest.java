package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SportsDirectArticlePage;
import pages.SportsDirectHomePage;
import pages.SportsDirectMyBagPage;
import pages.SportsDirectSearchResultsPage;

public class SportsDirectSearchFilterTest extends BaseTest
{
    @Test
    public void searchFilterTest() throws InterruptedException {

        String searchTerm = "Reebok Clasics";
        String gender = "Men";
        String category = "Trainers";
        int articleNumber = 4;
        String quantityInBag = "4";

        SportsDirectHomePage sportsDirectHomePage= new SportsDirectHomePage(driver);
        sportsDirectHomePage.search(searchTerm);

        SportsDirectSearchResultsPage sportsDirectSearchResultsPage = new SportsDirectSearchResultsPage(driver);
        sportsDirectSearchResultsPage.applyFilterAndSelectArticle(gender,category,articleNumber);

        SportsDirectArticlePage sportsDirectArticlePage = new SportsDirectArticlePage(driver);
        sportsDirectArticlePage.addArticleAndOpenBag();

        SportsDirectMyBagPage sportsDirectMyBagPage = new SportsDirectMyBagPage(driver);
        sportsDirectMyBagPage.changeAmount(quantityInBag);


        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("productLine")));
        WebElement products = driver.findElement(By.className("productLine"));
        WebElement totalPrice = products.findElement(By.className("itemtotalprice"));
        WebElement price = products.findElement(By.className("itemprice"));
        String articlePrice = price.getText();
        String priceAll = totalPrice.getText();

        System.out.println("Article price is: "+articlePrice);
        System.out.println("TotalPrice is: "+priceAll);

        float articlePriceFloat = Float.parseFloat(articlePrice.replace("£","").replace(" ",""));
        float totalPriceFloat = Float.parseFloat(priceAll.replace("£","").replace(" ",""));


        Assert.assertTrue("Ukupna cijena artikala nije tacna!",((Float.parseFloat(quantityInBag))*articlePriceFloat)==totalPriceFloat);

        Thread.sleep(6000);
    }
}
