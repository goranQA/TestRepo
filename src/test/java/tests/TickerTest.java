package tests;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import pages.TickerHomePage;

import java.util.*;

public class TickerTest extends BaseTest {


    @Test
    public void tickerTest() throws InterruptedException {

        String url = "https://www.tagesanzeiger.ch/this-is-a-standard-live-ticker-397406487788";
        String requiredMessage = "Beginn des Livetickers";
        //String requiredMessage = "This is a second message";

        TickerHomePage tickerHomePage = new TickerHomePage(driver);
        tickerHomePage.navigateToPage(url);

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContentMetaInfo_root__5qV_a")));
        WebElement liveTickerContainer = driver.findElement(By.className("LiveIndicator_root__u7xI_"));
        WebElement tickerMassageContainer = driver.findElement(By.className("TickerEvents_eventslist__9F59v"));
        WebElement liveTickerIcon = liveTickerContainer.findElement(By.className("LiveTickerIcon_root__6Ulb0"));

        List<WebElement> tickerMessageList = tickerMassageContainer.findElements(By.className("HtmlText_root__3vQQX")); //dohvacamo listu poruka od najnovije do najstarije

        Assert.assertTrue("Live ticker icon is not present!", liveTickerIcon.isDisplayed());
        Assert.assertTrue("Live indicator message is not present!", liveTickerContainer.getText().contains("LIVE"));
        Assert.assertTrue("First message is not correct! \nExpected:"+requiredMessage+"\nFound:"+tickerMessageList.get(tickerMessageList.size()-1).getText(),
                tickerMessageList.get(tickerMessageList.size()-1).getText().contains(requiredMessage));

        Thread.sleep(6000);
    }
}
