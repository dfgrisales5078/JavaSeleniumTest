package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Google {

    public static void main(String[] args) throws InterruptedException {
        OpenGoogleWithChrome();
        OpenGoogleWithFirefox();
        OpenGoogleWithSafari();
    }

    private static void OpenGoogleWithChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");
        chromeDriver.manage().window().maximize();
        Thread.sleep(6000);
        chromeDriver.close();
    }

    private static void OpenGoogleWithFirefox() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.google.com");
        firefoxDriver.manage().window().maximize();
        Thread.sleep(4000);
        firefoxDriver.close();
    }

    private static void OpenGoogleWithSafari() throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver safariDriver = new SafariDriver();
        safariDriver.get("https://www.google.com");
        safariDriver.manage().window().maximize();
        Thread.sleep(4000);
        safariDriver.close();
    }
}
