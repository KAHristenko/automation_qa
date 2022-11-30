package lv.acodemy;

import lv.acodemy.constants.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaits {

    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(enabled = false)
    public void testWaiter() {
        driver.get(Generic.GOOGLE_URL);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
        driver.findElement(By.xpath("element_that_is_not_in_place"));
    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }
}

