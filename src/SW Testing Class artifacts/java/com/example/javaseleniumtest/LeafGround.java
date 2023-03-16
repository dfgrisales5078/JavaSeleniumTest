package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.manage().window().maximize();
            chromeDriver.get("https://leafground.com/link.xhtml;jsessionid=node0hmrlf11uxu8j1u349n3xznxac121274.node0");
            chromeDriver.findElement(By.partialLinkText("Go to Dashboard")).click();
            Thread.sleep(2000);
            chromeDriver.navigate().back();
            chromeDriver.findElement(By.partialLinkText("Find the URL without clicking me.")).click();

        }
}