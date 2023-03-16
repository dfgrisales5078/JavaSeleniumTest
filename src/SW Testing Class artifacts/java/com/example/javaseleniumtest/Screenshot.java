package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://artoftesting.com/selenium-tutorial");
        driver.manage().window().maximize();

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("/Users/dg/Library/CloudStorage/OneDrive-FloridaGulfCoastUniversity/FGCU/Spring 2023/Software Testing/InteliJ/JavaSeleniumTest/test.png");
        FileHandler.copy(src, des);
    }
}
