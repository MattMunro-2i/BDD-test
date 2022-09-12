package org.example.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.UtilLib.waitForElementToBeClickable;

public class CartPOM {

    WebDriver driver;

    public CartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "td.product-name")
    WebElement cardProduct;

    @FindBy(css = ".remove")
    WebElement remove;

    @FindBy(name = "coupon_code")
    WebElement couponField;

    @FindBy(name = "apply_coupon")
    WebElement applyCoupon;

    @FindBy(css = ".cart-subtotal bdi")
    WebElement subtotal;

    @FindBy(css = "[data-title^=\"Coupon\"]")
    WebElement discount;

    @FindBy(css = "#shipping_method > li")
    WebElement shipping;

    @FindBy(css = ".order-total > td")
    WebElement total;

    @FindBy(linkText = "My account")
    WebElement myAccount;

    @FindBy(linkText = "Proceed to checkout")
    WebElement checkout;

    public String getProductText() {
        return cardProduct.getText();
    }

    public void removeItem() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        remove.click();
    }

    public boolean isCartEmpty() {
        waitForElementToBeClickable(driver, By.cssSelector(".cart-empty"), 5);
        WebElement empty = driver.findElement(By.cssSelector(".cart-empty"));
        return empty.isDisplayed();
    }

    public void applyCoupon(String coupon) {
        couponField.sendKeys(coupon);
        applyCoupon.click();
    }

    public float getSubtotal() {
        return Float.parseFloat(subtotal.getText().substring(1));
    }

    public Float getDiscount() {

        return Float.valueOf(
                discount.getText()
                        .substring(2) // Remove £ symbol
                        .replace("[Remove]", "") // Remove "[Remove]" text
        );
    }

    public float getShipping() {

        return Float.parseFloat(
                shipping.getText()
                        .replace("Flat rate: £", "") // remove surrounding text
        );
    }

    public float getTotal() {

        return Float.parseFloat(
                total.getText().substring(1) // Remove £
        );
    }

    public void goToMyAccount() {
        myAccount.click();
    }

    public void checkout() {
        checkout.click();
    }

}

