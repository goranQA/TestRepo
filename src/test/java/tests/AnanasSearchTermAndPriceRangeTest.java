package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.AnanasHomePage;
import pages.AnanasSecondPage;

import java.util.*;

public class AnanasSearchTermAndPriceRangeTest extends BaseTest {

    @Test
    public void AnanasSearchAndPriceCheck() throws InterruptedException{

        String url = "https://ananas.rs/";
        String searchTerm = "maske za telefon";
        String brand = "Nillkin";
        String minPrice = "700";
        String maxPrice = "790";

        AnanasHomePage ahAnanasHomePage = new AnanasHomePage(driver);
        ahAnanasHomePage.searchInsertedTerm(url, searchTerm);

        AnanasSecondPage ahAnanasSecondPage = new AnanasSecondPage(driver);
        ahAnanasSecondPage.selectCategoryInsertPrice(brand,minPrice, maxPrice);

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ais-Hits-list")));
        WebElement resultsContainer = driver.findElement(By.className("ais-Hits-list"));
        List<WebElement> articlesList = resultsContainer.findElements(By.tagName("li"));
        for (WebElement article : articlesList)
        {
            WebElement elementTittle = article.findElement(By.tagName("h3"));
            Assert.assertTrue("Tittle doesn't contain requested Brand.\nTittle is: "+elementTittle.getText()+ "\nRequested brand: "+brand,
                    elementTittle.getText().contains(brand));
            WebElement priceElement = article.findElement(By.className("sc-19ddzkc-11"));
            String priceElementText = priceElement.getText().replace(" ", "").replace("RSD", "").replace(".", "");
            float price = Float.parseFloat(priceElementText);
            Assert.assertTrue("Price is not in selected range for article:" + elementTittle,
                    (price>= Float.parseFloat(minPrice) && price <= Float.parseFloat(maxPrice)));
        }


    }
}
