package org.example.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviousOrders {

    WebDriver driver;

    public PreviousOrders(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement isOrderThere(String orderNo) {
        return driver.findElement(By.linkText("#" + orderNo));
    }
}
