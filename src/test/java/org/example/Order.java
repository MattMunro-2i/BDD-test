package org.example;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.pom_pages.*;
import org.example.utils.SharedDictionary;
import org.openqa.selenium.WebDriver;

public class Order {

    // POM pages
    LoginPOM login;
    MyAccountPOM myaccount;
    HomePagePOM home;
    SearchResultsPOM search;
    CartPOM cart;
    CheckoutPOM checkout;
    OrderPOM order;
    PreviousOrders previousOrders;

    String orderNo;

    private final SharedDictionary dict;
    private WebDriver driver;

    public Order(SharedDictionary dict) {
        this.dict = dict;
        this.driver = (WebDriver) dict.readDict("webdriver");
        login = new LoginPOM(driver);
        myaccount = new MyAccountPOM(driver);
        home = new HomePagePOM(driver);
        search = new SearchResultsPOM(driver);
        cart = new CartPOM(driver);
        checkout = new CheckoutPOM(driver);
        order = new OrderPOM(driver);
        previousOrders = new PreviousOrders(driver);
    }


    @Given("I have an order in my basket")
    public void iHaveOrderInBasket() {
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");

        login.acceptCookies();
        login.login();
        myaccount.gotoShop();
        home.searchFor("cap");
        search.addToCart();
        search.viewCart();
        cart.checkout();
    }

    @When("I place the order")
    public void iPlaceTheOrder() {
        checkout.setFirstName();
        checkout.setLastName();
        checkout.setAdd1();
        checkout.setAddCity();
        checkout.setAddPostcode();
        checkout.setPhone();
        checkout.placeOrder();
    }

    @Then("I get an order number")
    public void iGetAnOrderNumber() {
        orderNo = order.getOrderNo();
    }

    @And("The order appears in my orders")
    public void theOrderAppearsInMyOrders() {
        order.gotoMyAccount();
        myaccount.gotoOrders();
        previousOrders.isOrderThere(orderNo);
    }
}
