package lv.acodemy.step_definitions;

import io.cucumber.java.en.Given;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonStepDefs {

    private WebDriver driver = DriverManager.getInstance();

    @Given("user open {string}")
    public void userOpenUrl(String url) {
        driver.get(url);
    }
}
