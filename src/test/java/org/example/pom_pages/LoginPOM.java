package org.example.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
    private WebDriver driver;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement username;

    @FindBy(linkText = "Dismiss")
    WebElement cookieNotice;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement login;

    public void login() {
        username.sendKeys("matt@matt.com");
        password.sendKeys("matthewf123!$");
        login.click();
    }

    public void acceptCookies() {
        cookieNotice.click();
    }
}
