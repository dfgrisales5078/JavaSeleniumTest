package com.example.javaseleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scrolling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://artoftesting.com/selenium-tutorial");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        JavascriptExecutor exe = (JavascriptExecutor) driver;

        exe.executeScript("window.scroll(0, 5000)", ""); // scroll down
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0, -5000)", ""); // scroll up
        Thread.sleep(2000);

        driver.close();

    }
}
