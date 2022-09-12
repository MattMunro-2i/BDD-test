package org.example;

import io.cucumber.java.en.*;

import org.example.pom_pages.*;
import org.example.utils.SharedDictionary;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;

public class Basket {

    LoginPOM login;
    MyAccountPOM myaccount;
    HomePagePOM home;
    SearchResultsPOM search;
    CartPOM cart;
    private final SharedDictionary dict;
    private WebDriver driver;

    public Basket(SharedDictionary dict) {
        this.dict = dict;
        this.driver = (WebDriver) dict.readDict("webdriver");

        login = new LoginPOM(driver);
        myaccount = new MyAccountPOM(driver);
        home = new HomePagePOM(driver);
        search = new SearchResultsPOM(driver);
        cart = new CartPOM(driver);

    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
        login.login();
    }

    @Given("I am on the website homepage")
    public void i_am_on_the_website_homepage() {
        myaccount.gotoShop();
    }


    @When("I search for {string}")
    public void iSearchFor(String item) {
        home.searchFor(item);
    }

    @And("Add {string} to my cart")
    public void addToMyCart(String searchterm) {
        search.addToCart();
    }


    @Then("{string} is in my cart")
    public void isInMyCart(String searchterm) {
        search.viewCart();
        MatcherAssert.assertThat(cart.getProductText(), is(equalToIgnoringCase(searchterm)));

        // Clear basket ready for next test
        cart.removeItem();
    }


    @Given("I have {string} in my cart")
    public void iHaveInMyCart(String item) {
        home.searchFor(item);
        search.addToCart();
    }

    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        search.viewCart();
    }

    @When("I delete {string} from my cart")
    public void iDeleteFromMyCart(String arg0) {
        cart.removeItem();
    }

    @Then("My cart is empty")
    public void myCartIsEmpty() {
        MatcherAssert.assertThat(cart.isCartEmpty(), is(true));
    }


    @Given("I have a {string} in my basket")
    public void iHaveAnItemInMyBasket(String item) {
        home.searchFor(item);
        search.addToCart();
        search.viewCart();


    }

    @And("I apply a discount code")
    public void iApplyADiscountCode() {
        cart.applyCoupon("edgewords");
    }

    @Then("The correct prices are shown")
    public void theCorrectPricesAreShown() {

        float subtotal = cart.getSubtotal();
        float discountApplied = cart.getDiscount();
        float correctDiscount = (float) (subtotal * 0.15);

        MatcherAssert.assertThat(discountApplied, is(correctDiscount));

        // Clean up
        cart.removeItem();
        cart.goToMyAccount();

        MyAccountPOM myaccount = new MyAccountPOM(driver);
        myaccount.signout();
    }
}
