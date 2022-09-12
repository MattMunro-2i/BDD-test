package org.example.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPOM {

    WebDriver driver;


    public SearchResultsPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "add-to-cart")
    WebElement addToCartButton;

    @FindBy(linkText = "View cart")
    WebElement viewCartLink;

    public void addToCart() {
        addToCartButton.click();
    }

    public void viewCart() {
        viewCartLink.click();
    }

}
