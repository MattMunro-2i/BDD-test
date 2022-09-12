package org.example.pom_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {

    WebDriver driver;

    public MyAccountPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    @FindBy(linkText = "Shop")
    WebElement shop;

    @FindBy(linkText = "Logout")
    WebElement logout;

    @FindBy(linkText = "Orders")
    WebElement orders;
    public void signout() {
        logout.click();
    }

    public void gotoShop() {
        shop.click();
    }
    public void gotoOrders() { orders.click();}
}
