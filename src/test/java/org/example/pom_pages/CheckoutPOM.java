package org.example.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPOM {

    WebDriver driver;

    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#billing_first_name")
    WebElement firstName;

    @FindBy(css = "input#billing_last_name")
    WebElement lastName;

    @FindBy(css = "input[name='billing_address_1']")
    WebElement add1;

    @FindBy(css = "input#billing_city")
    WebElement addCity;

    @FindBy(css = "input#billing_postcode")
    WebElement addPostcode;

    @FindBy(css = "input#billing_phone")
    WebElement phone;

    @FindBy(css = "button#place_order")
    WebElement placeOrder;


    public void setFirstName() {
        firstName.clear();
        firstName.sendKeys("Matt");
    }

    public void setLastName() {
        lastName.clear();
        lastName.sendKeys("Foulis");
    }

    public void setAdd1() {
        add1.clear();
        add1.sendKeys("1 High Street");
    }

    public void setAddCity() {
        addCity.clear();
        addCity.sendKeys("Edinburgh");
    }

    public void setAddPostcode() {
        addPostcode.clear();
        addPostcode.sendKeys("EH2 1DJ");
    }

    public void setPhone() {
        phone.clear();
        phone.sendKeys("01234567891");
    }

    public void placeOrder() {
                try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        placeOrder.click();
    }

}
