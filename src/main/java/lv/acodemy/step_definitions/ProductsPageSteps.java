package lv.acodemy.step_definitions;

import io.cucumber.java.en.Given;
import lv.acodemy.page_object.ProductsPage;

public class ProductsPageSteps {

    private final ProductsPage productsPage = new ProductsPage();

    @Given("user selects {string} product from a list")
    public void userSelectsProductFromList(String productName) {
        productsPage.clickOnProductByName(productName);



    }
}
