package tests;

import org.junit.*;
import pages.*;


public class GarminLoginTest extends BaseTest {


    @Test
    public void garminLogInTest() throws InterruptedException{

        String url = "https://connect.garmin.com/";
        String user = "ThisIsNotCorrectEmail";
        String password = "ThisIsNotCorrectPassword";


        GarminHomePage garminHomePage = new GarminHomePage(driver);
        garminHomePage.openSignInPage(url);

        GarminLoginPage garminLoginPage = new GarminLoginPage(driver);
        garminLoginPage.inputCredentials(user,password);


        //There is no Assert here, goal of this test is to see how we handle frames in Selenium

        Thread.sleep(6000);

    }
}
