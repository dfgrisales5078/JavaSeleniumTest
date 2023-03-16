package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FGCU {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.fgcu.edu");
        chromeDriver.manage().window().maximize();
        Thread.sleep(6000);
        chromeDriver.close();

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.fgcu.edu");
        firefoxDriver.manage().window().maximize();
        Thread.sleep(6000);
        firefoxDriver.close();

    }
}
