package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PolovniAutomobiliLoginHomePage;

public class PolovniAutomobiliLoginTest extends BaseTest
{

    @Test
    public void login() throws InterruptedException {
        String email = "testiranje767@gmail.com";
        String password = "testiranje";

        PolovniAutomobiliLoginHomePage loginTest = new PolovniAutomobiliLoginHomePage(driver);
        loginTest.loginAutomobili(email, password);
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.id("header"));
        Assert.assertTrue(header.getText().contains("Goran"));


    }

}





