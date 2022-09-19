package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("the store ready to service customers")
    public void the_store_is_ready_to_service_customer() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exist")
    public void product_exist(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("Customer buy {string} with quantity {int}")
    public void customer_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("{string} stock should be {float}")
    public void stock_should_be(String name, double stock) {
        Product prod = catalog.getProduct(name);
        assertEquals(stock, prod.getStock());
    }

}

