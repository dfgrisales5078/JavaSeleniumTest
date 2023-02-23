package com.example.javaseleniumtest;
import com.codeborne.selenide.impl.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com");
        WebElement searchBox = chromeDriver.findElement(By.name("q"));
        searchBox.sendKeys("FGCU");
        searchBox.submit();


    }
}
