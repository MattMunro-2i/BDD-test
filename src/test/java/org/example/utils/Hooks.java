package org.example.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pom_pages.CartPOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private WebDriver driver;

    private final SharedDictionary dict;

    public Hooks(SharedDictionary dict) {
        this.dict = dict;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dict.addDict("webdriver", driver);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
