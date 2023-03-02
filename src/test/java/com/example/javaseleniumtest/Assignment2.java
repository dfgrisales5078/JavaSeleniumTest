// Assignment 2

package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        //--------------   Add/Delete Web Element  --------------
        chromeDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(4000);
        WebElement addElementButton = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        addElementButton.click();
        Thread.sleep(4000);
        WebElement deleteElementButton = chromeDriver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        deleteElementButton.click();

        //--------------   Enter text in text and search button  --------------
        chromeDriver.get("https://demo.automationtesting.in/Register.html");
        // Enter first and last name using xpath
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("John");
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Doe");
        Thread.sleep(4000);
        // clear first and last name text
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).clear();
        Thread.sleep(4000);

        // Enter email and phone number using cssSelector
        chromeDriver.findElement(By.cssSelector("#eid > input")).sendKeys("email@gmail.com");

        // Enter phone number using xpath
        chromeDriver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("2397777777");

        //--------------   Checkboxes and Radio buttons   --------------
        chromeDriver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input")).click();

        for (int i = 1; i <= 3; i++) {
            chromeDriver.findElement(By.id("checkbox" + i)).click();
        }

        //--------------   Dropdown Menus  --------------
        chromeDriver.get("https://leafground.com/select.xhtml;jsessionid=node017poao36bf3jpf8z96wy3hxk1135438.node0");
        Select fav_ui_automation_tool_dropdown = new Select(chromeDriver.findElement(By.className("ui-selectonemenu")));
        fav_ui_automation_tool_dropdown.selectByVisibleText("Selenium");

        // -------------- Drag and Drop ----------------
        chromeDriver.get("https://demoqa.com/droppable");
        Thread.sleep(4000);
        Actions action = new Actions(chromeDriver);
        WebElement drag = chromeDriver.findElement(By.id("draggable"));
        WebElement drop = chromeDriver.findElement(By.id("droppable"));
        action.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(4000);

        // -------------- Get the title and current url of the selected webpage --------------
        System.out.println(chromeDriver.getTitle());
        String current_url = chromeDriver.getCurrentUrl();
        System.out.println(current_url);

        // ---------- List the size and display the number of Web Elements present in the current Webpage. -----------
        chromeDriver.get("https://www.amazon.com/");
        List<WebElement> all_elements = chromeDriver.findElements(By.tagName("a"));
        System.out.println("" + all_elements.size());

        for (WebElement element : all_elements) {
            System.out.println(element.getText());
        }

        // --------------  Close the browser  --------------
        chromeDriver.close();

    }
}
