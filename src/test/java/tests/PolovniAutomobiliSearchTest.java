package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PolovniAutomobiliSearchPage;

public class PolovniAutomobiliSearchTest extends BaseTest {

    @Test
    public void autoSearchResultPage() throws InterruptedException {
        String term = "Volkswagen Golf 2";
        PolovniAutomobiliSearchPage searchResult = new PolovniAutomobiliSearchPage(driver);
        searchResult.searchAutomobili(term);
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.className("box-content"));
        Assert.assertTrue(header.getText().contains("Volkswagen Golf 2"));

    }
}
