package tests;

import org.junit.Test;
import org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Marker;
import pages.MyStoreHomePage;
import pages.MyStoreSelectSizePage;
import pages.MyStoreShoopingCartSummary;

public class Lazar_MyStoreSearchForItemAndPurchase extends BaseTest {



    @Test
    public void myStoreSearchForItemAndPurchase () throws InterruptedException{

        String url = "http://automationpractice.com/index.php";

        MyStoreHomePage searchHomePage = new MyStoreHomePage(driver);
        searchHomePage.search(url);



        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("ajax_block_product")));
        WebElement allBestSellers = driver.findElement(By.id("blockbestsellers"));
        List<WebElement> listOfAllBestSellers = allBestSellers.findElements(By.className("ajax_block_product"));

        int i = 0;
        for (WebElement list:listOfAllBestSellers){

            if (i == 2 ){
                listOfAllBestSellers.get(i).click();
                wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("lnk_view")));
                listOfAllBestSellers.get(i).findElement(By.className("lnk_view")).click();
            }

            i++;
        }

        // Mirko moze mala pomoc, hocu da uradim Naslov u kodu.
        // // MARK: - Naslov onoga sto radimo dalje, ovako smo radili u Swiftu, kako se to radi ovde? :)


        MyStoreSelectSizePage qtyAndSize = new MyStoreSelectSizePage(driver);
        qtyAndSize.setSize();

        MyStoreShoopingCartSummary checkShopingCart = new MyStoreShoopingCartSummary(driver);
        checkShopingCart.setQuantity();

    Thread.sleep(3000);

    }
}
