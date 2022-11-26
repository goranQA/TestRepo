package pages;

import helpers.BaseHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PolovniAutomobiliSearchResultPage extends BaseHelper {

    WebDriver driver;

    public PolovniAutomobiliSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "cijena_od")
    WebElement cijenaOd;

    @FindBy(name = "cijena_do")
    WebElement cijenaDo;

    @FindBy(xpath = "//button[@class='button is-primary']")
    WebElement trazi;


    private void navigateToHomepage(String url) {
        driver.get(url);
    }


    private String selectMarka() {
        WebElement markabtn = driver.findElement(By.className("css-2b097c-container"));
        markabtn.click();

        WebElement marka = driver.findElement(By.xpath("//*[contains(text(),'Volkswagen')]"));
        String nazivMarke = marka.getText();
        marka.click();
        return nazivMarke;

    }

    private void selectModel(){
        WebElement modelBtn = driver.findElement(By.className("css-4zt6xq"));
        modelBtn.click();

        WebElement model = driver.findElement(By.xpath("//*[contains(text(),'Golf 2')]"));
        model.click();

    }

    private void inputCijenaOd(String from) {
        cijenaOd.sendKeys(from);

    }

    private void inputCijenaDo(String to) {
        cijenaDo.sendKeys(to);
    }

    private void clickOnTrazi() {
        trazi.click();


    }

    public String selectVehiclesWithinPriceRange(String url, String from, String to)  {
        navigateToHomepage(url);
        String nazivMarke = selectMarka();
        selectModel();
        inputCijenaOd(from);
        inputCijenaDo(to);
        clickOnTrazi();
        return nazivMarke;

    }

}


