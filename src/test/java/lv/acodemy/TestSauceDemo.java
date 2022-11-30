package lv.acodemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static lv.acodemy.constants.Generic.SAUCE_URL;

public class TestSauceDemo {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void initialize {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        driver.get(SAUCE_URL);
    }

    @Test
    public void authorizeTest() {
        driver.get(SAUCE_URL);
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getTitleElement().getText(), "PRODUCTS");
    }
    @Test
    public void openProductTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getTitleElement().getText(), "Products");
        List<WebElement> productLabels = inventoryPage.productLabels();
        System.out.println(productLabels);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}