package org.example.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.UtilLib.waitForElementToBeClickable;

public class OrderPOM {

    WebDriver driver;

    public OrderPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    @FindBy(css = ".order > strong")
    WebElement orderNo;

    @FindBy(linkText = "My account")
    WebElement myAccount;

    public String getOrderNo() {
        waitForElementToBeClickable(driver, By.cssSelector(".order > strong"), 5);
        return orderNo.getText();
    }

    public void gotoMyAccount() {
        myAccount.click();
    }
}
