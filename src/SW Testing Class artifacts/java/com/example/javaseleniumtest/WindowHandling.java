package com.example.javaseleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // get window handle
        driver.get("https://letcode.in/windows");
        String windowHandle = driver.getWindowHandle();
        System.out.println("First window: " + windowHandle);

        // get window handles
        // display window id of a new window
        driver.findElement(By.id("home")).click();
        Set <String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        // display window ids of a new windows
        driver.findElement(By.id("multi")).click();
        Set<String> windowHandles1 = driver.getWindowHandles();
        System.out.println(windowHandles1);

        // Switching to other windows
        ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandles1);
        driver.switchTo().window(windowHandlesList.get(3));
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(windowHandlesList.get(0));
        System.out.println(driver.getCurrentUrl());


        Thread.sleep(6000);
        driver.close();
    }

}
