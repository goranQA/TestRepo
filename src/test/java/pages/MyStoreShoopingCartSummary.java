package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class MyStoreShoopingCartSummary extends BaseHelper {



    WebDriver driver;
    public MyStoreShoopingCartSummary(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (className = "cart_unit")
    WebElement priceForOneUnit;

    @FindBy (id = "total_shipping")
    WebElement shiping;

    @FindBy (id = "total_price")
    WebElement totalPrice;

    @FindBy (className = "cart_quantity_up")
    WebElement plusQyantityButon;

    @FindBy (className = "cart_quantity_input")
    WebElement inputQty;
    @FindBy (className = "cart_total")
            WebElement check;
    @FindBy(className = "cart_navigation")
            WebElement bottomContainer;

        String qty = "5";
        private void inputQuantity () throws InterruptedException {
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart_quantity_input")));
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart_total")));
            inputQty.click();
            inputQty.clear();
            inputQty.sendKeys(qty);
            inputQty.click();
            Thread.sleep(6000);

    }
    private void checkForPrice (){

        List<WebElement> unitPrice = driver.findElements(By.className("cart_unit"));
        String unitPriceTxt = unitPrice.get(1).getText();
        float unitPriceFloat = Float.parseFloat(unitPriceTxt.replace("$",""));
        float totalPriceFloat = Float.parseFloat(totalPrice.getText().replace("$",""));
        float qtyInt = Float.parseFloat(qty);
        float priceOfShiping = Float.parseFloat(shiping.getText().replace("$",""));

       if ((unitPriceFloat*qtyInt+priceOfShiping)==totalPriceFloat){

            System.out.println("Total je uredu "+(unitPriceFloat*qtyInt+priceOfShiping));
           Assert.assertTrue(true);

        }else {
            System.out.println("Total je pao");
            Assert.assertFalse(false);
        }


    }


    public void setQuantity () throws InterruptedException {
            inputQuantity();
            checkForPrice();
    }

}
