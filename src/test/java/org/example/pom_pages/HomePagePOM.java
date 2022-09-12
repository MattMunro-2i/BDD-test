package org.example.pom_pages;

import org.example.utils.SharedDictionary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePagePOM {

    private WebDriver driver;

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String item) {
        driver.findElement(By.cssSelector(".search-field")).sendKeys(item + Keys.ENTER);
    }
}
