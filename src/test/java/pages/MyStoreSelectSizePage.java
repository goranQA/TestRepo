package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class MyStoreSelectSizePage extends BaseHelper {

    WebDriver driver;
    public MyStoreSelectSizePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy  (id = "quantity_wanted")
        WebElement quantityField;


    @FindBy (className = "attribute_list")
            WebElement sizeSlider;

    @FindBy (className = "selector")
            WebElement sliderTest;
    // Nasao je slider i klik radi !!!!

    @FindBy (className = "group_1")
            List<WebElement> sliderList;





    @FindBy (id = "our_price_display")
    WebElement priceForOneItem;


    private void selectSize () throws InterruptedException {

        WebElement span = sliderTest.findElement(By.tagName("span"));// ovo radi ne diraj
      // sliderTest.click();


        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("selector")));
       List <WebElement> sliderSize = driver.findElements(By.tagName("option"));
        sliderSize.get(1).click();
        Thread.sleep(300);


        WebElement testForSize = driver.findElement(By.className("selector"));
        WebElement testForSizeLower = testForSize.findElement(By.tagName("span"));

        /*String wantedSize = "M";
        int i = 0;
        for (WebElement list:sliderSize) {
            if (sliderSize.get(i).getText() == wantedSize) {
            }
        }
        Thread.sleep(300);
 */  // Mirko je rekao da da vec postoji funkcija za trazenje u listama kao i replace sto je bio
        // Izvini nisam uspeo da nadjem, nadam se da ces mi pokazati :)

    }
    @FindBy (className = "box-cart-bottom")
    WebElement buttonAdd; // NE DIRAJ


    private void addToTheCartButton () {

        js.executeScript("arguments[0].scrollIntoView();",buttonAdd);
        buttonAdd.findElement(By.id("add_to_cart")).click(); // Radi ne diraj !!!!!

    }


    private void waitForCheckout() throws InterruptedException {



        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("layer_cart")));
        // CEKAMO POP-UP PROZOR
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("button-medium")));
        // CEKAMO DUGME

        WebElement buttonCont = driver.findElement(By.className("button-medium"));
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonCont));
        buttonCont.click();

                Thread.sleep(3000);
    }



    public void setSize() throws InterruptedException {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("quantity_wanted")));
        selectSize();
        addToTheCartButton();
        waitForCheckout();
    }


}
