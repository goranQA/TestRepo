package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.PolovniAutomobiliSearchResultPage;

import java.util.List;

public class PolovniAutomobiliSearchResultsTest extends BaseTest {


    @Test
    public void polovniAutomobiliSearchResultsTest() throws InterruptedException {

        String url = "https://polovniautomobili.ba/";
        String from = "2000";
        String to = "2000";
        String nazivMarke;

        PolovniAutomobiliSearchResultPage selectVehicle = new PolovniAutomobiliSearchResultPage(driver);
        nazivMarke = selectVehicle.selectVehiclesWithinPriceRange(url,from, to);

        Thread.sleep(10000);
        WebElement filterResults = driver.findElement(By.className("column"));
        List<WebElement> results = filterResults.findElements(By.className("column"));
        results.removeIf(result -> result.findElement(By.className("card-price")).getText().contains("Po dogovoru"));

        for (WebElement result : results) {
            String title = result.findElement(By.className("card-title")).getText();
            System.out.println("Vehicle title is: " + title);
            String price = result.findElement(By.className("card-price")).getText();
            System.out.println("Vehicle price is: " + price);


            Assert.assertTrue("Vehicle: \n" + title + "\n There are not vehicle in the tittle!", title.toUpperCase().contains(nazivMarke.toUpperCase()));
            Assert.assertTrue("Vehicle  \n" + title + "\n There is not given price!", price.contains(from));
        }


        Thread.sleep(100);
    }
}








