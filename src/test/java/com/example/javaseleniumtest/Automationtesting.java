// Assignment 2

package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automationtesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://demo.automationtesting.in/Register.html");

        // get title
        System.out.println(chromeDriver.getTitle());

        // Enter first and last name using xpath
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("John");
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Doe");

        // Enter email and phone number using cssSelector
        chromeDriver.findElement(By.cssSelector("#eid > input")).sendKeys("email@gmail.com");

        // Enter phone number using xpath
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("2397777777");

        // Select radio button using cssSelector
        chromeDriver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input")).click();

        // Select hobbies checkboxes id
        for (int i = 1; i <= 3; i++) {
            chromeDriver.findElement(By.id("checkbox" + i)).click();
        }

        // Find and click on refresh button using xpath
        chromeDriver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();


    }
}
