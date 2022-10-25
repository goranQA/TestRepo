package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HerokuAppLoginPage;

public class HerokuAppLoginTest extends BaseTest
{
    @Test
    public void loginWithValidCredentialsTest()
    {
        //introduce username & password
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        //create new object and call login method on it
        HerokuAppLoginPage loginPage = new HerokuAppLoginPage(driver);
        loginPage.login(username, password);

        //Assert valid login
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("success")));
        WebElement loginMessage = driver.findElement(By.className("success"));
        WebElement logOutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue("Error during logging in! No login message is shown!",loginMessage.getText().contains("You logged into a secure area!"));
        Assert.assertTrue("Logout Button is not shown!", logOutButton.isDisplayed());


    }

    @Test
    public void loginWithInvalidUsernamesTest()
    {
        //introduce username & password
        String username = "NOTtomsmith";
        String password = "SuperSecretPassword!";

        //create new object and call login method on it
        HerokuAppLoginPage loginPage = new HerokuAppLoginPage(driver);
        loginPage.login(username, password);

        //Assert invalid login
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("error")));
        WebElement errorMessage = driver.findElement(By.className("error"));
        Assert.assertTrue("Error! Message should be shown.",errorMessage.getText().contains("Your username is invalid!"));


    }

}
