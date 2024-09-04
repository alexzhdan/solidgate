package org.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverProvider {

    public static WebDriver getWebDriver() {
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 20;
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        return driver;
    }
}
